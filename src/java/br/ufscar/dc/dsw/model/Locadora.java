package br.ufscar.dc.dsw.model;

public class Locadora extends Usuario{

    private int id_locadora; 
    private String cnpj_locadora;
    private String nome_locadora;
    private String cidade_locadora;

    public Locadora(int id_locadora,String cnpj_locadora, String nome_locadora, String cidade_locadora, String senha_usuario, String email_usuario, int ativo_usuario) {
        super(senha_usuario, email_usuario,ativo_usuario);
        this.id_locadora = id_locadora;
        this.cnpj_locadora = cnpj_locadora;
        this.nome_locadora = nome_locadora;
        this.cidade_locadora = cidade_locadora;
    }

    public Locadora(int id_locadora, String cnpj_locadora, String nome_locadora, String cidade_locadora, String email_usuario, int ativo_usuario){
        super(email_usuario,ativo_usuario);
        this.id_locadora = id_locadora;
        this.cnpj_locadora = cnpj_locadora;
        this.nome_locadora = nome_locadora;
        this.cidade_locadora = cidade_locadora;
    }

   
    
    public Locadora (int id_locadora){
        super(null, null, -1);
        this.id_locadora = id_locadora;
    }

    public int getId_locadora() {
        return id_locadora;
    }

    public void setId_locadora(int id_locadora) {
        this.id_locadora = id_locadora;
    }
 

    public String getCnpj_locadora() {
        return cnpj_locadora;
    }

    public void setCpnj_locadora(String cnpj_locadora) {
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