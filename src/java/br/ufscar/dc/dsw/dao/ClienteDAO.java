package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.model.Cliente;
import br.ufscar.dc.dsw.dao.UsuarioDAO;
import br.ufscar.dc.dsw.model.Papel;
import br.ufscar.dc.dsw.dao.PapelDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO extends GenericDAO {
    
    public void insert(Cliente cliente){
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        int id_cliente = usuarioDAO.insert(cliente);
        String sql = "INSERT INTO into Cliente (id_cliente, nome_cliente, cpf_cliente, telefon_cliente, data_nascimento_cliente, sexo_cliente) VALUES (?, ?, ?, ?, ?, ?)";
        Papel papel = new Papel(cliente.getEmail_usuario(), "ROLE_CLIENTE");
        PapelDAO papelDAO = new PapelDAO();
        papelDAO.insert(papel);
        try {
            Connection con = this.getConnection(); 
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id_cliente);
            ps.setString(2, cliente.getCpf_cliente());
            ps.setString(3, cliente.getNome_cliente());
            ps.setString(4, cliente.getTelefone_cliente());
            ps.setString(5, cliente.getSexo_cliente());
            ps.setString(6, cliente.getNascimento_cliente());
            ps.executeUpdate();
            ps.close();
            con.close();
          
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
    }
        

    public List<Cliente> getAll() {
        List<Cliente> listaCliente = new ArrayList<>();
        String sql = "SELECT * FROM Cliente c,  Usuario u WHERE c.id_cliente = u.id_usuario";
        try {
            Connection con = this.getConnection();
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id_cliente = resultSet.getInt("id_cliente");                       
                String cpf_cliente = resultSet.getString("cpf_cliente");
                String nome_cliente = resultSet.getString("nome_cliente");
                String telefone_cliente = resultSet.getString("telefone_cliente");
                String sexo_cliente = resultSet.getString("sexo_cliente");
                String nascimento_cliente = resultSet.getString("nascimento_cliente");
                String email_usuario = resultSet.getString("email_usuario");  
                int ativo_usuario = resultSet.getInt("ativo_usuario");
               
                Cliente cliente = new Cliente(id_cliente, cpf_cliente, nome_cliente, telefone_cliente, sexo_cliente, nascimento_cliente, email_usuario, ativo_usuario);
                listaCliente.add(cliente);
            }
            resultSet.close();
            statement.close();
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaCliente;
    }

    public Cliente get(int id_cliente){ 
        Cliente cliente = null;
        
        String sql = "SELECT * FROM Cliente c, Usuario u WHERE c.id_cliente = ? and c.id_cliente = u.id_usuario";
        try {
            Connection conn = this.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id_cliente);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {              
               
                String cpf_cliente = resultSet.getString("cpf_cliente");
                String nome_cliente = resultSet.getString("nome_cliente");
                String telefone_cliente = resultSet.getString("telefone_cliente");
                String sexo_cliente = resultSet.getString("sexo_cliente");
                String nascimento_cliente = resultSet.getString("nascimento_cliente");
                 String senha_usuario = resultSet.getString("senha_usuario"); 
                String email_usuario = resultSet.getString("email_usuario");
                int ativo_usuario = resultSet.getInt("ativo_usuario");
                cliente = new Cliente(id_cliente, cpf_cliente, nome_cliente, telefone_cliente, sexo_cliente, nascimento_cliente, senha_usuario, email_usuario, ativo_usuario);
            }
            resultSet.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cliente;
    }
        public void update(Cliente cliente) {
        String sql = "UPDATE Cliente SET cpf_cliente = ?,nome_cliente = ?, telefone_cliente = ?, sexo_cliente = ?, nascimento_cliente = ?";
        sql += " WHERE id_cliente = ?";
       
        try {
            Connection conn = this.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, cliente.getId_cliente());
            ps.setString(2, cliente.getCpf_cliente());
            ps.setString(3, cliente.getNome_cliente());
            ps.setString(4, cliente.getTelefone_cliente());
            ps.setString(5, cliente.getSexo_cliente());
            ps.setString(6, cliente.getNascimento_cliente());
            
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
      public void delete(Cliente cliente) {
      
       String sql = "DELETE FROM Cliente where id_cliente = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setInt(1, cliente.getId_cliente());
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.delete(cliente);
    }

}