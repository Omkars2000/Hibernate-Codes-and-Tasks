package demo;

import domain.Course;
import domain.Student;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class LogicalDisplay {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;
        cfg=new Configuration();
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(Student.class);
        cfg=cfg.addAnnotatedClass(Course.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

        Criteria crt1= ses.createCriteria(Course.class);

        List<Course> CourseList=crt1.list();


        for (Course s:CourseList){
            System.out.println("===========================");
            System.out.println("Course Name: "+s.getCourseName());
            List<Student> SList=s.getStudentList();

            System.out.println("Student Count :"+SList.size());
            System.out.println("===========================");
        }
    }
}
