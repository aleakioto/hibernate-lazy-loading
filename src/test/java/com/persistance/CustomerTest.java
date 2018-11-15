package com.persistance;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.Assert.assertNotNull;

public class CustomerTest {

    Logger logger = LoggerFactory.getLogger(CustomerTest.class);

    @Test
    public void test2(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("thePersistenceUnit");
        EntityManager theManager = factory.createEntityManager();
        assertNotNull(theManager);
        Customer customer = new Customer();
        customer.setName("Jack");
        customer.setDepartment("Zp");
        customer.setComment("Thank you very much");

        theManager.getTransaction().begin();
        logger.info(customer.toString());
        theManager.persist(customer);
        int id = customer.getRecId();
        logger.info(customer.toString());
        theManager.getTransaction().commit();
//        theManager.close();


//        theManager = factory.createEntityManager();
//        theManager.getTransaction().begin();
        Customer p = (Customer)theManager.find(Customer.class, id);
        logger.info(p.toString());
        assertNotNull(p);
        theManager.close();
    }
}
