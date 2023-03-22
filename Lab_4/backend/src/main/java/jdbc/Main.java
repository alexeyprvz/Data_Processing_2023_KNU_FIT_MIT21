package jdbc;

import entity.GrndEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {
    public static void main(String[] args) {

        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try (SessionFactory sessionFactory = new MetadataSources(registry)
                .addAnnotatedClass(GrndEntity.class)
                .buildMetadata()
                .buildSessionFactory()) {

            Session session = sessionFactory.openSession();
            session.beginTransaction();

            session.save(new GrndEntity(
                    1
                    , "РГ-42"
                    , "1"
                    , "ручна, осколкова, наступальної дії"
                    , 440
            ));
            session.save(new GrndEntity(
                    2
                    , "Ф-1"
                    , "2"
                    , "ручна, дистанційної дії"
                    , 60
            ));
            session.save(new GrndEntity(
                    3
                    , "М-61"
                    , "3"
                    , "М-61"
                    , 450
            ));
            session.save(new GrndEntity(
                    4
                    , "M67"
                    , "4"
                    , "ручна, наступальна"
                    , 397
            ));
            session.save(new GrndEntity(
                    5
                    , "РГД-5"
                    , "5"
                    , "протипіхотна, уламкова, ручна, дистанційної дії, наступальна"
                    , 310
            ));
            session.save(new GrndEntity(
                    6
                    , "AN/M8"
                    , "6"
                    , "ручна, димова, отруйна"
                    , 680
            ));


            session.getTransaction().commit();

        }
        System.out.println("You added all data in table!");
    }
}
