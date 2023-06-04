package demo;

import domain.Course;
import domain.Student;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class  DisplayAllStudntAndCourse {
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

        Criteria crt1= ses.createCriteria(Student.class);

        List<Student> studentList=crt1.list();


        for (Student s:studentList){
            System.out.println("===========================");
            System.out.println("Student Name"+s.getStudName());
            List<Course> cList=s.getCourseList();
            System.out.println("===========================");
            System.out.println("ALL courses:");
            for(Course c:cList){
                System.out.println(c);
            }

        }
    }
}
