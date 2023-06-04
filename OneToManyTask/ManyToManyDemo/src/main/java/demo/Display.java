package demo;

import domain.Duty_shift;
import domain.Employee;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Display {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        cfg=new Configuration() ;
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(Employee.class);
        cfg=cfg.addAnnotatedClass(Duty_shift.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();
//        Employee e1=ses.get(Employee.class,2);
//        System.out.println(e1);
//        Criteria crt= ses.createCriteria(Employee.class);
//        List<Employee> employeeList=crt.list();
//        for(Employee e:employeeList){
//            System.out.println(e);
//        }
        Criteria crt= ses.createCriteria(Duty_shift.class);
        List<Duty_shift> list=crt.list();
        for(Duty_shift d:list){
            System.out.println("DUTY NAME:  "+d.getDutyName());
            List<Employee> e=d.getEmployeeList();
            for(Employee p:e){
                System.out.println(p);
            }
        }
    }
}
