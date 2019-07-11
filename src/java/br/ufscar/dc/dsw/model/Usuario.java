/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.model;

/**
 *
 * @author Bianca
 */


public class Usuario {
    
    private int id_usuario;
    private String email_usuario;
    private String senha_usuario;
    private int ativo_usuario;
    
    public Usuario(int id, String email, String senha, int ativo) {
        this.id_usuario = id;
        this.email_usuario = email;
        this.senha_usuario = senha;
        this.ativo_usuario = ativo;
    }

    public Usuario(String email, String senha, int ativo){
        this.email_usuario = email;
        this.senha_usuario = senha;      
        this.ativo_usuario = ativo;
    }
    
    public Usuario(String email, int ativo){
        this.email_usuario = email;
        this.ativo_usuario = ativo;
    }
    
    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id) {
        this.id_usuario = id;
    }

    public String getEmail_usuario() {
        return email_usuario;
    }

    public void setEmail_usuario(String email) {
        this.email_usuario = email;
    }

    public String getSenha_usuario() {
        return senha_usuario;
    }

    public void setSenha_usuario(String senha) {
        this.senha_usuario = senha;
    }
    
    public int getAtivo_usuario() {
        return ativo_usuario;
    }

    public void setAtivo_usuario(int ativo) {
        this.ativo_usuario = ativo;
    }
}