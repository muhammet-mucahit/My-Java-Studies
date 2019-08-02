package com.telusko;


import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.List;
import java.util.Map;


/**
 * Hello world!
 *
 */

public class App {
    public static void main( String[] args ) {

        Configuration config = new Configuration().configure().addAnnotatedClass(Student.class);
        ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
        SessionFactory factory = config.buildSessionFactory(registry);
        Session session = factory.openSession();

        session.beginTransaction();

        SQLQuery query = session.createSQLQuery("select name, marks from Student where marks > 60");
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);

        List students = query.list();

        for (Object student : students) {
            //Map m = (Map) student;
            System.out.println(((Map) student).get("name") + " : " + ((Map) student).get("marks"));
        }

        session.getTransaction().commit();


    }
}
