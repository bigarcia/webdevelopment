package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.model.Locadora;
import br.ufscar.dc.dsw.model.Papel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LocadoraDAO extends GenericDAO {

    public void insert(Locadora locadora){
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        int id_locadora = usuarioDAO.insert(locadora);
        
        Papel papel = new Papel(locadora.getEmail_usuario(), "ROLE_LOCADORA");
        
        PapelDAO papelDAO = new PapelDAO();
        papelDAO.insert(papel);
        
        String sql = "INSERT INTO Locadora (id_locadora,cnpj_locadora, nome_locadora, cidade_locadora)" + "values(?,?,?,?)";
        try {
            Connection con = this.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,id_locadora);
            ps.setString(2, locadora.getCnpj_locadora());
            ps.setString(5, locadora.getNome_locadora());
            ps.setString(6, locadora.getCidade_locadora());

            ps.executeUpdate();
            ps.close();
            con.close();
       } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Locadora get(int id_locadora) {
        Locadora locadora = null;
        String sql = "SELECT * FROM Locadora lo, Usuario u WHERE lo.id_locadora = ? and lo.id_locadora = u.id_usuario";

        try {
            Connection conn = this.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id_locadora);
            ResultSet rset = ps.executeQuery();
            if (rset.next()) {
                String cnpj_locadora = rset.getString("cnpj_locadora");
                String nome_locadora = rset.getString("nome_locadora");
                String cidade_locadora = rset.getString("cidade_locadora");
                String senha_usuario = rset.getString("senha_usuario");
                String email_usuario = rset.getString("email_usuario");
                int ativo_usuario = rset.getInt("ativo_usuario");
                locadora = new Locadora(id_locadora,cnpj_locadora, nome_locadora, cidade_locadora, senha_usuario, email_usuario, ativo_usuario);
            }

            rset.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return locadora;
    }
    public List<Locadora> getAll() {
        List<Locadora> listaTodasLocadoras = new ArrayList<>();
        String sql = "SELECT * FROM Locadora lo, Usuario u WHERE lo.id_locadora = u.id_usuario ";
        try {
            Connection con = this.getConnection();
            Statement statement = con.createStatement();
            ResultSet rset = statement.executeQuery(sql);
            while (rset.next()) {
                int id_locadora = rset.getInt("id_locadora");
                String cnpj_locadora = rset.getString("cnpj_locadora");
                String nome_locadora = rset.getString("nome_locadora");
                String cidade_locadora = rset.getString("cidade_locadora");
                String email_usuario = rset.getString("email_usuario");             
                int ativo_usuario = rset.getInt("ativo_usuario");
                
                Locadora locadora = new Locadora(id_locadora, cnpj_locadora, nome_locadora, cidade_locadora, email_usuario, ativo_usuario);
                listaTodasLocadoras.add(locadora);
            }
            rset.close();
            statement.close();
            con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return listaTodasLocadoras ;
    }



    public List<Locadora> getbyCities(String cidade){
            
        List<Locadora> listaLocadorasCidades = new ArrayList<>();
        
        String sql = "SELECT * FROM Locadora lo, Usuario u WHERE lo.id_locadora = u.id_usuario and lo.cidade_locadora = ?";
        try {   
            Connection conn = this.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cidade);
            ResultSet rset = ps.executeQuery();
            while (rset.next()) {
                int id_locadora = rset.getInt("id_locadora");
                String cnpj_locadora = rset.getString("cnpj_locadora");                
                String nome_locadora = rset.getString("nome_locadora");
                String cidade_locadora = rset.getString("cidade_locadora");
                String email_usuario = rset.getString("email_usuario");
                int ativo_usuario = rset.getInt("ativo_usuario");

                Locadora locadora = new Locadora(id_locadora, cnpj_locadora, nome_locadora, cidade_locadora, email_usuario, ativo_usuario);
                listaLocadorasCidades.add(locadora);
            }  
            rset.close();
                ps.close();
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        return listaLocadorasCidades;
    }


    public void delete(Locadora locadora) {
        String sql = "DELETE FROM Locadora where id_locadora = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, locadora.getId_locadora());
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Locadora locadora) {
        String sql = "UPDATE Locadora SET cnpj_locadora = ?, nome_locadora = ?, cidade_locadora = ?";
        sql += " WHERE id_locadora = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1,locadora.getId_locadora());
            ps.setString(2, locadora.getNome_locadora());
            ps.setString(3, locadora.getCidade_locadora());
            ps.setString(4, locadora.getCnpj_locadora());
            ps.executeUpdate();
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    
}
