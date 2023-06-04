package demo;

import domain.Education;
import domain.Student;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.swing.event.ListDataEvent;
import java.util.List;

public class DeleteAll {
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
        Criteria crt= ses.createCriteria(Student.class);
        List<Student> studentList=crt.list();
        tx= ses.beginTransaction();
        for(Student s:studentList){
            ses.delete(s);
        }
        tx.commit();
        System.out.println("Deleted All Record");
    }
}
