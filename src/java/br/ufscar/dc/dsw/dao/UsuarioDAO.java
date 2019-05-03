/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.dao;

/**
 *
 * @author Bianca
 */
import br.ufscar.dc.dsw.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author mariana
 */
public class UsuarioDAO extends GenericDAO {
    
    static Connection currentCon = null; 
    static ResultSet rs = null; 
 
    
    
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public int insert(Usuario usuario) {
        int id;
        String sql = "INSERT INTO Usuario (email_usuario, senha_usuario, ativo_usuario) VALUES (?, ?, ?)";
        try {
            
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, usuario.getEmail_usuario());
            statement.setString(2, encoder.encode(usuario.getSenha_usuario()));
            statement.setInt(3, usuario.getAtivo_usuario());
            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();
            rs.next();
            id = rs.getInt(1);

            statement.close();
            conn.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return id;
    }

    public List<Usuario> getAll() {
        List<Usuario> listaUsuarios = new ArrayList<>();
        String sql = "SELECT * FROM Usuario";
        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id_usuario");
                String email = resultSet.getString("email_usuario");
                String senha = resultSet.getString("senha_usuario");
                int ativo = resultSet.getInt("ativo_usuario");
                Usuario usuario = new Usuario(senha, email, ativo);
                listaUsuarios.add(usuario);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaUsuarios;
    }

    public void delete(Usuario usuario) {
        String sql = "DELETE FROM Usuario where id_usuario = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, usuario.getId_usuario());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Usuario usuario) {
                
        String sql = "UPDATE Usuario SET email_usuario = ?, senha_usuario = ?, ativo_usuario = ?";
        sql += " WHERE id_usuario = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, usuario.getEmail_usuario());
            statement.setString(2, encoder.encode(usuario.getSenha_usuario()));
            statement.setInt(3, usuario.getAtivo_usuario());
            statement.setInt(4, usuario.getId_usuario());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Usuario get(int id) {
        Usuario usuario = null;
        String sql = "SELECT * FROM Usuario WHERE id_usuario = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String email = resultSet.getString("email_usuario");
                String senha = resultSet.getString("senha_usuario");
                int ativo = resultSet.getInt("ativo_usuario");
                usuario = new Usuario(senha, email, ativo);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usuario;
    }
    
    public int getID(String email) {
        Usuario usuario = null;
                
        String sql = "SELECT * FROM Usuario WHERE email_usuario = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id_usuario");
                String senha = resultSet.getString("senha_usuario");
                int ativo = resultSet.getInt("ativo_usuario");
                usuario = new Usuario(id, senha, email, ativo);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usuario.getId_usuario();
    }
}