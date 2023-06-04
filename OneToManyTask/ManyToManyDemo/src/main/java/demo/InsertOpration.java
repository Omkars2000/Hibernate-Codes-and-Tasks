package demo;

import domain.Duty_shift;
import domain.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class InsertOpration {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;
        cfg=new Configuration() ;
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(Employee.class);
        cfg=cfg.addAnnotatedClass(Duty_shift.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();
        Employee e1=new Employee();
        e1.setEmpName("OMKAR");
//        Employee e2=new Employee();
//        e1.setEmpName("SHAFIK");
        Duty_shift d1=new Duty_shift();
        d1.setDutyName("Morning");
        d1.addEmp(e1);
//        d1.addEmp(e2);
        tx= ses.beginTransaction();
        ses.save(d1);
        ses.save(e1);
//        ses.save(e2);
        tx.commit();
        System.out.println("Record Inserted!!!");



    }
}
