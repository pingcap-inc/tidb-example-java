package com.pingcap.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App  {
    public static void main( String[] args ) {
        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory(); Session session = sessionFactory.openSession()) {
            String result = session.createNativeQuery("SELECT 'Hello World'", String.class)
                    .getSingleResult();
            System.out.println(result);
        }
    }
}
