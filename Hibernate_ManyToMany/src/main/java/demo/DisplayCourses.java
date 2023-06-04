package demo;

import domain.Course;
import domain.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class DisplayCourses {
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

        Course c1=ses.load(Course.class,id);

        List<Student> courseList= c1.getStudentList();
        System.out.println(" Student Name : "+c1.getCourseName());
        System.out.println("===============================");
        for (Student c:courseList){
            System.out.println(c);
        }

    }
    }

