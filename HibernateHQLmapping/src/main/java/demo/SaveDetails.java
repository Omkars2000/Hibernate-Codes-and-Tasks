package demo;

import com.sun.deploy.util.SyncAccess;
import domain.Citizen;
import domain.Passport;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.Scanner;

public class SaveDetails {
    public static void main(String[] args) {
        Scanner sc1=new Scanner(System.in);
        System.out.println("Enter Citizen Name");
        String name=sc1.next();
        System.out.println("Enter Citizen Age");
        int age= sc1.nextInt();
        System.out.println("Enter Citizen PassportNo");
        String passNo=sc1.next();
        System.out.println("Enter Citizen Country");
        String country=sc1.next();

        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg= new Configuration();
        cfg=cfg.configure();
        cfg.addAnnotatedClass(Citizen.class);
        cfg.addAnnotatedClass(Passport.class);
        factory= cfg.buildSessionFactory();
        ses=factory.openSession();
        //create object of passport
        Passport p1=new Passport();
        p1.setPassNo(passNo);
        p1.setPassCountry(country);
        //create object of Citizen
        Citizen c1=new Citizen();
        c1.setCitizenName(name);
        c1.setCitizenAge(age);
        //assign passport details to citizen object
        c1.setPassportRef(p1);
        tx= ses.beginTransaction();
        ses.save(c1);
        tx.commit();
        System.out.println("Details inserted Sucessfully");





    }
}
