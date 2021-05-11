package hzcc.service.impl;

import java.util.List;

import hzcc.dao.IMemberDao;
import hzcc.domain.Member;
import hzcc.domain.Project;
import hzcc.web.commons.Page;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hzcc.dao.IAccountDao;
import hzcc.domain.Account;
import hzcc.service.IAccountService;
/**
 * 用户的业务层实现类
 * @author likai
 *
 */
@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
public class AccountServiceImpl implements IAccountService {
    private IAccountDao accountDao;
    private IMemberDao memberDao;

    public void setMemberDao(IMemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<Account> findAllAccount(DetachedCriteria dCriteria) {
        // TODO Auto-generated method stub
        return accountDao.findAll(dCriteria);
    }

    @Override
    public Page findAllMember(DetachedCriteria dCriteria, Integer num) {
        //1.准备当前页信息
        int currentPageNum=1;
        if(num!=null) {
            currentPageNum=num;
        }
        //2.获得总记录条数
        int totalRecords=memberDao.findTotalRecords(dCriteria);
        //3.创建一个page
        Page page=new Page(currentPageNum, totalRecords);
        //4.使用page对象中的数据，查询带有分页的结果集
        List<Member> records=memberDao.findAll(dCriteria, page.getStartIndex(), page.getPageSize());
        //5.把查询出来的结果封装到page对象中
        page.setRecords(records);
        //6.返回page对象
        return page;
    }

    @Override
    @Transactional(readOnly=false,propagation=Propagation.REQUIRED)
    public void save(Account account, Member member) {
        // TODO Auto-generated method stub
        accountDao.save(account);
        memberDao.save(member);
    }

    @Override
    @Transactional(readOnly=false,propagation=Propagation.REQUIRED)
    public void removeAccount(String userID) {
        // TODO Auto-generated method stub
        accountDao.delete(userID);
        memberDao.delete(userID);
    }

    @Override
    public Account findAccountById(String userID) {
        // TODO Auto-generated method stub
        return accountDao.findById(userID);
    }

    @Override
    public Member findMemberById(String mebID) {
        // TODO Auto-generated method stub
        return memberDao.findById(mebID);
    }

    @Override
    @Transactional(readOnly=false,propagation=Propagation.REQUIRED)
    public void update(Account account) {
        // TODO Auto-generated method stub
        accountDao.update(account);
    }

    @Override
    @Transactional(readOnly=false,propagation=Propagation.REQUIRED)
    public void updateMember(Member member) {
        // TODO Auto-generated method stub
        memberDao.update(member);
    }

}
