package br.com.ednaldomartins.onemessenger.data.remote;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import br.com.ednaldomartins.onemessenger.model.Usuario;

public class UsuarioFirebase {

    FirebaseUser usuarioFirebase;

    public UsuarioFirebase() {
    }

    public UsuarioFirebase(FirebaseUser usuarioFirebase) {
        this.usuarioFirebase = usuarioFirebase;
    }

    public FirebaseUser getUsuarioFirebase()
    {
        return usuarioFirebase;
    }

    public void setUsuarioFirebase(FirebaseUser usuarioFirebase)
    {
        this.usuarioFirebase = usuarioFirebase;
    }

    public Usuario getObjetoUsuarioFirebaser()
    {
        Usuario usuario = new Usuario();
        usuario.setId(usuarioFirebase.getUid());
        usuario.setName(usuarioFirebase.getDisplayName());
        usuario.setEmail(usuarioFirebase.getEmail());
        return usuario;
    }

    public boolean usuarioLogado()
    {
        if(usuarioFirebase != null) {
            return true;
        }
        else {
            return false;
        }
    }


}
