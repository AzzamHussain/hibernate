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


        Student s1 = new Student();
s1.setId(12);
s1.setName("Azzam");
s1.setStudentClass("BSCS");

StudentMarks m1 = new StudentMarks();
m1.setSubject("ENGLISH");
m1.setMarks(85.5);
m1.setStudent(s1);

StudentMarks m2 = new StudentMarks();
m2.setSubject("MATH");
m2.setMarks(90.0);
m2.setStudent(s1);

StudentMarks m3 = new StudentMarks();
m3.setSubject("SCIENCE");
m3.setMarks(88.0);
m3.setStudent(s1);

s1.getMarksList().add(m1);
s1.getMarksList().add(m2);
s1.getMarksList().add(m3);

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
