package hzcc.web.action;
import java.util.List;
import java.util.Map;

import hzcc.domain.*;
import hzcc.web.commons.Page;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionSupport;

import hzcc.service.IOrderService;

public class OrderAction extends ActionSupport implements SessionAware {
    private IOrderService orderService;
    private Order order=new Order();
    private List<Order> orders;
    private Map<String, Object> session;
    private Page page;
    private Integer number;
    private List<Project> projects;
    private List<Member> members;
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public IOrderService getOrderService() {
        return orderService;
    }

    public Map<String, Object> getSession() {
        return session;
    }

    public Page getPage() {
        return page;
    }

    public Integer getNumber() {
        return number;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setOrderService(IOrderService orderService) {
        this.orderService = orderService;
    }
    public Order getOrder() {
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }

    public List<Order> getOrders() {
        return orders;
    }
    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public String save() {
        System.out.println("OrderAction中的save方法执行了......");
        orderService.saveOrder(order);
        return SUCCESS;
    }

    public String update() {
        System.out.println("OrderAction中的update方法执行了......");
        orderService.updateOrder(order);
        return SUCCESS;
    }

    public String saveUI() {
        projects= orderService.findAllProject();
        members=orderService.findAllMember();

        return "saveUI";
    }

    public String editUI() {
        order=orderService.findOrderById(order.getOrderID());

        projects= orderService.findAllProject();
        members=orderService.findAllMember();
        return "editUI";
    }

    public String payUI() {
        order=orderService.findOrderById(order.getOrderID());

        return "payUI";
    }

    public String pay() {
        order=orderService.findOrderById(order.getOrderID());
        order.setState("待就诊");
        orderService.updateOrder(order);

        return "mylist";
    }

    public String findMyOrder(){
        DetachedCriteria dCriteria=DetachedCriteria.forClass(Order.class);
        System.out.println(order);

        Account account=(Account) session.get("account");
        String userID=account.getUserID();

        if(StringUtils.isNotBlank(userID)) {
            dCriteria.add(Restrictions.eq("mebID", userID));
        }

        if(StringUtils.isNotBlank(order.getProjID())) {
            dCriteria.add(Restrictions.eq("projID", order.getProjID()));
        }
        page=orderService.findAllOrder(dCriteria,number);
        projects= orderService.findAllProject();
        members=orderService.findAllMember();
        return "findMine";
    }

    public String findAllOrder(){
        DetachedCriteria dCriteria=DetachedCriteria.forClass(Order.class);
        System.out.println(order);

        if(StringUtils.isNotBlank(order.getProjID())) {
            dCriteria.add(Restrictions.eq("projID", order.getProjID()));
        }

        if(StringUtils.isNotBlank(order.getMebID())) {
            dCriteria.add(Restrictions.like("mebID", "%"+order.getMebID()+"%"));
        }

        page=orderService.findAllOrder(dCriteria,number);
        projects= orderService.findAllProject();
        members=orderService.findAllMember();
        return "findAll";
    }

    public String savemyorder(){
        Account account=(Account) session.get("account");
        String userID=account.getUserID();
        order.setMebID(userID);
        order.setState("待支付");
        orderService.saveOrder(order);

        message="预约项目成功!"+
        "\n项目ID="+order.getProjID()+
                "\n数量为"+order.getNum()+
                "\n预约时间为"+order.getAppotime();

        return "savemyorder";
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session=map;
    }
}
