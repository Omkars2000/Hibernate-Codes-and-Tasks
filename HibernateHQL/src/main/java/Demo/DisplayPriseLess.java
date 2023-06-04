package Demo;

import Domain.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class DisplayPriseLess {
        public static void main(String[] args) {
            Configuration cfg;
            SessionFactory factory;
            Session ses;

            cfg=new Configuration();
            cfg=cfg.configure();
            cfg=cfg.addAnnotatedClass(Product.class);
            factory= cfg.buildSessionFactory();
            ses= factory.openSession();

            Query q= ses.createQuery("select p from Product p where p.productPrice<30000");
            List<Product> productList=q.list();
            for(Product p:productList){
                System.out.println(p);
            }

        }
    }

