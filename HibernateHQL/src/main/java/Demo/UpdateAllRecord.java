package Demo;

import Domain.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class UpdateAllRecord {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;
        cfg=new Configuration();
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(Product.class);
        factory= cfg.buildSessionFactory();
        ses= factory.openSession();
        tx= ses.beginTransaction();
        Query q= ses.createQuery("update Product p set p.productPrice=200000");
        int count=q.executeUpdate();
        tx.commit();
        System.out.println(count+" Products Updated");
    }
}
