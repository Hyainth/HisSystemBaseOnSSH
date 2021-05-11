package hzcc.service.impl;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hzcc.dao.IDepartmentDao;
import hzcc.domain.Department;
import hzcc.service.IDepartmentService;

/**
 * 部门的业务层实现类
 * @author likai
 *
 */
@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
public class DepartmentServiceImpl implements IDepartmentService {
    private IDepartmentDao departmentDao;

    public void setDepartmentDao(IDepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Override
    public List<Department> findAllDepartment(DetachedCriteria dCriteria) {
        // TODO Auto-generated method stub
        return departmentDao.findAll(dCriteria);
    }

    @Override
    @Transactional(readOnly=false,propagation=Propagation.REQUIRED)
    public void save(Department department) {
        // TODO Auto-generated method stub
        departmentDao.save(department);
    }

    @Override
    @Transactional(readOnly=false,propagation=Propagation.REQUIRED)
    public void removeDepartment(String depID) {
        // TODO Auto-generated method stub
        departmentDao.delete(depID);

    }

    @Override
    public Department findDepartmentById(String depID) {
        // TODO Auto-generated method stub
        return departmentDao.findById(depID);
    }

    @Override
    @Transactional(readOnly=false,propagation=Propagation.REQUIRED)
    public void update(Department department) {
        // TODO Auto-generated method stub
        departmentDao.update(department);
    }



}
