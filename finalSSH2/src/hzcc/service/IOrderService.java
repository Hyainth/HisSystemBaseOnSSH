package hzcc.service;

import java.util.List;

import hzcc.domain.Department;
import hzcc.domain.Member;
import hzcc.domain.Project;
import hzcc.web.commons.Page;
import org.hibernate.criterion.DetachedCriteria;

import hzcc.domain.Order;

/**
 * 预约信息的业务层接口
 * @author likai
 *
 */
public interface IOrderService {


    void saveOrder(Order order);

    void updateOrder(Order order);

    Order findOrderById(Long orderID);

    Page findAllOrder(DetachedCriteria dCriteria, Integer num);

    List<Project> findAllProject();

    List<Member> findAllMember();
}
