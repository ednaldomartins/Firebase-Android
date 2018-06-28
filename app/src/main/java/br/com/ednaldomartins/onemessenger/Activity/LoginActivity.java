package br.com.ednaldomartins.onemessenger.Activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

import br.com.ednaldomartins.onemessenger.Fragment.ConfirmarLoginFragment;
import br.com.ednaldomartins.onemessenger.R;

public class LoginActivity extends AppCompatActivity {

    private EditText nomeUsuario, codigoPais, numeroTelefone, codigoValidacao;
    private Button botaoContinuar, botaoConfirmar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //elementos da tela de login
        nomeUsuario     = (EditText) findViewById(R.id.login_nomeUsuario);
        codigoPais      = (EditText) findViewById(R.id.login_codigoPais);
        numeroTelefone  = (EditText) findViewById(R.id.login_numeroTelefone);
        botaoContinuar  = (Button) findViewById(R.id.login_botaoContinuar);

        //elementos da tela de confirmacao
        codigoValidacao = (EditText) findViewById(R.id.login_codigoValidacao);
        botaoConfirmar  = (Button) findViewById(R.id.login_botaoContinuar);

        //PENSAR SE EH POSSIVEL ALGO MAIS GENERICO, COMO CRIAR OBJETOS Q IMPLEMENTEM UMA INTERFACE.
        formatarMascara(numeroTelefone, "(NN)NNNNN-NNNN");
        formatarMascara(codigoPais, "+NN");


        //chamando a tela de validacao
        botaoContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                ConfirmarLoginFragment confirmarLoginFragment = new ConfirmarLoginFragment();

                fragmentTransaction.add(R.id.login_fragmentLayout, confirmarLoginFragment);
                fragmentTransaction.commit();
            }
        });

    }


    /***
     * Mascara openSource:
     * mascara para adaptacao das entradas dos usuarios na tela de login
     * LINK: https://github.com/rtoshiro/MaskFormatter
     * IMPLEMENTATION: 'com.github.rtoshiro.mflibrary:mflibrary:1.0.0'
     * ***/
    public void formatarMascara (EditText editText, String formato)
    {
        SimpleMaskFormatter mascara = new SimpleMaskFormatter(formato);
        MaskTextWatcher observador = new MaskTextWatcher(editText, mascara);
        editText.addTextChangedListener(observador);
    }

}

