package hzcc.service.impl;

import hzcc.dao.IMemberDao;
import hzcc.dao.IOrderDao;
import hzcc.dao.IProjectDao;
import hzcc.domain.Department;
import hzcc.domain.Member;
import hzcc.domain.Order;
import hzcc.domain.Project;
import hzcc.service.IOrderService;
import hzcc.web.commons.Page;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly=true,propagation= Propagation.SUPPORTS)
public class OrderServiceImpl implements IOrderService {
    private IOrderDao orderDao;
    private IProjectDao projectDao;
    private IMemberDao memberDao;

    public void setOrderDao(IOrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public void setProjectDao(IProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    public void setMemberDao(IMemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @Override
    @Transactional(readOnly=false,propagation= Propagation.REQUIRED)
    public void saveOrder(Order order) {
        orderDao.save(order);
    }

    @Override
    @Transactional(readOnly=false,propagation= Propagation.REQUIRED)
    public void updateOrder(Order order) {
        orderDao.update(order);
    }

    @Override
    public Order findOrderById(Long orderID) {
        return orderDao.findById(orderID);
    }

    @Override
    public Page findAllOrder(DetachedCriteria dCriteria, Integer num) {
        //1.准备当前页信息
        int currentPageNum=1;
        if(num!=null) {
            currentPageNum=num;
        }
        //2.获得总记录条数
        int totalRecords=orderDao.findTotalRecords(dCriteria);
        //3.创建一个page
        Page page=new Page(currentPageNum, totalRecords);
        //4.使用page对象中的数据，查询带有分页的结果集
        List<Order> records=orderDao.findAll(dCriteria, page.getStartIndex(), page.getPageSize());
        //5.把查询出来的结果封装到page对象中
        page.setRecords(records);
        //6.返回page对象
        return page;
    }

    @Override
    public List<Project> findAllProject() {
        return projectDao.findAll();
    }

    @Override
    public List<Member> findAllMember() {
        return memberDao.findAll();
    }
}
