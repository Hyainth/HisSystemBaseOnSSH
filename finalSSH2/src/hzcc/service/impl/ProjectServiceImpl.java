package hzcc.service.impl;


import hzcc.dao.IDepartmentDao;
import hzcc.dao.IProjectDao;
import hzcc.domain.Department;
import hzcc.domain.Project;
import hzcc.service.IProjectService;
import hzcc.web.commons.Page;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly=true,propagation= Propagation.SUPPORTS)
public class ProjectServiceImpl implements IProjectService {
    private IProjectDao projectDao;
    private IDepartmentDao departmentDao;

    public void setProjectDao(IProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    public void setDepartmentDao(IDepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Override
    public Page findAllProject(DetachedCriteria dCriteria, Integer num) {
        //1.准备当前页信息
        int currentPageNum=1;
        if(num!=null) {
            currentPageNum=num;
        }
        //2.获得总记录条数
        int totalRecords=projectDao.findTotalRecords(dCriteria);
        //3.创建一个page
        Page page=new Page(currentPageNum, totalRecords);
        //4.使用page对象中的数据，查询带有分页的结果集
        List<Project> records=projectDao.findAll(dCriteria, page.getStartIndex(), page.getPageSize());
        //5.把查询出来的结果封装到page对象中
        page.setRecords(records);
        //6.返回page对象
        return page;
    }

    @Override
    @Transactional(readOnly=false,propagation= Propagation.REQUIRED)
    public void save(Project project) {
        projectDao.save(project);
    }

    @Override
    @Transactional(readOnly=false,propagation= Propagation.REQUIRED)
    public void removeProject(String projID) {
        projectDao.delete(projID);
    }

    @Override
    public Project findProjectById(String projID) {
        return projectDao.findById(projID);
    }

    @Override
    @Transactional(readOnly=false,propagation= Propagation.REQUIRED)
    public void update(Project project) {
        projectDao.update(project);
    }

    @Override
    public List<Department> findAllDepartment() {
        return departmentDao.findAll();
    }
}
