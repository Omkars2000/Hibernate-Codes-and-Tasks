package domain;

import javax.persistence.*;

@Entity
@Table(name = "stud_info")
public class Student {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "stud_id")
    private int studentId;
    @Column(name = "stud_name")
   private String studentName;
    @Column(name = "stud_contact")
    private long studentContact;
     @OneToOne(cascade = CascadeType.ALL)
     @JoinColumn(name = "education_fk")
    private Education educationRef;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }





    public long getStudentContact() {
        return studentContact;
    }

    public void setStudentContact(long studentContact) {
        this.studentContact = studentContact;
    }

    public Education getEducationRef() {
        return educationRef;
    }

    public void setEducationRef(Education educationRef) {
        this.educationRef = educationRef;
    }

    @Override
    public String toString() {
        return getStudentId()+"\t"+getStudentName()+"\t"+getStudentContact()+"\t"+getEducationRef();
    }
}
