package Demo;

import Domain.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class H_DeleteProductDetailsDynamic {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;
        Scanner sc1=new Scanner(System.in);

        cfg=new Configuration();
        cfg=cfg.configure();
        factory= cfg.buildSessionFactory();
        ses= factory.openSession();
        System.out.println("Enter ID ");
        int id=sc1.nextInt();
        Product p=ses.load(Product.class,id);
        tx=ses.beginTransaction();
        ses.delete(p);
        tx.commit();
        System.out.println("PRODUCT DELETED SUCCESSFULLY");
    }
}
