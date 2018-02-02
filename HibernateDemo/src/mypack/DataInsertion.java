package mypack;


import java.util.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class DataInsertion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Operations:");
		System.out.println("1:Insert Data in Database");
		System.out.println("2:Get Information from Database");
		System.out.println("3:Delete Information from Database");
		System.out.println("4:Update Data in Database");
		System.out.println("Enter Your Choice");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		sc.close();
		 switch(choice) {
         case 1 :
        	new DataInsertion().insertInfo();
            break;
         case 2 :
        	 new DataInsertion().getInfo();
        	 break;
         case 3 :
            new DataInsertion().deleteInfo();
            break;
         case 4 :
        	new DataInsertion().updateInfo();
        	break; 
      }
		
	}

	public void insertInfo() {
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		DataProvider provider = new DataProvider();
		provider.setId(024);
		provider.setAuthor("Ukarande A B");
		provider.setTitle("Life");
		provider.setPrice(500);
		Transaction tr = session.beginTransaction();
		session.save(provider);
		System.out.println("Object saved Successfully");
		tr.commit();
		session.close();
		sf.close();
	}
	
	public void getInfo() {
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Object ob = session.load(mypack.DataProvider.class, new Long(1));
		DataProvider DP = (DataProvider) ob;
		System.out.println("Author Name is:"+DP.getAuthor());
		System.out.println("Book Name is:"+DP.getTitle());
		System.out.println("Book Price is:"+DP.getPrice());
	}
	
	public void deleteInfo() {
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
 
        Object ob =session.load(mypack.DataProvider.class,new Long(2));
        DataProvider DP = (DataProvider) ob;
 
        Transaction tr = session.beginTransaction();
        session.delete(DP);
        System.out.println("Object Deleted Successfully");
		tr.commit();
		session.close();
		sf.close();
	}
	
	public void updateInfo() {
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tr = session.beginTransaction();
        Object ob = session.load(mypack.DataProvider.class, new Long(1));
        DataProvider DP = (DataProvider) ob;
        DP.setAuthor("Akash Ukarande");
        System.out.println("Object Updated Successfully");
		tr.commit();
		session.close();
		sf.close();
	}
}
