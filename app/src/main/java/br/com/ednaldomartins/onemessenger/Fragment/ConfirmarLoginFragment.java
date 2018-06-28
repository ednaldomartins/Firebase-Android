package br.com.ednaldomartins.onemessenger.Fragment;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.ednaldomartins.onemessenger.R;

public class ConfirmarLoginFragment extends Fragment {
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
}

