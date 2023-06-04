package domain;


import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "course_info")
public class Course {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "course_id")
    private int courseId;

    @Column(name = "course_name")
    private String courseName;

  @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "course_ref"),
            inverseJoinColumns=@JoinColumn(name = "student_ref")
    )
    private List<Student> studentList;

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public Course() {
    }


    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void addStudent(Student studentRef) {
        if (studentList == null) {
            // for DQL create object of ArrayList
            // Object of LinkedList created Because we have to perform DML Operations
            studentList = new LinkedList<>();
        }
        studentList.add(studentRef);
    }

    @Override
    public String toString() {
        return courseName;
    }
}
