package hzcc.dao;

import hzcc.domain.Member;
import hzcc.domain.Member;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public interface IMemberDao {
    List<Member> findAll();
    /**
     *
     * 查询会员列表
     * @param dCriteria		查询的条件
     * @return
     */

    /**
     * 保存客户
     * @param member
     */
    public void save(Member member);

    /**
     * 查询总记录条数
     * @param dCriteria	查询条件
     * @return
     */
    public int findTotalRecords(DetachedCriteria dCriteria);

    /**
     *
     * 查询会员列表
     * @param dCriteria		查询的条件
     * @param firstResult	查询的开始记录索引
     * @param maxResult		每次查询记录的条数
     * @return
     */
    public List<Member> findAll(DetachedCriteria dCriteria, int firstResult, int maxResult);

    /**
     * 根据id删除会员
     * @param mebID
     */
    public void delete(String mebID);

    /**
     * 根据id查找会员
     * @param mebID
     * @return
     */
    public Member findById(String mebID) ;

    /**
     * 更新会员
     * @param member
     */
    public void update(Member member);
}
