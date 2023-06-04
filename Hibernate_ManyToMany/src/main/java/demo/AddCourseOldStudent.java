package demo;

import domain.Course;
import domain.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AddCourseOldStudent {
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

        Student s1=ses.load(Student.class,1);

        Course c1=new Course();
        c1.setCourseName("SQL");
       s1.addCourse(c1);
        tx= ses.beginTransaction();
        ses.save(c1);
        tx.commit();
        System.out.println("Record insert Sucessfully");

    }
}
