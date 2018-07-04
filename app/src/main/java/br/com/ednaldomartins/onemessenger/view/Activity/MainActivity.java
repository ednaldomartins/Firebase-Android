package br.com.ednaldomartins.onemessenger.view.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.google.firebase.auth.FirebaseUser;

import br.com.ednaldomartins.onemessenger.R;


public class MainActivity extends AppCompatActivity {




    @Override
    public void onStart() {
        super.onStart();
    }


    /**
     * @param savedInstanceState
     * encontrando botao de login e chamando metodos para autenticacao
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }



}
