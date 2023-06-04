package domain;

import javax.persistence.*;

@Entity
@Table(name = "stud_info")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stud_id")
    private int  studId;
    @Column(name = "stud_name")
    private String studName;
    @Column(name = "stud_contact")
    private long studCont;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "education_fk")
    private Education educationRef;

    public int getStudId() {
        return studId;
    }

    public void setStudId(int studId) {
        this.studId = studId;
    }

    public String getStudName() {
        return studName;
    }

    public void setStudName(String studName) {
        this.studName = studName;
    }

    public long getStudCont() {
        return studCont;
    }

    public void setStudCont(long studCont) {
        this.studCont = studCont;
    }

    public Education getEducationRef() {
        return educationRef;
    }

    public void setEducationRef(Education educationRef) {
        this.educationRef = educationRef;
    }
}
