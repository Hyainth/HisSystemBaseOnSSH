package hzcc.dao;

import java.util.List;

import hzcc.domain.Project;
import org.hibernate.criterion.DetachedCriteria;
import hzcc.domain.Order;

/**
 * 预约信息的持久层接口
 * @author likai
 *
 */
public interface IOrderDao {

    public void save(Order order);

    public void update(Order order);

    public int findTotalRecords(DetachedCriteria dCriteria);

    public Order findById(Long orderID) ;

    public List<Order> findAll(DetachedCriteria dCriteria, int firstResult, int maxResult);

}
