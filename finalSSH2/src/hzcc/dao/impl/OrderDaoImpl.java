package hzcc.dao.impl;

import hzcc.dao.IOrderDao;
import hzcc.domain.Order;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.util.List;

public class OrderDaoImpl implements IOrderDao {
    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public void save(Order order) {
        hibernateTemplate.save(order);
    }

    @Override
    public void update(Order order) {
        hibernateTemplate.update(order);
    }

    @Override
    public int findTotalRecords(DetachedCriteria dCriteria) {
        dCriteria.setProjection(Projections.count("orderID"));//把 select *变成了select count(*)
        List<Long> list=(List<Long>)hibernateTemplate.findByCriteria(dCriteria);
        return list.isEmpty()?0:list.get(0).intValue();
    }

    @Override
    public Order findById(Long orderID) {
        return hibernateTemplate.get(Order.class,orderID);
    }

    @Override
    public List<Order> findAll(DetachedCriteria dCriteria, int firstResult, int maxResult) {
        dCriteria.setProjection(null);
        return (List<Order>) hibernateTemplate.findByCriteria(dCriteria,firstResult,maxResult);
    }
}
