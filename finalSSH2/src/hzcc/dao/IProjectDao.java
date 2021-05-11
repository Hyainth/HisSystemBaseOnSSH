package hzcc.dao;

import hzcc.domain.Project;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public interface IProjectDao {
    /**
     * 查询项目列表
     * @return
     */
    List<Project> findAll();

    /**
     * 保存客户
     * @param project
     */
    public void save(Project project);

    /**
     * 查询总记录条数
     * @param dCriteria	查询条件
     * @return
     */
    public int findTotalRecords(DetachedCriteria dCriteria);

    /**
     *
     * 查询项目列表
     * @param dCriteria		查询的条件
     * @param firstResult	查询的开始记录索引
     * @param maxResult		每次查询记录的条数
     * @return
     */
    public List<Project> findAll(DetachedCriteria dCriteria, int firstResult, int maxResult);

    /**
     * 根据id删除项目
     * @param projID
     */
    public void delete(String projID);

    /**
     * 根据id查找项目
     * @param projID
     * @return
     */
    public Project findById(String projID) ;

    /**
     * 更新项目
     * @param project
     */
    public void update(Project project);

}
