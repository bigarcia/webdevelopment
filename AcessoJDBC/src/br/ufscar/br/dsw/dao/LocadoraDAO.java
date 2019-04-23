package br.ufscar.br.dsw.dao; 

import br.ufscar.dc.dsw.model.Locadora;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LocadoraDAO extends GenericDAO {

    private final static String CRIAR_LOCADORA_SQL = "insert into Locadora" + " (email_locadora, senha_locadora, cnpj_locadora, nome_locadora, cidade_locadora)" + "values(?,?,?,?,?)";
    private final static String LISTAR_LOCADORA_SQL = "select" + "*" + "from locadora" ; 
//private final static String LISTAR_LOCADORA_SQL = "select" + "email_locadora, cnpj_locadora, nome_locadora, cidade_locadora)"+ "from locadora" ;
    private final static String LISTAR_LOCADORA_CIDADE_SQL = "select" + "email_locadora, cnpj_locadora, nome_locadora, cidade_locadora)" + "where cidade_locadora = ?";

    public Locadora gravarLocadora(Locadora locadora) throws SQLException {
        try (Connection con = this.getConnection()) {
            PreparedStatement ps = con.prepareStatement(CRIAR_LOCADORA_SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, locadora.getEmail_locadora());
            ps.setString(2, locadora.getSenha_locadora());
            ps.setString(3, locadora.getCnpj_locadora());
            ps.setString(4, locadora.getNome_locadora());
            ps.setString(5, locadora.getCidade_locadora());
            
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            locadora.setId_locadora(rs.getInt(1));
        }
        return locadora;
    }
		
		
	

    public List<Locadora> listarTodasLocadoras() throws SQLException {
        List<Locadora> ret = new ArrayList<>();
        try (Connection con = this.getConnection()) {
            PreparedStatement ps = con.prepareStatement(LISTAR_LOCADORA_SQL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Locadora locadora = new Locadora();
                //Usuario usuario = new Usuario();
                locadora.setId_locadora(rs.getInt("id_locadora"));
                locadora.setEmail_locadora(rs.getString("email_locadora"));
                locadora.setSenha_locadora(rs.getString("senha_locadora"));
                locadora.setCpnj_locadora(rs.getString("cnpj_locadora"));
                locadora.setNome_locadora(rs.getString("nome_locadora"));
                locadora.setCidade_locadora(rs.getString("cidade_locadora"));

                //locadora.setLocadora(locadora);
                ret.add(locadora);

            }
        }
        return ret;
    }

    public List<Locadora> listarTodasLocadorasPorCidade(String cidade_locadora) throws SQLException {
        List<Locadora> ret = new ArrayList<>();

        try (Connection con = this.getConnection()) {
            PreparedStatement ps = con.prepareStatement(LISTAR_LOCADORA_CIDADE_SQL);
            ps.setString(1, cidade_locadora);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Locadora locadora = new Locadora();
                //Usuario usuario = new Usuario();
                locadora.setId_locadora(rs.getInt("id_locadora"));
                locadora.setEmail_locadora(rs.getString("email_locadora"));
                locadora.setSenha_locadora(rs.getString("senha_locadora"));
                locadora.setCpnj_locadora(rs.getString("cnpj_locadora"));
                locadora.setNome_locadora(rs.getString("nome_locadora"));
                locadora.setCidade_locadora(rs.getString("cidade_locadora"));

                ret.add(locadora);

            }
        }
        return ret;
    }
}
