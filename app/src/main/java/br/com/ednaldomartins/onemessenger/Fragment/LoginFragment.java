package br.com.ednaldomartins.onemessenger.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import br.com.ednaldomartins.onemessenger.R;

public class LoginFragment extends Fragment {


    private EditText nome, regiao, ddd, telefone;
    private Button continuar;
    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        nome = (EditText) view.findViewById(R.id.login_nomeUsuario);
        regiao = (EditText) view.findViewById(R.id.login_codigoPais);
        telefone = (EditText) view.findViewById(R.id.login_numeroTelefone);
        continuar = (Button) view.findViewById(R.id.login_botaoContinuar);

        return view;
    }
/*
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        //super.onViewCreated(view, savedInstanceState);
        nome = (EditText) view.findViewById(R.id.login_nomeUsuario);
        regiao = (EditText) view.findViewById(R.id.login_regiao);
        ddd = (EditText) view.findViewById(R.id.login_ddd);
        telefone = (EditText) view.findViewById(R.id.login_telefone);
        continuar = (Button) view.findViewById(R.id.login_botaoContinuar);

/*
        continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                ConfirmarLoginFragment confirmarLoginFragment = new ConfirmarLoginFragment();

                fragmentTransaction.add(R.id.login_fragment, confirmarLoginFragment);
                fragmentTransaction.commit();
            }
        });

    }
*/
}
