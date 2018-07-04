package br.com.ednaldomartins.onemessenger.model;

public class Usuario {

    private String id;
    private String name;
    private String email;

    public Usuario() {
    }


    public String getId() {
        return id;
    }

    public String getNome() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String nome) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
