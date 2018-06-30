package br.com.ednaldomartins.onemessenger.Fragment;

import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import br.com.ednaldomartins.onemessenger.R;

public class ConfirmarLoginFragment extends Fragment {

    private EditText codigoValidacao;
    private Button botaoConfirmar;

    public ConfirmarLoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_confirmar_login, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        //elementos da tela de confirmacao
        codigoValidacao = (EditText) view.findViewById(R.id.login_codigoValidacao);
        botaoConfirmar  = (Button) view.findViewById(R.id.login_botaoContinuar);


        botaoConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}

