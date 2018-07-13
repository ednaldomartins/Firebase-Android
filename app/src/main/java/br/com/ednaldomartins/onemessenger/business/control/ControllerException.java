package br.com.ednaldomartins.onemessenger.business.control;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.IOException;
import java.net.ConnectException;

import br.com.ednaldomartins.onemessenger.business.model.ExceptionEmail;
import br.com.ednaldomartins.onemessenger.business.model.ExceptionSenha;


/****************************************************************************
 * Classe para controlar excecoes:                                          *
 * Esse controlador deve verificar em tempo de execucao quando possivel, se *
 * ocorreu algum tipo de erro, e venha lancar para o usuario uma mensagem   *
 * do que pode ter provocado o erro.                                        *
 ****************************************************************************/
public class ControllerException {

    public boolean verificarEmail (String login) throws ExceptionEmail
    {

        if(login == "") {
            throw new ExceptionEmail("E-mail inválido, digite alguma coisa.");
        }

        if(login.length() > 15) {
            throw new ExceptionEmail(login + " é um login inválido. O tamanho máximo permitido para o e-mail é de apenas 15 digitos.");
        }

        //falta usar verificacao de email existente

        return true;

    }



    public boolean verificarLoginUsuario (String login) throws ExceptionEmail {
        if(login == "") {
            throw new ExceptionEmail("E-mail inválido, digite alguma coisa.");
        }

        if(login.length() > 15) {
            throw new ExceptionEmail(login + " é um login inválido. O tamanho máximo permitido para o e-mail é de apenas 15 digitos.");
        }

        if( login.matches(".*\\d.*") ) {
            throw new ExceptionEmail(login + " é um login invalido. Apenas letras sao permitidas no login de usuario.");
        }

        return true;
    }

    public boolean verificarSenhaComplexa (String senha) throws ExceptionSenha
    {

        verificarTamanhoDaSenha(senha);

        //contador para numero e letra
        int a = 0, c = 0;
        for(int i = 0; i < senha.length(); i++) {
            if( Character.isDigit(senha.charAt(i)) ) {
                a++;
            }
            else if( Character.isAlphabetic(senha.charAt(i)) ) {
                c++;
            }
        }

        if(a < 2 ) {
            throw new ExceptionSenha(senha + " é uma senha inválida, digite pelo menos 2 numeros na senha.");
        }

        if(c == 0) {
            throw new ExceptionSenha(senha + " é uma senha inválida, digite pelo menos uma letra na senha.");
        }

        return true;
    }



    public boolean verificarSenhaComLetras (String senha) throws ExceptionSenha
    {
        verificarTamanhoDaSenha(senha);

        //contador para letras
        int a = 0;
        for(int i = 0; i < senha.length(); i++) {
            if( Character.isAlphabetic(senha.charAt(i)) )
                a++;
        }

        if(a == 0) {
            throw new ExceptionSenha(senha + " é uma senha inválida, digite pelo menos uma letra na senha.");
        }

        return true;
    }



    public boolean verificarSenhaSimples (String senha) throws ExceptionSenha
    {
        verificarTamanhoDaSenha(senha);
        return true;
    }


    /**
     * metodo privado apenas para ser chamado pela propria classe controladora.
     * deve auxiliar os demais metodos apenas verificando se o tamanho da senha
     * estah correto. 6 < tamanhaDaSenha < 18
     * @param senha
     * @return true se a senha estah dentro do tamanho recomendado
     * @throws ExceptionSenha
     */
    private boolean verificarTamanhoDaSenha (String senha) throws ExceptionSenha {
        if(senha.length() > 18) {
            throw new ExceptionSenha(senha + " é uma senha inválida, o tamanho máximo permitido para a senha e de 18 digitos.");
        }

        if(senha.length() < 6) {
            throw new ExceptionSenha(senha + " é uma senha inválida, o tamanho mínimo permitido para a senha e de 6 digitos.");
        }

        return true;
    }


    //precisa ser testado
    //ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
    public boolean verificarConeccao (ConnectivityManager connectivityManager) throws IOException
    {
        if(  ! (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) ) {
            //nao estah conectado
            return false;
        }

        return true;
    }



}
