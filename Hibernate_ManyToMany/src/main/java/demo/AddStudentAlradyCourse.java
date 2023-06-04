package demo;

import domain.Course;
import domain.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AddStudentAlradyCourse {
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

        Course c1=ses.load(Course.class,1);

        //create object of student
        Student s1=new Student();
        s1.setStudName("Omkar");

        c1.addStudent(s1);
        tx= ses.beginTransaction();
        ses.save(s1);
        tx.commit();
        System.out.println("Record insert Sucessfully");

    }
}
