package demo;

import domain.Course;
import domain.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class DisplayAllCourses {
    public static void main(String[] args) {
        Scanner sc1=new Scanner(System.in);
        System.out.println("Enter ID");
        int id= sc1.nextInt();
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

        Student s1=ses.load(Student.class,id);
       List<Course> studentList=s1.getCourseList();
        System.out.println(" Course  Name : "+s1.getStudName());
        System.out.println("=========================");
       for (Course c:studentList){
           System.out.println(c);
       }

    }
}
