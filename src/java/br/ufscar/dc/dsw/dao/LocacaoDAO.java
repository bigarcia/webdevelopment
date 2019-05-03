package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.dao.GenericDAO;
import br.ufscar.dc.dsw.model.Locacao;
import br.ufscar.dc.dsw.model.Locadora;
import br.ufscar.dc.dsw.model.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LocacaoDAO extends GenericDAO {

    public void insert(Locacao locacao){
        String sql = "INSERT INTO Locacao (dia_locacao, hora_locacao,  cpf_cliente, cnpj_locadora)" + "values(?,?,?,?)";
        try {
            Connection con = this.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, locacao.getDia_locacao());
            ps.setString(2, locacao.getHora_locacao());
            ps.setString(3, locacao.getCpf_cliente());
            ps.setString(4, locacao.getCnpj_locadora());

            ps.executeUpdate();
            ps.close();
            con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Locacao get(int id_locacao) {
        Locacao locacao = null;
        String sql = "SELECT * FROM Locacao WHERE id_locacao = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id_locacao);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                String dia_locacao = resultSet.getString("dia_locacao");
                String hora_locacao = resultSet.getString("hora_locacao");
                String cpf_cliente = resultSet.getString("cpf_cliente");
                String cnpj_locadora = resultSet.getString("cnpj_locadora");
                locacao = new Locacao(id_locacao, dia_locacao, hora_locacao, cpf_cliente, cnpj_locadora);
            }

            resultSet.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return locacao;
    }
     public List<Locacao> getAll(String cpf_cnpj, String usuario) {
        List<Locacao> listaLocacao = new ArrayList<>();
        String sql = "SELECT * FROM Locacao lo, Usuario u WHERE lo.id_locacao = u.id_usuario ";
        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();
            ResultSet rset = statement.executeQuery(sql);
            while (rset.next()) {
                int id_locacao = rset.getInt("id_locacao");
                String dia_locacao = rset.getString("dia_locacao");
                String hora_locacao = rset.getString("hora_locacao");
                String cpf_cliente = rset.getString("cpf_cliente");
                String cnpj_locadora = rset.getString("cnpj_locadora");
               

                Locacao locacao = new Locacao(id_locacao, dia_locacao, hora_locacao, cpf_cliente, cnpj_locadora);
                listaLocacao.add(locacao);
            }
            rset.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaLocacao;
    } 
     
    public List<Locacao> getbyClient(String cliente_locacao) {
        List<Locacao> listaLocacaoCliente = new ArrayList<>();
        String sql = "SELECT * FROM Locacao lo WHERE lo.cpf_cliente = ?";
        try  {
            Connection con = this.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cliente_locacao);
            ResultSet rset = ps.executeQuery();
            while (rset.next()) {
                int id_locacao = rset.getInt("id_locacao");
                String dia_locacao = rset.getString("dia_locacao");
                String hora_locacao = rset.getString("hora_locacao");                
                String cpf_cliente = rset.getString("cpf_cliente");
                String cnpj_locadora = rset.getString("cnpj_locadora");
                Locacao locacao = new Locacao(id_locacao, dia_locacao, hora_locacao, cpf_cliente, cnpj_locadora);

                listaLocacaoCliente.add(locacao);
            }
            rset.close();
            ps.close();
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaLocacaoCliente;
    }
   
    public List<Locacao> getbyAgency(String cliente_locacao) {
        List<Locacao> listaLocacaoCliente = new ArrayList<>();
        String sql = "SELECT * FROM Locacao lo WHERE lo.cnpj_locadora = ?";
        try  {
            Connection con = this.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cliente_locacao);
            ResultSet rset = ps.executeQuery();
            while (rset.next()) {
                int id_locacao = rset.getInt("id_locacao");
                String dia_locacao = rset.getString("dia_locacao");
                String hora_locacao = rset.getString("hora_locacao");                
                String cpf_cliente = rset.getString("cpf_cliente");
                String cnpj_locadora = rset.getString("cnpj_locadora");
                Locacao locacao = new Locacao(id_locacao, dia_locacao, hora_locacao, cpf_cliente, cnpj_locadora);

                listaLocacaoCliente.add(locacao);
            }
            rset.close();
            ps.close();
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaLocacaoCliente;
    }
       

    public void delete(Locacao locacao) {
        String sql = "DELETE FROM Locacao WHERE id_locacao = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setInt(1, locacao.getId_locacao());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Locacao locacao) {
        String sql = "UPDATE Locacao SET dia_locacao = ?, hora_locacao = ?, cpf_cliente = ?, cnpj_locadora = ?";
        sql += " WHERE id_locacao = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, locacao.getDia_locacao());
            ps.setString(1, locacao.getHora_locacao());
            ps.setString(2, locacao.getCpf_cliente());
            ps.setString(3, locacao.getCnpj_locadora());
            ps.setInt(4, locacao.getId_locacao());
            
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    
}
