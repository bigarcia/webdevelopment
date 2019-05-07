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
    @NamedQuery(name = "Locacao.findAll", query = "SELECT lo FROM Locacao lo"),
    @NamedQuery(name = "Locadora.findById", query = "SELECT lo FROM Locadora lo WHERE lo.id_locacao = :id_locacao")})

public class Locacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int id_locacao;
    private String data_dia;
    private String cpf_cliente;
    private String cnpj_locadora;

    public int getId_locacao() {
        return id_locacao;
    }

    public void setId_locacao(int id_locacao) {
        this.id_locacao = id_locacao;
    }

    public String getData_dia() {
        return data_dia;
    }

    public void setData_dia(String data_dia) {
        this.data_dia = data_dia;
    }

    public String getCpf_cliente() {
        return cpf_cliente;
    }

    public void setCpf_cliente(String cpf_cliente) {
        this.cpf_cliente = cpf_cliente;
    }

    public String getCnpj_locadora() {
        return cnpj_locadora;
    }

    public void setCnpj_locadora(String cnpj_locadora) {
        this.cnpj_locadora = cnpj_locadora;
    }

    
}

   
