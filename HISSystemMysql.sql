drop database if exists Hospital;
create database Hospital DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
use Hospital;

drop table if exists Account;
create table Account   -- 建立账户表
(
	userID varchar(5) PRIMARY KEY,
	pwd varchar(15) not null,
	kind int not NULL        -- 0管理员 1用户
);

drop table if exists Member;
Create Table Member  -- 会员表
(
	mebID varchar(5) primary key check(mebID REGEXP "^[M][0-9]{4}$"),
	mebName varchar(20) not null,
	sex char(2) default '男' CHECK (sex in('男','女')) not null,
	phone varchar(15),
	resdate datetime not null    -- 注册日期
);

drop table if exists Department;
Create Table Department -- 科室表
(
	depID varchar(5) primary key check(depID REGEXP "^[D][0-9]{4}$"),
	depName varchar(20) not null unique,
	phone varchar(15)
);

drop table if exists Doctor;
Create Table Doctor -- 医生表
(
	docID varchar(5) primary key check(docID REGEXP "^[Y][0-9]{4}$"),
	docName varchar(20) not null,
	sex char(2) default '男' CHECK (sex in('男','女')) not null,
	depID varchar(5) not null,  -- 所属科室
	phone varchar(15),
	hiredate datetime,     -- 入职时间
	constraint FK_医生_depID foreign key(depID) references Department(depID)
);

drop table if exists Project;
Create Table Project -- 医疗项目表
(
	projID varchar(5) primary key check(projID REGEXP "^[P][0-9]{4}$"),
	projName varchar(20) not null unique,
	depID varchar(5),       -- 所属科室
	unit varchar(10),       -- 计量单位
	price float(5,2) not null,
	notes varchar(60),        -- 备注
	constraint FK_医疗项目_depID foreign key(depID) references Department(depID)
);

drop table if exists OrderInfo;
Create Table OrderInfo -- 就诊订单表
(
	OrderID int primary key AUTO_INCREMENT,   -- 订单流水号
	mebID varchar(5),           -- 就诊会员ID
	projID varchar(5),			-- 项目ID
	num int not null,
	appotime  datetime not null,         -- 预约时间
	state varchar(10) not null,          -- 订单状态
	constraint FK_就诊订单_mebID foreign key(mebID) references Member(mebID),
	constraint FK_就诊订单_projID foreign key(projID) references Project(projID)
);

Insert into Account values
('G0001','123',0),
('G0002','123',0),
('M0001','123',1),
('M0002','123',1),
('M0003','123',1),
('M0004','123',1);



Insert into Member values
('M0001','会员1','男','13111111111','2019/11/11'),
('M0002','会员2','男','13111111112','2019/11/11'),
('M0003','会员3','女','13111111113','2019/11/11'),
('M0004','会员4','女','13111111114','2019/11/11');




Insert into Department values
('D0001','内科','15111111111'),
('D0002','外科','15111111112'),
('D0003','眼科','15111111113'),
('D0004','急诊科','15111111114');


Insert into Doctor values
('Y0001','医生1','男','D0001','17111111111','2016/6/18'),
('Y0002','医生2','女','D0001','17111111112','2016/6/18'),
('Y0003','医生3','男','D0002','17111111113','2016/6/18'),
('Y0004','医生4','女','D0002','17111111114','2016/6/18'),
('Y0005','医生5','男','D0003','17111111114','2016/6/18'),
('Y0006','医生6','女','D0003','17111111114','2016/6/18'),
('Y0007','医生7','男','D0004','17111111114','2016/6/18'),
('Y0008','医生8','女','D0004','17111111114','2016/6/18');

Insert into Project values
('P0001','内科挂号','D0001','次',15,'收费为15元/次'),
('P0002','心脏检查','D0001','次',20,'收费为20元/次'),
('P0003','外科挂号','D0002','次',10,'收费为10元/次'),
('P0004','皮肤检查','D0002','次',20,'收费为20元/次'),
('P0005','眼科挂号','D0003','次',10,'收费为10元/次'),
('P0006','视力及色觉检查','D0003','次',20,'眼科检查项目'),
('P0007','急诊科挂号','D0004','次',15,'急诊费用15元/次'),
('P0008','门急诊留观诊查','D0004','日',5,'费用5元/日');

