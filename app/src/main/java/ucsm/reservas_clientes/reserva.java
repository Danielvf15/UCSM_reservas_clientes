package ucsm.reservas_clientes;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class reserva extends Fragment {
    private Button aula,sala_e;
    private View view;
    private FragmentManager fm;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_reserva, container, false);
        aula=view.findViewById(R.id.btn_aula);
        sala_e=view.findViewById(R.id.btn_sala);
        aula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm=getActivity().getSupportFragmentManager();
                fm.beginTransaction().replace(R.id.escenario,new reserva_aula()).commit();
            }
        });
        return view;

    }
}
