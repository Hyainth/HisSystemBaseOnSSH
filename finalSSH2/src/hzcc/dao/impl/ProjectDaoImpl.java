package hzcc.dao.impl;

import hzcc.dao.IProjectDao;
import hzcc.domain.Project;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.util.List;

public class ProjectDaoImpl implements IProjectDao {
    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public List<Project> findAll() {
        return hibernateTemplate.loadAll(Project.class);
    }

    @Override
    public void save(Project project) {
        hibernateTemplate.save(project);
    }

    @Override
    public int findTotalRecords(DetachedCriteria dCriteria) {
        dCriteria.setProjection(Projections.count("projID"));//把 select *变成了select count(*)
        List<Long> list=(List<Long>)hibernateTemplate.findByCriteria(dCriteria);
        return list.isEmpty()?0:list.get(0).intValue();
    }

    @Override
    public List<Project> findAll(DetachedCriteria dCriteria, int firstResult, int maxResult) {
        dCriteria.setProjection(null);
        return (List<Project>) hibernateTemplate.findByCriteria(dCriteria,firstResult,maxResult);
    }

    @Override
    public void delete(String projID) {
        Project project=findById(projID);
        System.out.println(project);
        hibernateTemplate.delete(project);
    }

    @Override
    public Project findById(String projID) {
        return hibernateTemplate.get(Project.class,projID);
    }

    @Override
    public void update(Project project) {
        hibernateTemplate.update(project);
    }
}
