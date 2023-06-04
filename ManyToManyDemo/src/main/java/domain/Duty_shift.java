package domain;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "duty_shift")
public class Duty_shift {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "duty_shift_id")
    private int dutyId;
    @Column(name = "duty_shift")
    private String dutyName;
    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    @JoinTable(
            name = "employee_duty",
            joinColumns = @JoinColumn(name = "duty_ref"),
           inverseJoinColumns = @JoinColumn(name = "emp_ref")
    )
    private List<Employee> employeeList;

    public int getDutyId() {
        return dutyId;
    }

    public void setDutyId(int dutyId) {
        this.dutyId = dutyId;
    }

    public String getDutyName() {
        return dutyName;
    }

    public void setDutyName(String dutyName) {
        this.dutyName = dutyName;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
    public void  addEmp(Employee employeeRef){
        if(employeeList==null){
            employeeList=new LinkedList<>();
        }
        employeeList.add(employeeRef);
    }

    @Override
    public String toString() {
        return getDutyId()+"\t"+getDutyName();
    }
}
