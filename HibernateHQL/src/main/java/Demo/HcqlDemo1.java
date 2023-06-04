package Demo;

import Domain.Product;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class HcqlDemo1 {
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
       //Fetching Details from all the columns
        //Create Criteria
        Criteria crt1 =ses.createCriteria(Product.class);
        //execute Criteria
        List<Product> productList=crt1.list();
        for(Product p:productList){
            System.out.println(p);
        }
        System.out.println("=========================================");
        //fetching record form specific column
        //create criteria
        Criteria crt2= ses.createCriteria(Product.class);
        //aadd requirement details
        crt2.setProjection(Projections.property("productName"));
        //execute criteria
        List<String> list=crt2.list();
        for(String p:list){
            System.out.println(p);
        }
        //fetch details from name and price columns
//        List results = ses.createCriteria(Product.class)
//                .setProjection( Projections.projectionList()
//                        .add( Projections.property("productName"))
//                        .add(Projections.property("productPrice"))
//                ).list();
////
//        Iterator itr= results.listIterator();
//        while (itr.hasNext()){
//            System.out.println(itr.next());
//        }
        Criteria crt3= ses.createCriteria(Product.class);
        ProjectionList pList=Projections.projectionList();
        pList.add(Projections.property("productName"));
        pList.add(Projections.property("productPrice"));
        crt3.setProjection(pList);
        List data=crt3.list();
        Iterator itr= data.listIterator();
       while (itr.hasNext()){
            Object[] arr= (Object[]) itr.next();
           System.out.println(arr[0]+"\t\t"+arr[1]);
        }


    }
}
