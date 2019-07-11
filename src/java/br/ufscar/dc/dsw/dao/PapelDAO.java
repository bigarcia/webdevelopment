/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.model.Papel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bianca
 */



public class PapelDAO extends GenericDAO{
static Connection currentCon = null; 
    static ResultSet rs = null; 

  

    public void insert(Papel papel) {
        String sql = "INSERT INTO Papel (email_papel, nome_papel) VALUES (?, ?)";
        try {
            Connection conn = this.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps = conn.prepareStatement(sql);
            ps.setString(1, papel.getEmail_papel());
            ps.setString(2, papel.getNome_papel());
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Papel> getAll() {
        List<Papel> listaPapel = new ArrayList<>();
        String sql = "SELECT * FROM Papel";
        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id_papel = resultSet.getInt("id_papel");
                String email_papel = resultSet.getString("email_papel");
                String nome_papel = resultSet.getString("nome_papel");
                Papel papel = new Papel(email_papel, nome_papel);
                listaPapel.add(papel);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaPapel;
    }

    public void delete(Papel papel) {
        String sql = "DELETE FROM Papel where id_papel = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, papel.getId_papel());
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Papel usuario) {
        String sql = "UPDATE Papel SET email_papel = ?, nome_papel = ?";
        sql += " WHERE id_papel = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, usuario.getEmail_papel());
            ps.setString(2, usuario.getNome_papel());
            ps.setInt(3, usuario.getId_papel());
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Papel get(int id) {
        Papel papel = null;
        String sql = "SELECT * FROM Papel WHERE id_papel = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                String email_papel = resultSet.getString("email_papel");
                String nome_papel = resultSet.getString("nome_papel");
                papel = new Papel(email_papel, nome_papel);
            }
            resultSet.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return papel;
    }
}