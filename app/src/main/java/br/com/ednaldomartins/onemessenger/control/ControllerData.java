package br.com.ednaldomartins.onemessenger.control;

import br.com.ednaldomartins.onemessenger.data.local.UsuarioPreferencias;
import br.com.ednaldomartins.onemessenger.data.remote.ConfiguracaoFirebase;
import br.com.ednaldomartins.onemessenger.model.UsuarioFirebase;
import br.com.ednaldomartins.onemessenger.model.Usuario;
import br.com.ednaldomartins.onemessenger.view.Activity.LoginActivity;

/****************************************************************************
 * Essa é uma classe controladora. Ela eh responsavel por intermediar       *
 * entre View e Model para que os dados do usuario sejam salvos localmente  *
 * e também remotamente.                                                    *
 ****************************************************************************/
public class ControllerData {

    UsuarioFirebase usuarioFirebase;
    UsuarioPreferencias usuarioPreferencias;

    public ControllerData() {
    }

    /**
     * Pega os dados do usuario que estao salvos no firebase e retorna-os como
     * Objeto Usuario.
     * @return Objeto Usuario
     */
    public Usuario getObjetoUsuarioFirebase()
    {
        Usuario usuario = new Usuario();
        usuario.setId(usuarioFirebase.getFirebaseUser().getUid());
        usuario.setNome(usuarioFirebase.getFirebaseUser().getDisplayName());
        usuario.setEmail(usuarioFirebase.getFirebaseUser().getEmail());
        return usuario;
    }


    /****************************************************************************
     * Metodo para salvar os dados do usuario                                   *
     * Esse metodo chama os metodos para salvar os dados do usuario logado no   *
     * firebase, localmente e também remotamente no proprio banco de dados do   *
     * firebase.                                                                *
     ****************************************************************************/
    public void salvarUsuario(LoginActivity loginActivity) {
        usuarioFirebase = new UsuarioFirebase( ConfiguracaoFirebase.getAutenticacao().getCurrentUser() );
        usuarioPreferencias = new UsuarioPreferencias( loginActivity.getApplicationContext() );
        Usuario auxUsuario = this.getObjetoUsuarioFirebase();
        usuarioPreferencias.salvarUsuarioPreferencias( auxUsuario );
        ConfiguracaoFirebase.getReferencia().child("usuarios").child( usuarioFirebase.getId() ).setValue( auxUsuario );
    }

    public boolean usuarioLogado()
    {
        if(ConfiguracaoFirebase.getAutenticacao().getCurrentUser() != null) {
            return true;
        }
        else {
            return false;
        }
    }
}
