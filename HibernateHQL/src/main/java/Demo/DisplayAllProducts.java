package Demo;

import Domain.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class DisplayAllProducts {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;

        cfg=new Configuration();
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(Product.class);
        factory= cfg.buildSessionFactory();
        ses= factory.openSession();
        //HQL ------> display all the Object of Product Class
        Query q= ses.createQuery("select p from Product p");
        List<Product> productList=q.list();
        for(Product p:productList){
            System.out.println(p);
        }
    }
}
