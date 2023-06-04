package domain;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private int empId;
    @Column(name = "emp_name")
    private String empName;
    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    @JoinTable(
            name = "employee_duty",
            joinColumns = @JoinColumn(name = "emp_ref"),
            inverseJoinColumns = @JoinColumn(name = "duty_ref")
    )
    private List<Duty_shift> duty_shiftList;

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public List<Duty_shift> getDuty_shiftList() {
        return duty_shiftList;
    }

    public void setDuty_shiftList(List<Duty_shift> duty_shiftList) {
        this.duty_shiftList = duty_shiftList;
    }
    public void addDuty(Duty_shift duty_shiftRef){
        if(duty_shiftList==null){
            duty_shiftList=new LinkedList<>();
        }
        duty_shiftList.add(duty_shiftRef);
    }

    @Override
    public String toString() {
        return getEmpId()+"\t"+getEmpName();
    }
}
