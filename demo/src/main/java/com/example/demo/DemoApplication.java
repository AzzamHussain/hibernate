package com.example.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import java.util.Scanner;

public class DemoApplication {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Hibernate setup
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
        SessionFactory sf = meta.getSessionFactoryBuilder().build();
        Session session = sf.openSession();
        Transaction t = session.beginTransaction();

        System.out.print("Kitne students insert karne hain? ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        for(int i = 0; i < n; i++) {
            Student s = new Student();

            System.out.print("Enter student name: ");
            s.setName(sc.nextLine());

            System.out.print("Enter student class: ");
            s.setStudentClass(sc.nextLine());

            int subjects = 3; // ya user se le sakte ho
            for(int j = 0; j < subjects; j++) {
                StudentMarks m = new StudentMarks();
                System.out.print("Enter subject name: ");
                m.setSubject(sc.nextLine());

                System.out.print("Enter marks: ");
                m.setMarks(sc.nextDouble());
                sc.nextLine(); // consume newline

                m.setStudent(s);
                s.getMarksList().add(m);
            }

            session.save(s); // insert student + marks
            System.out.println("Student " + s.getName() + " added successfully!\n");
        }

        t.commit();
        session.close();
        sf.close();
        sc.close();
    }
}
