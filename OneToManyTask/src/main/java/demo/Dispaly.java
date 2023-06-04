package demo;

import domain.Dept;
import domain.Emp;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Dispaly {
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
        Criteria crt=ses.createCriteria(Dept.class);
        List<Dept> deptList=crt.list();
        for(Dept d:deptList){
            System.out.println(d);
        }
    }
}
