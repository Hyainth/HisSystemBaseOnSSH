package hzcc.web.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import hzcc.domain.Member;
import hzcc.web.commons.Page;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;


import com.opensymphony.xwork2.ActionSupport;

import hzcc.domain.Account;
import hzcc.service.IAccountService;

public class AccountAction extends ActionSupport implements SessionAware{
    private IAccountService accountService;
    private Member member=new Member();
    private Account account=new Account();
    private String message="正在登录";
    private Map<String, Object> session;
    private String oldpwd;
    private String pwd;
    private String myerrorMessage="";
    private Page page;
    private Integer number;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getMyerrorMessage() {
        return myerrorMessage;
    }

    public void setMyerrorMessage(String myerrorMessage) {
        this.myerrorMessage = myerrorMessage;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public String getOldpwd() {
        return oldpwd;
    }

    public void setOldpwd(String oldpwd) {
        this.oldpwd = oldpwd;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }

    public IAccountService getAccountService() {
        return accountService;
    }

    public Map<String, Object> getSession() {
        return session;
    }

    public Account getAccount() {
        return account;
    }
    public void setAccount(Account account) {
        this.account = account;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String login() {
        System.out.println("-----login------");
        //1.定义离线对象
        DetachedCriteria dCriteria=DetachedCriteria.forClass(Account.class);
        //2.拼装查询条件
        //判断是否输入了用户账户
        if(StringUtils.isNotBlank(account.getUserID())) {
            //查询用户账户
            dCriteria.add(Restrictions.eq("userID",account.getUserID()));
        }

        if(StringUtils.isNotBlank(account.getPwd())) {
            //查询用户账户
//            dCriteria.add(Restrictions.eq("pwd",GlobalUtils.md5Encode(account.getPwd())));
            dCriteria.add(Restrictions.eq("pwd",account.getPwd()));
        }
        //3.根据离线对象查询用户信息
        List<Account> accounts=accountService.findAllAccount(dCriteria);
        if(accounts.size()==1) {
            System.out.println("-----login---SUCCESS---");
            session.put("account", accounts.get(0));
            return SUCCESS;
        }else {
            message="登录失败，请重试";
            System.out.println("-----login---FAIL---");
            return LOGIN;
        }
    }

    public String pwdUI(){
            return "pwdUI";
    }

    public String changePWD(){
        account=(Account) session.get("account");
        if (account.getPwd().equals(oldpwd)){
            account.setPwd(pwd);
            accountService.update(account);
            session.put("account",account);
            return "finish";
        }else {
            myerrorMessage="原密码错误！";
            return "myerror";
        }
    }

    public String registerUI(){
        return "registerUI";
    }

    public String register(){
        String resdate = new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString();

        account.setUserID(member.getMebID());
        account.setKind(1);
        member.setResdate(resdate);

        accountService.save(account,member);
        return "login";
    }

    public String findAllMember(){
        System.out.println();
        System.out.println("----findAllMember---");
        System.out.println(member);
        System.out.println(number);

        //1.定义离线对象
        DetachedCriteria dCriteria= DetachedCriteria.forClass(Member.class);
        //2.拼装查询条件

        //判断是否输入了项目名
        if(StringUtils.isNotBlank(member.getMebName())) {
            //模糊查询项目名
            dCriteria.add(Restrictions.like("mebName", "%"+member.getMebName()+"%"));
        }

        //3.根据离线对象查询客户信息
        page=accountService.findAllMember(dCriteria,number);

        return "findAll";
    }

    public String editUI(){
        member=accountService.findMemberById(member.getMebID());
        return "editUI";
    }

    public String editMy(){
        account=(Account)session.get("account");
        member.setMebID(account.getUserID());
        member=accountService.findMemberById(member.getMebID());
        return "editUI";
    }

    public String update(){
        accountService.updateMember(member);

        return "finish";
    }



    public String logout() {
        session.clear();
        return LOGIN;
    }

    public String removeMember(){
        try {
            accountService.removeAccount(member.getMebID());
            return "list";
        }catch (Exception e){
            myerrorMessage="该用户存在业务，无法删除!";
            return "myerror";
        }
    }

    @Override
    public void setSession(Map<String, Object> arg0) {
        this.session=arg0;
    }

}
