package br.ufscar.br.dsw.dao;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

abstract public class GenericDAO {

    private DataSource dataSource;

    public GenericDAO() {
        try {
            InitialContext cxt = new InitialContext();
            if (cxt == null) {
                throw new Exception("Uh oh -- no context!");
            }
            InitialContext initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            dataSource = (DataSource) envContext.lookup("jdbc/LocacaoDBLocal");
            if (dataSource == null) {
                throw new RuntimeException("Data source not found!");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
