package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 */
public class Driver {
    public static void main(String[] args) {

        Student s1 = new Student("John", "Wick", 60);
        s1.setDescription(" legendary hitman who is forced out of retirement to seek revenge against the men who killed his puppy, " +
                "a final gift from his recently deceased wife.");

        Account s1Account = new Account(s1.generateUsername(), "1111");

        s1.setAccount(s1Account);

        Address add1 = new Address();
        add1.setStreetAddress("Hayward Blvd");
        add1.setCity("Hayward");
        add1.setCountry("USA");
        add1.setZipCode(94542);

        Address add2 = new Address();
        add2.setStreetAddress("Sterling St");
        add2.setCity("Dallas");
        add2.setState("TX");
        add2.setCountry("USA");
        add2.setZipCode(75001);

        add1.setStudent(s1);
        add2.setStudent(s1);

        s1.getAddressSet().add(add1);
        s1.getAddressSet().add(add2);


        System.out.println("******** Creating Session Factory ********");
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        System.out.println("******** About to persist ********");
        session.persist(s1);
        session.persist(add1);
        session.persist(add2);
11
        t.commit();

        System.out.println("******** Closing Session ********");
        session.close();

    }


}
