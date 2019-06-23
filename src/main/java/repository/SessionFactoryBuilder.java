package repository;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryBuilder {

     SessionFactory sessionFactory = null;

    public  SessionFactory createSessionFactory() {

        if (sessionFactory == null) {
            registerDriver();
            sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        }
        return sessionFactory;
    }

    private void registerDriver() {
        String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("Class " + JDBC_DRIVER + " not found");
            return;
        }
    }

    public  void closeSessionFactory() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