Insert into OrderInfo values
(null,'M0001','P0001',1,'2019/12/25','待支付'),
(null,'M0001','P0002',1,'2019/12/25','待支付'),
(null,'M0002','P0003',1,'2019/12/25','待就诊'),
(null,'M0002','P0004',1,'2019/12/25','待就诊'),
(null,'M0003','P0005',1,'2019/12/25','待就诊'),
(null,'M0003','P0006',1,'2019/12/25','待就诊'),
(null,'M0004','P0007',1,'2019/12/1','完成'),
(null,'M0004','P0008',10,'2019/12/1','完成');

-- 视图
use Hospital;

Create View 会员_预约
as
	select B.mebName'会员姓名',C.projName'项目名',A.appotime'预约时间',A.state'项目状态',C.price*A.num'价格'
	from OrderInfo A,Member B,Project C
	where A.mebID=B.mebID and A.projID=C.projID;

Create View 项目_收入
as
	select projName'项目名',SUM(price*num)'项目收入'
	from Project A,OrderInfo B
	where A.projID=B.projID
	group by projName;

Create View 科室_收入
as
	select depName'科室名',SUM(price*num)'科室收入' 
	from Project A,OrderInfo B,Department C
	where A.projID=B.projID and A.depID=c.depID
	group by depName;

Create View 医生公开信息
as
	select docName'姓名',sex'性别',depName'科室',Doctor.phone'工作电话'
	from Doctor,Department
	where Doctor.depID=Department.depID;

Create View 项目查询
as
	select A.projName'项目名',B.depName'科室名',price'价格',unit'单位',notes'备注'
	from Project A,Department B
	where A.depID=B.depID;
	

-- 建立索引:
create index Inx_Member on Member(mebID);
create index Inx_Doctor on Doctor(docID);
create index Inx_Project on Project(projID);
create index Inx_Department on Department(depID);


-- 功能：

-- 增加数据:
Insert into Account values
('M0005','123',1);

Insert into Member values
('M0005','会员5','男','13111111115','2019/11/11');

Insert into Department values
('D0005','耳鼻喉科','15111111115');

Insert into Doctor values
('Y0009','医生9','男','D0005','17111111115','2016/6/18');

Insert into Project(projID,projName,depID,unit,price) values
('P0009','耳鼻喉科挂号','D0005','次',20);

Insert into OrderInfo values
(null,'M0005','P0009',1,'2019/12/25','待支付');

-- 查询数据:
select * from Account;
select * from Member;
select * from Department;
select * from Doctor;
select * from Project;
select * from OrderInfo;

-- 修改数据:
update Account set pwd='456' where userID='M0005';
select * from Account where userID='M0005';

update Member set sex='女' where mebID='M0005';
select * from Member where mebID='M0005';

update Department set phone='13000000000' where depID='D0005';
select * from Department where depID='D0005';

update Doctor set phone='661' where docID='Y0009';
select * from Doctor where docID='Y0009';

update Project set notes='测试项目' where projID='P0009';
select * from  Project where projID='P0009';

update OrderInfo set appotime='2019/12/26' where mebID='M0005' and projID='P0009' and appotime='2019/12/25';
select * from OrderInfo where mebID='M0005' and projID='P0009';

-- 删除数据:
delete from OrderInfo where mebID='M0005' and projID='P0009' and appotime='2019/12/26';
delete from Project where projID='P0009';
delete from Doctor where docID='Y0009';
delete from Department where depID='D0005';
delete from Member where mebID='M0005';
delete from Account where userID='M0005';

-- 用户查看所有医疗项目
select * from 项目查询;

-- 查看可预约项目的医生
select * from 医生公开信息 where 科室='内科';

-- 预约-支付-就诊
Insert into OrderInfo values
(null,'M0001','P0008',4,'2019/12/25','待支付');
select * from 会员_预约;
update 会员_预约 set 项目状态='待就诊' where 会员姓名='会员1' and 项目名='门急诊留观诊查' and 预约时间='2019/12/25';
update 会员_预约 set 项目状态='完成' where 会员姓名='会员1' and 项目名='门急诊留观诊查' and 预约时间='2019/12/25';
-- 查看自己的医疗状态:
select * from 会员_预约 where 会员姓名='会员1';


