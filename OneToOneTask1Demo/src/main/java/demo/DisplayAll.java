package demo;

import domain.Education;
import domain.Student;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DisplayAll {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;
        cfg= new Configuration();
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(Student.class);
        cfg=cfg.addAnnotatedClass(Education.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();
        //for display one record
        System.out.println("===============================================");
        Student s1=ses.load(Student.class,1);
        System.out.println(s1);
        System.out.println("=============================================");
        Criteria crt= ses.createCriteria(Student.class);
        List<Student> studentList =crt.list();
        Criteria crt2= ses.createCriteria(Education.class);
        List<Education> educationList=crt2.list();
        for(Student s:studentList){
            System.out.println(s);
        }
    }
}
