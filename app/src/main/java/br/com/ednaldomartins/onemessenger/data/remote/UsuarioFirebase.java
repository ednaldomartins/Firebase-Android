package br.com.ednaldomartins.onemessenger.data.remote;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import br.com.ednaldomartins.onemessenger.model.Usuario;

public class UsuarioFirebase {

    FirebaseUser firebaseUser;

    public UsuarioFirebase() {
    }

    public UsuarioFirebase(FirebaseUser firebaseUser) {
        this.firebaseUser = firebaseUser;
    }

    public FirebaseUser getFirebaseUser()
    {
        return firebaseUser;
    }

    public void setFirebaseUser(FirebaseUser firebaseUser)
    {
        this.firebaseUser = firebaseUser;
    }

    public Usuario getUsuarioFirebaser()
    {
        Usuario usuario = new Usuario();
        usuario.setId(firebaseUser.getProviderId());
        usuario.setName(firebaseUser.getDisplayName());
        usuario.setEmail(firebaseUser.getEmail());
        return usuario;
    }

    public boolean usuarioLogado()
    {
        if(firebaseUser != null) {
            return true;
        }
        else {
            return false;
        }
    }

    private void signOut()
    {
        FirebaseAuth.getInstance().signOut();
    }

}
