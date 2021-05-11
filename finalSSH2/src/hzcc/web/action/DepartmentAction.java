package hzcc.web.action;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionSupport;

import hzcc.domain.Department;
import hzcc.service.IDepartmentService;

public class DepartmentAction extends ActionSupport{
    private IDepartmentService departmentService;
    private Department department=new Department();
    private List<Department> departments;

    public void setDepartmentService(IDepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    public Department getDepartment() {
        return department;
    }
    public void setDepartment(Department department) {
        this.department = department;
    }
    public List<Department> getDepartments() {
        return departments;
    }
    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }
    /**
     * 跳转到部门添加页面
     * @return
     */
    public String saveUI() {
        return "saveUI";
    }
    /**
     * 跳转到部门修改页面
     * @return
     */
    public String editUI() {
        //根据id查找要编辑的客户信息
        //使用模型接收
        department= departmentService.findDepartmentById(department.getDepID());
        return "editUI";
    }
    /**
     * 删除部门
     * @return
     */
    public String removeDepartment() {
        System.out.println("----removeDepartment---");
        System.out.println(department);
        System.out.println(department.getDepID());
        departmentService.removeDepartment(department.getDepID());
        return "list";
    }
    /**
     * 查询部门列表
     * @return
     */
    public String findAllDepartment() {
        System.out.println("----findAllDepartment---");
        System.out.println(department);
        //1.定义离线对象
        DetachedCriteria dCriteria=DetachedCriteria.forClass(Department.class);
        //2.拼装查询条件
        //判断是否输入了部门名称
        if(StringUtils.isNotBlank(department.getDepName())) {
            //模糊查询客户名称
            dCriteria.add(Restrictions.like("depName", "%"+department.getDepName()+"%"));
        }
        //3.根据离线对象查询部门信息	
        departments=departmentService.findAllDepartment(dCriteria);
        return "findAll";
    }


    /**
     * 保存部门
     * @return
     */
    public String save() {
        System.out.println("departmentAction中的save方法执行了......");
        departmentService.save(department);
        System.out.print(department);
        return SUCCESS;
    }
    /**
     * 更新部门
     * @return
     */
    public String update() {
        departmentService.update(department);
        System.out.print(department);
        return SUCCESS;
    }



}
