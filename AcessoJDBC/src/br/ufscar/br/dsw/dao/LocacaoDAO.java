package br.ufscar.br.dsw.dao;
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

    private final static String CRIAR_LOCACAO_SQL = "insert into Locadora" + " (email_locadora, senha_locadora, cnpj_locadora, nome_locadora, cidade_locadora)" + "values(?,?,?,?,?)";
    private final static String LISTAR_LOCACAO_CLIENTE_SQL = "select" + "*" + " from Locacao where cliente.cpf_cliente = locacao.cpf_cliente";
    private final static String LISTAR_LOCACAO_LOCADORA_SQL = "select" + "*" + " from Locacao where locadora.cnpj_cliente = locacao.cnpj_cliente";

    public Locacao gravarLocacao(Locacao locacao) throws SQLException {
        try (Connection con = this.getConnection()) {
            PreparedStatement ps = con.prepareStatement(CRIAR_LOCACAO_SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, locacao.getId_locacao());
            ps.setString(2, locacao.getData_dia_locadora());
            
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            locacao.setId_locacao(rs.getInt(1));
        }
        return locacao;
    }
    
    public List<Locacao> listarTodasLocacoesPorCliente(String cliente) throws SQLException {
        List<Locacao> ret = new ArrayList<>();
        try (Connection con = this.getConnection()) {
            PreparedStatement ps = con.prepareStatement(LISTAR_LOCACAO_CLIENTE_SQL);
            ps.setString(1, cliente);
            ps.setString(2, cliente);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Locacao locacao = new Locacao();
                /*Locadora locadora = new Locadora();
                Cliente cliente = new Cliente();*/
                
                locacao.setId_locacao(rs.getInt("id_locacao"));
                locacao.setData_dia_locadora(rs.getString("data_dia_locadora"));           
               /* cliente.setCpf_cliente(rs.getString("cpf_cliente"));
                locadora.setCpnj_locadora(rs.getString("cnpj_locadora"));*/
                ret.add(locacao);
            }
        }
        return ret;
    }

   
}

