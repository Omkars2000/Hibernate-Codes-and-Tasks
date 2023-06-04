package domain;

import javax.persistence.*;

@Entity
@Table(name = "emp")
public class Emp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_no")
    private  int empNo;
    @Column(name = "emp_name")
    private String empName;
    @Column(name = "emp_desig")
    private String empDesig;
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH,CascadeType.PERSIST})
    @JoinColumn (name = "deptno_ref")
    private Dept deptRef;

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpDesig() {
        return empDesig;
    }

    public void setEmpDesig(String empDesig) {
        this.empDesig = empDesig;
    }

    public Dept getDeptRef() {
        return deptRef;
    }

    public void setDeptRef(Dept deptRef) {
        this.deptRef = deptRef;
    }

    @Override
    public String toString() {
        return getEmpNo()+"\t"+getEmpName()+"\t"+getEmpDesig();
    }
}
