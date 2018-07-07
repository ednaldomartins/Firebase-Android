package br.com.ednaldomartins.onemessenger.model;

public class Usuario {

    private String id;
    private String nome;
    private String email;

    public Usuario() {
    }


    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
