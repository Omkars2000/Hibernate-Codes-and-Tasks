package Demo;

import Domain.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;

public class DisplaySpesificProduct {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Scanner sc1=new Scanner(System.in);

        cfg=new Configuration();
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(Product.class);
        factory= cfg.buildSessionFactory();
        ses= factory.openSession();
        System.out.println("Enter Category of Product");
        String cat=sc1.next();
   Product c=new Product();
        //HQL ------> display all the Object of Product Class
        Query q= ses.createQuery("select p from Product p where p.productCategory='"+cat+"'");

//        query.setParameter(":cat",c.getProductCategory());
        List<Product> productList=q.list();
        for(Product p:productList){
            System.out.println(p);
        }

    }
}
