package manytomany;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Emp {
    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public Emp(int eid, String empName, List<Project> projects) {
        this.eid = eid;
        this.empName = empName;
        this.projects = projects;
    }

    @Id
    private int eid;
    @Column(name = "emp_name")
    private String empName;
    @ManyToMany
    @JoinTable(name = "emp_joined",
            joinColumns ={@JoinColumn (name = "eid")} ,
            inverseJoinColumns = {@JoinColumn(name = "pid")})
    private List<Project> projects ;

    public Emp() {
    }
}
