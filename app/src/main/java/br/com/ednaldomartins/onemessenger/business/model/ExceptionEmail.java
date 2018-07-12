package br.com.ednaldomartins.onemessenger.business.model;

public class ExceptionEmail extends Exception {

    public ExceptionEmail()
    {
        super("ERRO: e-mail inválido.");
    }

    public ExceptionEmail (String mensagem)
    {
        super(mensagem);
    }

}
