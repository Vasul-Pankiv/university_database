package utils;

import model.Degree;
import model.Department;
import model.Lector;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class HibernateSessionFactoryUtil {

    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil() {}

    public static  SessionFactory getSessionFactory() {
        if(sessionFactory == null){
            try{
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Lector.class);
                configuration.addAnnotatedClass(Department.class);
                configuration.addAnnotatedClass(Degree.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

            }catch (Exception e){
                System.out.println("Exception "+e);
            }

        }
        return sessionFactory;
    }

}