package br.ufscar.dc.dsw.pojo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
    @NamedQuery(name = "Locaodora.findAll", query = "SELECT l FROM Locadora l"),
    @NamedQuery(name = "Locadora.findByCidade", query = "SELECT l FROM Locadora l WHERE l.cidade_locadora = :cidade_locadora")})

public class Locadora implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id_locadora;
     private String email_locadora;
    private String senha_locadora;
    private String cnpj_locadora;
    private String nome_locadora;
    private String cidade_locadora;
    
    public Long getId_locadora() {
        return id_locadora;
    }

    public void setId_locadora(Long id_locadora) {
        this.id_locadora = id_locadora;
    }

    public String getEmail_locadora() {
        return email_locadora;
    }

    public void setEmail_locadora(String email_locadora) {
        this.email_locadora = email_locadora;
    }

    public String getSenha_locadora() {
        return senha_locadora;
    }

    public void setSenha_locadora(String senha_locadora) {
        this.senha_locadora = senha_locadora;
    }

    public String getCnpj_locadora() {
        return cnpj_locadora;
    }

    public void setCnpj_locadora(String cnpj_locadora) {
        this.cnpj_locadora = cnpj_locadora;
    }

    public String getNome_locadora() {
        return nome_locadora;
    }

    public void setNome_locadora(String nome_locadora) {
        this.nome_locadora = nome_locadora;
    }

    public String getCidade_locadora() {
        return cidade_locadora;
    }

    public void setCidade_locadora(String cidade_locadora) {
        this.cidade_locadora = cidade_locadora;
    }
}

   
