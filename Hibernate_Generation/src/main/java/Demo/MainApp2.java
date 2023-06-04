package Demo;

import domain.BookData2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class MainApp2 {
    public static void main(String[] args) {
        Scanner sc1=new Scanner(System.in);
        System.out.println("Enter the book Name ");
        String name=sc1.next();
        System.out.println("Enter the book Name ");
        double price=sc1.nextDouble();
        Configuration cfg = null;
        SessionFactory factory;
        Session ses;
        cfg=new Configuration();
        cfg=cfg.configure();
        cfg.addAnnotatedClass(BookData2.class);
        factory= cfg.buildSessionFactory();
        ses=factory.openSession();
        Transaction tx;


        BookData2 b1= new BookData2();
        b1.setBookName(name);
        b1.setBookPrice(price);

        tx=ses.beginTransaction();
        ses.save(b1);
        tx.commit();
        System.out.println("RECORD INSERTED");

    }
}
