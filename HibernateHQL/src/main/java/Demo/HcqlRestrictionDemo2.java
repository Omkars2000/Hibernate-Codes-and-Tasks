package Demo;


import Domain.Product;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class HcqlRestrictionDemo2 {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;

        cfg= new Configuration();
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(Product.class);
        factory=cfg.buildSessionFactory();
        ses= factory.openSession();

 //fetch first 3 records from database
        Criteria crt1= ses.createCriteria(Product.class);
        crt1.setMaxResults(3);
//        crt.add(Restrictions.eq("productName","CAR"));
        List<Product> li=crt1.list();

        for(Product a:li){
            System.out.println(a);
        }
        System.out.println("===============================");
        //exclude first 3 records
        Criteria crt2=ses.createCriteria(Product.class);
        crt2.setFirstResult(3);
        List<Product> li2=crt2.list();
        for(Product p:li2){
            System.out.println(p);
        }

   // display only productsName of First 2 products
//        Criteria crt3= ses.createCriteria(Product.class);
//        crt3.setProjection(Projections.property("productName"));
//        crt1.setMaxResults(2);
//        List<String> li3=crt1.list();
//
//        for(String a:li3){
//            System.out.println(a);
//        }
        System.out.println("===============================");
        //display product having price less than 30000
        Criteria crt4=ses.createCriteria(Product.class);
        crt4.add(Restrictions.lt("productPrice",30000.0));
        List<Product> li4=crt4.list();
        for(Product p:li4){
            System.out.println(p);
        }
//           display products haveing price between 1000 and 5000
        System.out.println("=====================");
        Criteria crt5=ses.createCriteria(Product.class);
        crt5.add(Restrictions.between("productPrice",1000.0,5000.0));
        List<Product> li5=crt4.list();
        for(Product p:li5){
            System.out.println(p);
        }
        //display all products form electronic category
        System.out.println("=====================");
        Criteria crt6=ses.createCriteria(Product.class);
        crt6.add(Restrictions.eq("productCategory","ELECTRONIC"));
        List<Product> li6=crt6.list();
        for(Product p:li6){
            System.out.println(p);
        }
        //DISPLAY product whose name start with L
        System.out.println("=====================");
        Criteria crt7=ses.createCriteria(Product.class);
        crt7.add(Restrictions.like("productName","L%"));
        List<Product> li7=crt7.list();
        for(Product p:li7){
            System.out.println(p);
        }

        //display all Products from gadgets category having price greter than 100000
        System.out.println("=====================");
        Criteria crt8=ses.createCriteria(Product.class);
        crt8.add(Restrictions.conjunction()
        .add(Restrictions.eq("productCategory","GADGET"))
        .add(Restrictions.gt("productPrice",10000.0)));
        List<Product> li8=crt8.list();
        for(Product p:li8){
            System.out.println(p);
        }

        //display all product in ace order acording to thair price
        System.out.println("=====================");
        Criteria crt9=ses.createCriteria(Product.class);
        crt9.addOrder(Order.asc("productPrice"));
        List<Product> li9=crt9.list();
        for(Product p:li9){
            System.out.println(p);
        }
    }
}
