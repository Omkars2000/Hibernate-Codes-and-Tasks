package demo;

import domain.Citizen;
import domain.Passport;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DisplayAllRecord {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;

        cfg= new Configuration();
        cfg=cfg.configure();
        cfg.addAnnotatedClass(Citizen.class);
        cfg.addAnnotatedClass(Passport.class);
        factory= cfg.buildSessionFactory();
        ses=factory.openSession();
        Criteria crt =ses.createCriteria(Citizen.class);
        List<Citizen> data=crt.list();
        for(Citizen c: data){
            System.out.println(c);
        }

    }
}
