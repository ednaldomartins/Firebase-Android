package br.com.ednaldomartins.onemessenger.Activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.com.ednaldomartins.onemessenger.Fragment.ConfirmarLoginFragment;
import br.com.ednaldomartins.onemessenger.Fragment.LoginFragment;
import br.com.ednaldomartins.onemessenger.R;

public class LoginActivity extends AppCompatActivity {

    private EditText nome, regiao, ddd, telefone, codigo;
    private Button continuar, confirmar;

    Button teste;
    int opt = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        nome = (EditText) findViewById(R.id.login_nomeUsuario);
        regiao = (EditText) findViewById(R.id.login_regiao);
        ddd = (EditText) findViewById(R.id.login_ddd);
        telefone = (EditText) findViewById(R.id.login_telefone);
        continuar = (Button) findViewById(R.id.login_botaoContinuar);

        codigo = (EditText) findViewById(R.id.login_codigoValidacao);
        confirmar = (Button) findViewById(R.id.login_botaoContinuar);


        continuar.setOnClickListener(new View.OnClickListener() {
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
}
