package hzcc.service;

import hzcc.domain.Department;
import hzcc.domain.Project;
import hzcc.web.commons.Page;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

/**
 * 员工的业务层接口
 * @author likai
 *
 */
public interface IProjectService {
    /**
     * 查询项目列表
     * @param dCriteria	查询的条件
     * @param num		当前页
     * @return			封装好的分页信息
     */
    Page findAllProject(DetachedCriteria dCriteria, Integer num);
    /**
     * 保存项目
     * @param project
     */
    void save(Project project);
    /**
     * 根据id删除项目
     * @param projID
     */
    void removeProject(String projID);
    /**
     * 根据id查询项目信息
     * @param projID
     * @return
     */
    Project findProjectById(String projID);
    /**
     * 更新项目
     * @param project
     */
    void update(Project project);
    /**
     * 查询所有部门
     * @return
     */
    List<Department> findAllDepartment();
}
