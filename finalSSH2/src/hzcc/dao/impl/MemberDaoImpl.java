package hzcc.dao.impl;

import hzcc.dao.IMemberDao;
import hzcc.domain.Member;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.util.List;

public class MemberDaoImpl implements IMemberDao {
    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public List<Member> findAll() {
        return hibernateTemplate.loadAll(Member.class);
    }

    @Override
    public void save(Member member) {
        hibernateTemplate.save(member);
    }

    @Override
    public int findTotalRecords(DetachedCriteria dCriteria) {
        dCriteria.setProjection(Projections.count("mebID"));//把 select *变成了select count(*)
        List<Long> list=(List<Long>)hibernateTemplate.findByCriteria(dCriteria);
        return list.isEmpty()?0:list.get(0).intValue();
    }

    @Override
    public List<Member> findAll(DetachedCriteria dCriteria, int firstResult, int maxResult) {
        dCriteria.setProjection(null);
        return (List<Member>) hibernateTemplate.findByCriteria(dCriteria,firstResult,maxResult);
    }

    @Override
    public void delete(String mebID) {
        Member member=findById(mebID);
        System.out.println(member);
        hibernateTemplate.delete(member);
    }

    @Override
    public Member findById(String mebID) {
        return hibernateTemplate.get(Member.class,mebID);
    }

    @Override
    public void update(Member member) {
        hibernateTemplate.update(member);
    }
}
