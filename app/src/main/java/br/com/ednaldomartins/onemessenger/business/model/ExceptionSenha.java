package br.com.ednaldomartins.onemessenger.business.model;

import android.support.annotation.NonNull;

import com.google.android.gms.common.api.Status;

public class ExceptionSenha extends Exception{

    public ExceptionSenha() {
        super("ERRO: senha inválida");
    }

    public ExceptionSenha(String mensagem)
    {
        super(mensagem);
    }
}
