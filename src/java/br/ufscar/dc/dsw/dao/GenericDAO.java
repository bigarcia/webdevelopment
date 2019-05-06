package br.ufscar.dc.dsw.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class GenericDAO<T> {

    private final EntityManagerFactory emf;

    public GenericDAO() {
        emf = Persistence.createEntityManagerFactory("JPAPU");
    }

    protected EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    abstract T get(Long id);

    abstract List<T> getAll();

    abstract void save(T t);

    abstract void update(T t);

    abstract void delete(T t);
}

/* CODIGO DO TRABALHO 1

package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

abstract public class GenericDAO {

    public GenericDAO() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:derby://localhost:1527/Locadora", "root", "root");
    }
} */
