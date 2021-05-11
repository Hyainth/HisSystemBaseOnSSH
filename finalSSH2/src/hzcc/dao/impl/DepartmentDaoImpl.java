package hzcc.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.HibernateTemplate;

import hzcc.dao.IDepartmentDao;
import hzcc.domain.Department;
/**
 * 部门的持久层实现类
 * @author likai
 *
 */
public class DepartmentDaoImpl implements IDepartmentDao {
    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public List<Department> findAll() {
        return (List<Department>) hibernateTemplate.loadAll(Department.class);
    }

    @Override
    public List<Department> findAll(DetachedCriteria dCriteria) {
        return (List<Department>) hibernateTemplate.findByCriteria(dCriteria);
    }

    @Override
    public void save(Department department) {
        hibernateTemplate.save(department);
    }

    @Override
    public void delete(String depID) {
        Department department=findById(depID);
        hibernateTemplate.delete(department);
    }

    @Override
    public Department findById(String depID) {
        return hibernateTemplate.get(Department.class, depID);
    }

    @Override
    public void update(Department department) {
        hibernateTemplate.update(department);
    }

}
