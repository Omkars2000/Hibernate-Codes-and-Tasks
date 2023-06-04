package Demo;
import Domain.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class SaveProductDetails {
    public static void main(String[] args) {
        //Delceration
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;
// stape 1 Active hipernate framework
        cfg =new Configuration();
        cfg=cfg.configure();
// stape 2 Establish communication link
        factory = cfg.buildSessionFactory();
        // stape 3 Start the session
        ses=factory.openSession();

        //stape 4 create object of domain class
        Product p1=new Product();
        p1.setproductId(1);
        p1.setproductName("LAPTOP");
        p1.setproductPrice(74000.90);
        p1.setproductCategory("Electronic");
        //satape: start the transaction
        tx= ses.beginTransaction();
        ses.save(p1);
        tx.commit();
        System.out.println("Record insert Succsecfully");
    }
}
