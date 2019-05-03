package br.ufscar.dc.dsw.model;

import java.sql.Date;
import java.sql.Time;

public class Locacao {
    private int id_locacao;
    private String dia_locacao;
    private String hora_locacao;
    private String cpf_cliente;
    private String cnpj_locadora;

    public Locacao(int id_locacao, String dia_locacao, String hora_locacao, String cpf_cliente, String cnpj_locadora) {
        this.id_locacao = id_locacao;
        this.dia_locacao = dia_locacao;
        this.hora_locacao = hora_locacao;
        this.cpf_cliente = cpf_cliente;
        this.cnpj_locadora = cnpj_locadora;
    }

    public Locacao(int id) {
        this.id_locacao = id;
    }
  
   
    public int getId_locacao() {
        return id_locacao;
    }

    public String getDia_locacao() {
        return dia_locacao;
    }
    
    public String getHora_locacao(){
        return hora_locacao;
    }

    public String getCpf_cliente() {
        return cpf_cliente;
    }

    public String getCnpj_locadora() {
        return cnpj_locadora;
    }

    public void setId_locacao(int id_locacao) {
        this.id_locacao = id_locacao;
    }

    public void setDia_locacao(String dia_locacao) {
        this.dia_locacao = dia_locacao;
    }
    
     public void setHora_locacao(String hora_locacao) {
        this.hora_locacao = hora_locacao;
    }

    public void setCpf_cliente(String cpf_cliente) {
        this.cpf_cliente = cpf_cliente;
    }
    public void setCnpj_locadora(String cnpj_locadora) {
        this.cnpj_locadora = cnpj_locadora;
    }

}