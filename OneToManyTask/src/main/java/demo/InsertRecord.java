package demo;

import domain.Dept;
import domain.Emp;
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
        cfg=new Configuration();
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(Dept.class);
        cfg=cfg.addAnnotatedClass(Emp.class);
        factory= cfg.buildSessionFactory();
        ses=factory.openSession();
        Dept d1=new Dept();
        d1.setDeptname("ACCOUNTING");
        Emp e1=new Emp();
        e1.setEmpName("SURAJ");
        e1.setEmpDesig("ACCOUNTANT");
        Emp e2=new Emp();
        e2.setEmpName("VARUN");
        e2.setEmpDesig("Manager");
        d1.addEmp(e1);
        d1.addEmp(e2);
        tx= ses.beginTransaction();
        ses.save(d1);
        ses.save(e1);
        ses.save(e2);
        tx.commit();
        System.out.println("Inserted Record");
    }
}
