package br.com.ednaldomartins.onemessenger.data.remote;

import android.content.Intent;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import br.com.ednaldomartins.onemessenger.view.Activity.LoginActivity;

public final class ConfiguracaoFirebase {

    private static DatabaseReference referenciaFirebase;
    private static FirebaseAuth autenticacaoFirebase;

    public static DatabaseReference getReferencia()
    {
        if(referenciaFirebase == null)
            referenciaFirebase = FirebaseDatabase.getInstance().getReference();

        return referenciaFirebase;
    }

    //para login com email e senha personalizados.
    public static FirebaseAuth getAutenticacao()
    {
        if(autenticacaoFirebase == null)
            autenticacaoFirebase = FirebaseAuth.getInstance();

        return autenticacaoFirebase;
    }

    public static void setAutenticacao(FirebaseAuth firebaseAuth)
    {
        autenticacaoFirebase = firebaseAuth;
    }

}
