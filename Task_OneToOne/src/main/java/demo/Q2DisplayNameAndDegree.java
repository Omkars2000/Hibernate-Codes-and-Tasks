package demo;

import domain.Education;
import domain.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class Q2DisplayNameAndDegree {
    public static void main(String[] args) {
        Scanner sc1=new Scanner(System.in);
        System.out.println("Enter Student ID");
        int id=sc1.nextInt();

        Configuration cfg;
        SessionFactory factory;
        Session ses;


        cfg= new Configuration();
        cfg=cfg.configure();
        cfg.addAnnotatedClass(Student.class);
        cfg.addAnnotatedClass(Education.class);
        factory= cfg.buildSessionFactory();
        ses=factory.openSession();
        Student s1= ses.load(Student.class,id);
        String name=s1.getStudName();


        Education ref=s1.getEducationRef();
        double degree=ref.getDegree();
        System.out.println(name+"\t"+degree);
    }
}
