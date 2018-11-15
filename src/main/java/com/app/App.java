package com.app;

import com.persistance.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

    public static void main(String[] args) {
            new App().run();
    }

    private void run()
    {
        Customer customer = new Customer();
        customer.setRecId(1);
        customer.setName("Jack");
        customer.setDepartment("Zp");
        customer.setComment("Thank you very much");

        SessionFactory sFactory = buildSessionFactory(Customer.class);
        Session session = sFactory.openSession();
        session.save(customer);
        session.get(Customer.class, 1);

        sFactory.close();

    }

    private SessionFactory buildSessionFactory(Class clazz)
    {
        return new Configuration().configure().addClass(clazz).buildSessionFactory();
    }
}
