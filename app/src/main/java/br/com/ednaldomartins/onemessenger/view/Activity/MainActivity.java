package br.com.ednaldomartins.onemessenger.view.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseUser;

import br.com.ednaldomartins.onemessenger.R;
import br.com.ednaldomartins.onemessenger.data.remote.ConfiguracaoFirebase;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button botaoSair;

    @Override
    public void onStart() {
        super.onStart();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(!ConfiguracaoFirebase.usuarioLogado()) {
            startActivity( new Intent(MainActivity.this, LoginActivity.class) );
        }

        initViews();
        initListener();
    }


    private void initViews ()
    {
        botaoSair = findViewById(R.id.main_botaoTesteSair);

    }

    private void initListener ()
    {
        findViewById(R.id.main_botaoTesteSair).setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        int id = view.getId();

        if (id == R.id.main_botaoTesteSair) {
            ConfiguracaoFirebase.getAutenticacao().signOut();
            startActivity( new Intent(MainActivity.this, LoginActivity.class) );
        }
    }
}
