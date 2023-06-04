package Demo;

import Domain.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateProductDetails {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;
        cfg =new Configuration();
        cfg=cfg.configure();

        factory= cfg.buildSessionFactory();

        ses= factory.openSession();

        Product p=ses.load(Product.class,1);
        p.setproductName("TV");

        tx= ses.beginTransaction();
        ses.update(p);
        tx.commit();
        System.out.println("PRODUCT DETAILS UPDATED ");

    }
}
