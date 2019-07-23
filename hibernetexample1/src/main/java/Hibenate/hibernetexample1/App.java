package Hibenate.hibernetexample1;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        SessionFactory sessionsf = HibernetUtil.getSessionFactory();
      		
              
              Session session = sessionsf.openSession();
            //parent object
            Vendor v =new Vendor();

            v.setVendorId(101);
            v.setVendorName("java4s");

            //creating 3 child objects
            Customer c1=new Customer();

            c1.setCustomerId(504);
            c1.setCustomerName("customer4");

            Customer c2=new Customer();

            c2.setCustomerId(505);
            c2.setCustomerName("customer5");

            Customer c3=new Customer();

            c3.setCustomerId(506);
            c3.setCustomerName("customer6");

            // adding child objects to set, as we taken 3rd property set in parent
            Set s=new HashSet();

            s.add(c1);
            s.add(c2);
            s.add(c3);

            v.setChildren(s);

            Transaction tx = session.beginTransaction();
            session.save(v);

            tx.commit();
            session.close();
            System.out.println("One To Many is Done..!!");
            sessionsf.close();
    }
}
