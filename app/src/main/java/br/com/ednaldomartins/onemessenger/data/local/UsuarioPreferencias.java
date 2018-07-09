package br.com.ednaldomartins.onemessenger.data.local;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;

import br.com.ednaldomartins.onemessenger.model.Usuario;

public class UsuarioPreferencias {
    private Context contexto;
    private SharedPreferences preferencias;
    private SharedPreferences.Editor editor;
    private static String NOME_ARQUIVO = "onemessenger.preferencias";
    private int MODO_PRIVADO = 0;

    private String CHAVE_ID = "id";
    private String CHAVE_NOME = "nome";
    private String CHAVE_EMAIL = "email";

    public UsuarioPreferencias(Context contexto) {
        this.contexto = contexto;
        preferencias = this.contexto.getSharedPreferences(NOME_ARQUIVO, MODO_PRIVADO);
        editor = preferencias.edit();
    }

    public void salvarUsuarioPreferencias(Usuario usuario)
    {
        editor.putString(CHAVE_ID, usuario.getId());
        editor.putString(CHAVE_NOME, usuario.getNome());
        editor.putString(CHAVE_EMAIL, usuario.getEmail());
        editor.commit();
    }

    public HashMap <String, String> getDadosUsuariosPreferencias ()
    {
        HashMap<String, String> dadosUsuario = new HashMap<>();
        //dadosUsuario.put(CHAVE_ID, preferencias.getString(CHAVE_ID, null) );
        dadosUsuario.put( CHAVE_NOME, preferencias.getString(CHAVE_NOME, null) );
        dadosUsuario.put(CHAVE_EMAIL, preferencias.getString(CHAVE_EMAIL, null) );

        return dadosUsuario;
    }


    public String getCHAVE_ID() {
        return CHAVE_ID;
    }

    public String getCHAVE_NOME() {
        return CHAVE_NOME;
    }

    public String getCHAVE_EMAIL() {
        return CHAVE_EMAIL;
    }
}
