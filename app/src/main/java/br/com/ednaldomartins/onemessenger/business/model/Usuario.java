package br.com.ednaldomartins.onemessenger.business.model;

import com.google.firebase.database.Exclude;

public class Usuario {

    private String id;
    private String nome;
    private String email;
    private String senha;

    public Usuario() {
    }

    /****************************************************************************
     * GETs e SETs:                                                             *
     * Os GETs de ID e Senha estao com @Exclude para que o firebase não recupere*
     *  esses dados e os coloque no banco de dados do firebase.                 *
     ****************************************************************************/
    @Exclude
    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    @Exclude
    public String getSenha() {
        return senha;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
