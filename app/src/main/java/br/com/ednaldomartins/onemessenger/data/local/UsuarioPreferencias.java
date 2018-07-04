package br.com.ednaldomartins.onemessenger.data.local;

import android.content.Context;
import android.content.SharedPreferences;

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

    public void salvarUsuarioPreferencisas(Usuario usuario)
    {
        editor.putString(CHAVE_ID, usuario.getId());
        editor.putString(CHAVE_NOME, usuario.getNome());
        editor.putString(CHAVE_EMAIL, usuario.getEmail());
        editor.commit();
    }

}
