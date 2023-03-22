package jdbc;

import crud.CrudFile;
import entity.GrndEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SqlCRUD implements CRUDInterface<GrndEntity> {
    Connection connection;
    List<GrndEntity> list = new ArrayList<>();

    public SqlCRUD() {
        this.connection = new Connect().getCon();
        System.out.println(connection);
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void create(GrndEntity GrndEntity) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        try (SessionFactory sessionFactory = new MetadataSources(registry)
                .addAnnotatedClass(GrndEntity.class)
                .buildMetadata()
                .buildSessionFactory()) {

            Session session = sessionFactory.openSession();
            session.beginTransaction();

            int id = CrudFile.getNextId(list);

            session.save(new GrndEntity(
                    id,
                    GrndEntity.getName(),
                    GrndEntity.getImg(),
                    GrndEntity.getType(),
                    GrndEntity.getWeight())
            );

            session.getTransaction().commit();
        }
    }

    @Override
    public List<GrndEntity> read() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        try (SessionFactory sessionFactory = new MetadataSources(registry)
                .addAnnotatedClass(GrndEntity.class)
                .buildMetadata()
                .buildSessionFactory()) {

            Session session = sessionFactory.openSession();
            session.beginTransaction();

            list = (List<GrndEntity>) session.createQuery("from GrndEntity").list();

            session.getTransaction().commit();
        }

        return list;
    }

    @Override
    public void update(int id, GrndEntity GrndEntity) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        try (SessionFactory sessionFactory = new MetadataSources(registry)
                .addAnnotatedClass(GrndEntity.class)
                .buildMetadata()
                .buildSessionFactory()) {

            Session session = sessionFactory.openSession();
            session.beginTransaction();

            GrndEntity updateGranade = new GrndEntity(
                    id,
                    GrndEntity.getName(),
                    GrndEntity.getImg(),
                    GrndEntity.getType(),
                    GrndEntity.getWeight()
            );

            session.update(updateGranade);

            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(int id) {
        try (PreparedStatement st = connection
                .prepareStatement("DELETE FROM granades WHERE id=?;")) {
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
