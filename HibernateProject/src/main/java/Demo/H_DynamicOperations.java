package Demo;

import Domain.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class H_DynamicOperations {
    public static void main(String[] args) {
        Scanner sc1=new Scanner(System.in);
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration();
        cfg=cfg.configure();
        factory= cfg.buildSessionFactory();
        ses= factory.openSession();
        boolean status=true;
        while (status){
            System.out.println("Enter ID");
            int id= sc1.nextInt();
            Product p= ses.load(Product.class,id);
            if(id > 0){
                System.out.println("SELECT MODE OF OPERATION");
                System.out.println("1:MODIFY NAME");
                System.out.println("2:MODIFY CATEGORY");
                System.out.println("3:MODIFY PRICE");

                int choice= sc1.nextInt();
                switch (choice){
                    case 1:
                        System.out.println("Enter Updated Name");
                        String name= sc1.next();
                        p.setproductName(name);
                        break;
                    case 2:
                        System.out.println("Enter Updated Category");
                        String cat= sc1.next();
                        p.setproductCategory(cat);
                        break;
                    case 3:
                        System.out.println("Enter Updated Price");
                        double price=sc1.nextDouble();
                        p.setproductPrice(price);
                        break;
                    default:
                        System.out.println("INVALID CHOICE!!");
                }
                tx= ses.beginTransaction();
                ses.update(p);
                tx.commit();
                System.out.println("Record Updated Successfully");
                System.out.println("1:YOU WANT TO EXIST");
                System.out.println("2:YOU WANT TO CONTINUE");
                int exist=sc1.nextInt();
                if(exist==1){ status=false;}
            }else System.out.println("INVALID ID");
        }

    }
}
