package Demo;

import Domain.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;

public class UpdatePriceCategory {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;
        Scanner sc1=new Scanner(System.in);

        cfg=new Configuration();
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(Product.class);
        factory= cfg.buildSessionFactory();
        ses= factory.openSession();
        System.out.println("Enter Category of Product");
        String cat=sc1.next();
        System.out.println("Enter Category of Price");
        double price= sc1.nextDouble();
        ses= factory.openSession();
        tx= ses.beginTransaction();

        Query q= ses.createQuery("Update Product p set p.productPrice='"+price+"' where p.productCategory='"+cat+"'" );
        int count=q.executeUpdate();
        tx.commit();
        System.out.println(count+" Products Updated");



    }
}
