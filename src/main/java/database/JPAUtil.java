package database;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

// Esta clase hace un llamado a nuestro Persistence.xml  y asi podernos conectarnos a la BD.
public class JPAUtil {
    private static final String PERSISTENCE_UNIT_NAME = "PERSISTENCIA";
    private static EntityManagerFactory factory;  // Va contener la conexion a la BD

    // Crear la conexion con la BD
    public static EntityManagerFactory getEntityManagerFactory() {
        if (factory==null) {
            factory=Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        return factory;
    }

    // Cerrar la conexion con la BD
    public static void shutdown() {
        if (factory!=null) {
            factory.close();
        }
    }
}
