package hzcc.service;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import hzcc.domain.Department;
/**
 * 部门的业务层接口
 * @author likai
 *
 */
public interface IDepartmentService {
    /**
     * 查询部门列表
     * @param dCriteria	查询的条件
     * @return			封装好的分页信息
     */
    List<Department> findAllDepartment(DetachedCriteria dCriteria);
    /**
     * 保存部门
     * @param department
     */
    void save(Department department);
    /**
     * 根据id删除部门
     * @param depID
     */
    void removeDepartment(String depID);
    /**
     * 根据id查询部门信息
     * @param depID
     * @return
     */
    Department findDepartmentById(String depID);
    /**
     * 更新部门
     * @param department
     */
    void update(Department department);

}
