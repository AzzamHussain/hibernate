package com.example.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class DemoApplication {

    public static void main(String[] args) {


        Marks m1 = new Marks();
        m1.setEngmarks(85.5);
        m1.setMathmarks(90.0);
        m1.setScimarks(88.0);
        student s1 = new student();
        s1.setid(12);
        s1.setname("Azzam");
        s1.setStudentClass("Bscs");
        s1.setStudentMarks(m1);


        StandardServiceRegistry ssr =
                new StandardServiceRegistryBuilder()
                        .configure("hibernate.cfg.xml")
                        .build();

        Metadata meta =
                new MetadataSources(ssr)
                        .getMetadataBuilder()
                        .build();

        SessionFactory sf = meta.getSessionFactoryBuilder().build();
        Session session = sf.openSession();

        Transaction t = session.beginTransaction();
        session.save(s1);
        t.commit();

        session.close();
        sf.close();

    }
}
