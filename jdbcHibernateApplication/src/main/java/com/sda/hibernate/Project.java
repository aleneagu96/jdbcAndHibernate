package com.sda.hibernate;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name="projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer projectId;
    private String description;
    @ManyToMany(mappedBy = "projects")  // Name of the property from THE OTHER java entity
    private Set<Employee> employees = new HashSet<>();
    public Integer getProjectId() {
        return projectId;
    }
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Set<Employee> getEmployees() {
        return employees;
    }
    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", description='" + description + '\'' +
                '}';
    }
}