package hzcc.dao;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import hzcc.domain.Account;
/**
 * 用户的持久层接口
 * @author likai
 *
 */
public interface IAccountDao {

    /**
     *
     * 查询用户列表
     * @param dCriteria		查询的条件
     * @return
             */
    public List<Account> findAll(DetachedCriteria dCriteria);
    /**
     * 保存用户
     * @param account
     */
    public void save(Account account);
    /**
     * 根据id删除用户
     * @param userID
     */
    public void delete(String userID);

    /**
     * 根据id查找用户
     * @param userID
     * @return
     */
    public Account findById(String userID) ;

    /**
     * 更新用户
     * @param account
     */
    public void update(Account account);
}
