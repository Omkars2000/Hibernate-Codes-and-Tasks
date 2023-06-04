package demo;

import domain.Education;
import domain.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class InsertOp {
    public static void main(String[] args) {
        Scanner sc1=new Scanner(System.in);
        System.out.println("Enter Stud Name");
        String name=sc1.next();
        System.out.println("Enter Contact");
        int cont= sc1.nextInt();
        System.out.println("Enter 10th Mark");
        double _10th=sc1.nextDouble();
        System.out.println("Enter 12th Mark");
        double _12th=sc1.nextDouble();
        System.out.println("Enter degree Mark");
        double degree=sc1.nextDouble();

        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg= new Configuration();
        cfg=cfg.configure();
        cfg.addAnnotatedClass(Student.class);
        cfg.addAnnotatedClass(Education.class);
        factory= cfg.buildSessionFactory();
        ses=factory.openSession();

        Student s1= new Student();
        s1.setStudName(name);
        s1.setStudCont(cont);

       Education e1=new Education();
       e1.set_10(_10th);
       e1.set_12(_12th);
       e1.setDegree(degree);

        s1.setEducationRef(e1);
        tx= ses.beginTransaction();
        ses.save(s1);
        tx.commit();
        System.out.println("Details inserted Sucessfully");





    }
}
