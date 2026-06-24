package manytomany;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity
public class Project {
    @Id
     private int pid;
     @Column(name = "project_name")
     private String projectName;

    public Project() {
        super();
    }

    public Project(int pid, String projectName, List<Emp> emps) {
        this.pid = pid;
        this.projectName = projectName;
        this.emps = emps;
    }

    public List<Emp> getEmps() {
        return emps;
    }

    public void setEmps(List<Emp> emps) {
        this.emps = emps;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    @ManyToMany(mappedBy ="projects")
     private List <Emp> emps;

}
