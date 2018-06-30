package br.com.ednaldomartins.onemessenger.Fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import br.com.ednaldomartins.onemessenger.R;

public class LoginFragment extends Fragment {


    private EditText nomeUsuario, codigoPais, numeroTelefone, codigoValidacao;
    private Button botaoContinuar, botaoConfirmar;

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        //elementos da tela de login
        nomeUsuario     = (EditText) view.findViewById(R.id.login_nomeUsuario);
        codigoPais      = (EditText) view.findViewById(R.id.login_codigoPais);
        numeroTelefone  = (EditText) view.findViewById(R.id.login_numeroTelefone);
        botaoContinuar  = (Button) view.findViewById(R.id.login_botaoContinuar);

        //PENSAR SE EH POSSIVEL ALGO MAIS GENERICO, COMO CRIAR OBJETOS QUE IMPLEMENTEM UMA INTERFACE.
        formatarMascara(numeroTelefone, "(NN)NNNNN-NNNN");
        formatarMascara(codigoPais, "+NN");


        //chamando a tela de validacao
        botaoContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /**
                 * usar FACADE para configurar todas as opreções abaixo em outra classe
                 * que ficarah responsavel por todas as funcoes
                 */
                //guardando apenas valores em variaveis auxiliares
                String nomeCompleto = nomeUsuario.getText().toString();
                String telefoneCompleto = codigoPais.getText().toString() + numeroTelefone.getText().toString();
                //truncando valores do telefone para guardar apenas numeros
                telefoneCompleto.replace("+", "");
                telefoneCompleto.replace("(", "");
                telefoneCompleto.replace(")", "");
                telefoneCompleto.replace("-", "");

                //String telefoneSemFormatacao = telefoneCompleto.replaceAll("[^0-9]" ,"");

                //gerar codigo de validacao(TESTE)
                Random random = new Random();
                int codigoDeValidacao = random.nextInt(899999) + 100000;
                /**
                 * usar o fireBase para autenticacao:
                 * https://firebase.google.com/docs/auth/android/phone-auth?hl=pt-br

                PhoneAuthProvider.getInstance().verifyPhoneNumber(
                        telefoneCompleto,
                        60,
                        TimeUnit.SECONDS,
                        this,
                        mCallbacks);
                */

                //transicao entre os fragmentos
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
