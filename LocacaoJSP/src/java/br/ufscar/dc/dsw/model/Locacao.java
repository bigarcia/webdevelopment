package br.ufscar.dc.dsw.model;


public class Locacao {
    private int id_locacao;
    private String cpf_locacao;
    private String cnpj_locadora;
    private String data_dia_locadora;

    public int getId_locacao() {
        return id_locacao;
    }

    public void setId_locacao(int id_locacao) {
        this.id_locacao = id_locacao;
    }

    public String getData_dia_locadora() {
        return data_dia_locadora;
    }

    public void setData_dia_locadora(String data_dia_locadora) {
        this.data_dia_locadora = data_dia_locadora;
    }


}
