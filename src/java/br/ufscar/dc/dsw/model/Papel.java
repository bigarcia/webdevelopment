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
public class Papel {
    
    private int id_papel;
    private String email_papel;
    private String nome_papel;
    
    public Papel(int id, String email, String nome) {
        this.id_papel = id;
        this.email_papel = email;
        this.nome_papel = nome;
    }
    
    public Papel(String email, String nome) {
        this.email_papel = email;
        this.nome_papel = nome;
    }

    public int getId_papel() {
        return id_papel;
    }

    public void setId_papel(int id) {
        this.id_papel = id;
    }

    public String getEmail_papel() {
        return email_papel;
    }

    public void setEmail_papel(String email) {
        this.email_papel = email;
    }

    public String getNome_papel() {
        return nome_papel;
    }

    public void setNome_papel(String nome) {
        this.nome_papel = nome;
    }
}