package demo;


import domain.Education;
import domain.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class InsertRecord {
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
        Student s1=new Student();
       s1.setStudentName("OMKAR");
       s1.setStudentContact(7219470204L);
       Education e1=new Education();
       e1.set_10(96.22);
       e1.set_12(70.77);
       e1.set_degree(40.33);
       s1.setEducationRef(e1);
       tx= ses.beginTransaction();
       ses.save(s1);
       ses.save(e1);
       tx.commit();
        System.out.println("Record Inserted");

    }
}
