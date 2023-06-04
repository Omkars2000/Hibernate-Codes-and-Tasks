package domain;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "dept")
public class Dept {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "deptno")
    private  int deptno;
    @Column(name = "dept_name")
    private String deptname;
    @OneToMany(mappedBy = "deptRef",cascade = CascadeType.ALL)
    private List<Emp> empList;

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public List<Emp> getEmpList() {
        return empList;
    }

    public void setEmpList(List<Emp> empList) {
        this.empList = empList;
    }
    public void addEmp(Emp empRef){
        if(empList==null){
            empList= new LinkedList<>();
        }
        empList.add(empRef);
        empRef.setDeptRef(this);
    }

    @Override
    public String toString() {
        return getDeptno()+"\t"+getDeptname();
    }
}
