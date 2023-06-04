package Demo;

import Domain.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DisplayProductDetails {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;

        cfg =new Configuration();
        cfg=cfg.configure();

        factory= cfg.buildSessionFactory();

        ses= factory.openSession();

        Product p=ses.load(Product.class,1);
        System.out.println(p.getproductId());
        System.out.println(p.getproductName());
        System.out.println(p.getproductCategory());
        System.out.println(p.getproductPrice());

    }
}
