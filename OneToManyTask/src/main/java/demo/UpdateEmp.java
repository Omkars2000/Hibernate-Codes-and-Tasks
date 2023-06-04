package demo;

import domain.Dept;
import domain.Emp;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateEmp {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;
        cfg =new Configuration();
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(Dept.class);
        cfg=cfg.addAnnotatedClass(Emp.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();
        Dept d1= ses.load(Dept.class,1);
        Emp e1=ses.load(Emp.class,1);
        e1.setEmpName("MADHU");
        d1.addEmp(e1);

        tx= ses.beginTransaction();
        ses.save(e1);
        tx.commit();
        System.out.println("Record Updated Successfully");
    }
}
