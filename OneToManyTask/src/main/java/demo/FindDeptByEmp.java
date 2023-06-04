package demo;

import domain.Dept;
import domain.Emp;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class FindDeptByEmp {
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
        Criteria crt= ses.createCriteria(Emp.class);
        crt.add(Restrictions.eq("empDesig","Manager"));
        List<Emp> empList=crt.list();
        System.out.println(empList.get(0).getDeptRef());
//        System.out.println("==============="+empList.get(0));
//        for(Emp e:empList){
//            System.out.println(e.getDeptRef());
//        }
//        System.out.println("=================");

    }
}
