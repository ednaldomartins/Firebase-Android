package br.com.ednaldomartins.onemessenger.business.model;

import com.google.firebase.auth.FirebaseUser;


public class UsuarioFirebase {

    FirebaseUser firebaseUser;

    //Construtores
    public UsuarioFirebase() {
    }

    public UsuarioFirebase(FirebaseUser firebaseUser) {
        this.firebaseUser = firebaseUser;
    }


    public FirebaseUser getFirebaseUser() {
        return firebaseUser;
    }

    //GETs reduzidos para outras classes
    public String getId () {
        return this.firebaseUser.getUid();
    }

    public String getNome () {
        return this.firebaseUser.getDisplayName();
    }

    public String getEmail () {
        return this.firebaseUser.getEmail();
    }


    public void setFirebaseUser(FirebaseUser firebaseUser) {
        this.firebaseUser = firebaseUser;
    }


}
