package hzcc.test;

import java.util.List;

import hzcc.domain.*;
import hzcc.service.*;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import hzcc.web.commons.Page;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 测试客户的业务层方法
 * @author likai
 *
 */
@RunWith(SpringJUnit4ClassRunner.class) //Junit4的写法
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class CustomerServiceTest {

	@Autowired
	private IProjectService ps;
	@Autowired
	private IAccountService as;
	@Autowired
	private IDepartmentService ds;
	@Autowired
	private IOrderService os;


	@Test
	public void testFindAllMember() {
		DetachedCriteria dCriteria=DetachedCriteria.forClass(Member.class);
		dCriteria.add(Restrictions.like("mebName", "%%"));
		Page page=as.findAllMember(dCriteria,1);
		for(Member p:(List<Member>)page.getRecords()) {
			System.out.println(p);
		}

	}

	@Test
	public void testFindAllProject() {
		DetachedCriteria dCriteria=DetachedCriteria.forClass(Project.class);
		dCriteria.add(Restrictions.like("projName", "%%"));
		Page page=ps.findAllProject(dCriteria,1);
		for(Project p:(List<Project>)page.getRecords()) {
			System.out.println(p);
		}

	}
	@Test
	public void testSaveProject() {
		Project project=new Project();
		project.setProjID("P0932");
		project.setProjName("项目0932");
		project.setUnit("日");
		project.setDepID("D0001");
		project.setPrice(93.4f);

		ps.save(project);
		ps.update(project);
		
	}
	@Test
	public void testdelProject() {
		ps.removeProject("P0932");
	}
	@Test
	public void testfindAllAccount() {
		DetachedCriteria dCriteria=DetachedCriteria.forClass(Account.class);
		dCriteria.add(Restrictions.like("userID", "%%"));
		List<Account> list=as.findAllAccount(dCriteria);
		for(Account a:list) {
			System.out.println(a);
		}
	}
	@Test
	public void testUpdateAccount() {
		Account account=new Account();
		account.setUserID("M0088");
		account.setPwd("123");
		account.setKind(1);

//		as.save(account);
		account.setPwd("456");
		as.update(account);
		
	}
	@Test
	public void deleteAccount() {
		as.removeAccount("M0088");
	}
	
	@Test
	public void testFindAllDepartment() {
		DetachedCriteria dCriteria=DetachedCriteria.forClass(Department.class);
		dCriteria.add(Restrictions.like("depID", "%%"));
		List<Department> list=ds.findAllDepartment(dCriteria);
		for(Department d:list) {
			System.out.println(d);
		}
	}

	@Test
	public void testSaveDepartment() {
		Department department=new Department();
		department.setDepID("D0987");
		department.setDepName("asdgv");
		department.setPhone("123123123");

//		ds.save(department);
		department.setDepName("cvbcvbcvb");
		ds.update(department);

	}

	@Test
	public void testDelDepartment() {
		ds.removeDepartment("D0987");
	}

	@Test
	public void testFindAllOrder() {
		DetachedCriteria dCriteria=DetachedCriteria.forClass(Order.class);
		dCriteria.add(Restrictions.like("projID", "%%"));
		Page page=os.findAllOrder(dCriteria,1);
		for(Order p:(List<Order>)page.getRecords()) {
			System.out.println(p);
		}
	}

	@Test
	public void testSaveOrder() {
		Order order=new Order();
		order.setOrderID(17l);
		order.setMebID("M0001");
		order.setProjID("P0001");
		order.setNum(5);
		order.setAppotime("2020/5/21");
		order.setState("完成");

//		os.saveOrder(order);
		order.setNum(14);
		os.updateOrder(order);
	}

	@Test
	public void getAllMembers() {
		DetachedCriteria dCriteria=DetachedCriteria.forClass(Member.class);
		List<Member> list=os.findAllMember();
		for(Member member:list) {
			System.out.println(member);
		}
	}

}
