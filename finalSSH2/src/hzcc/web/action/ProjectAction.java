package hzcc.web.action;

import com.opensymphony.xwork2.ActionSupport;
import hzcc.domain.Department;
import hzcc.domain.Project;
import hzcc.service.IProjectService;
import hzcc.web.commons.Page;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class ProjectAction extends ActionSupport {
    //模型驱动使用的对象
    private Project project=new Project();
    private IProjectService projectService;
    private Page page;
    private Integer number;
    private List<Department> departments;

    public void setProjectService(IProjectService projectService) {
        this.projectService = projectService;
    }

    public String saveUI(){
        departments=projectService.findAllDepartment();
        return "saveUI";
    }

    public String editUI(){
        project=projectService.findProjectById(project.getProjID());
        departments=projectService.findAllDepartment();
        return "editUI";
    }

    public String removeProject(){
        System.out.println("----removeProject---");
        System.out.println(project);
        System.out.println(project.getProjID());
        projectService.removeProject(project.getProjID());
        return "list";
    }

    public String findAllProject(){
        System.out.println();
        System.out.println("----findAllProject---");
        System.out.println(project);
        System.out.println(number);

        //1.定义离线对象
        DetachedCriteria dCriteria= DetachedCriteria.forClass(Project.class);
        //2.拼装查询条件

        //判断是否输入了项目名
        if(StringUtils.isNotBlank(project.getProjName())) {
            //模糊查询项目名
            dCriteria.add(Restrictions.like("projName", "%"+project.getProjName()+"%"));
        }

        //判断是否输入了部门ID
        if(StringUtils.isNotBlank(project.getDepID())) {
            //模糊查询部门ID
            dCriteria.add(Restrictions.like("depID", "%"+project.getDepID()+"%"));
        }

        //3.根据离线对象查询客户信息
        page=projectService.findAllProject(dCriteria,number);
        departments= projectService.findAllDepartment();

        return "findAll";
    }

    public String save(){
        System.out.println("ProjectAction中的save方法执行了......");
        projectService.save(project);
        return SUCCESS;
    }

    public String update(){
        projectService.update(project);
        System.out.println(project);
        return SUCCESS;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

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

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }
}
