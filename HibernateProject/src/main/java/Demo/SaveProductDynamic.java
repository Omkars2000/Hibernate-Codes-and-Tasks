package Demo;

import Domain.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.Scanner;
public class SaveProductDynamic {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;
        cfg =new Configuration();
        cfg=cfg.configure();
        factory= cfg.buildSessionFactory();
        ses= factory.openSession();
        Product p1=new Product();
        Scanner sc1=new Scanner(System.in);
        System.out.println("Enter Product Id");
        int id=sc1.nextInt();
        System.out.println("Enter Product Name");
        String name=sc1.next();
        System.out.println("Enter Product Catagory");
        String cat=sc1.next();
        System.out.println("Enter Product price");
        double price=sc1.nextDouble();
        p1.setproductId(id);
        p1.setproductName(name);
        p1.setproductCategory(cat);
        p1.setproductPrice(price);
        tx= ses.beginTransaction();
        ses.save(p1);
        tx.commit();
        System.out.println(" RECORD INSERT SUCCESSFULLY");
    }
}
