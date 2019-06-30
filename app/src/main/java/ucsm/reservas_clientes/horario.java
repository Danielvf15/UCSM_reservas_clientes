package ucsm.reservas_clientes;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TableLayout;

import java.util.ArrayList;

import ucsm.reservas_clientes.Entidades.Alumno;
import ucsm.reservas_clientes.Entidades.AplicacionDB;
import ucsm.reservas_clientes.Entidades.Pabellon;
import ucsm.reservas_clientes.Entidades.Reserva;


public class horario extends Fragment {
    //Context context;
    View view;
    Button horario;
    TableLayout tabla_horario;
    ArrayList<Reserva> listReserva;
    RecyclerView recycler2;
    Spinner pabellon,aula;
    private SQLiteDatabase db;
    ArrayList<String> list;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_horario, container, false);
        //context=container.getContext();
        Castear();
        recycler2.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false));
        listReserva=new ArrayList<>();
        recycler2.setLayoutManager(new LinearLayoutManager(getActivity()));
        consultarLista();
        AdaptadorDatos adapter=new AdaptadorDatos(listReserva);
        recycler2.setAdapter(adapter);
        horario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                recycler2.setVisibility(View.VISIBLE);
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        AplicacionDB application=new AplicacionDB(getActivity());
        db=application.getReadableDatabase();
    }

    private void Castear(){
        horario=view.findViewById(R.id.btn_buscar);
        tabla_horario=view.findViewById(R.id.tb_horario);
        pabellon=view.findViewById(R.id.spn_pabellon);
        aula=view.findViewById(R.id.spn_aula);
        recycler2=view.findViewById(R.id.recicler2);

    }

    private void consultarLista() {
        AplicacionDB aplication=new AplicacionDB(getContext());
        db=aplication.getReadableDatabase();
        Reserva reserva=null;
        String query="Select codigo_pabellon,codigo_aula,hora from Reserva_aula where estado='true'";
        Cursor cursor=db.rawQuery(query,null);
        while (cursor.moveToNext()){
            reserva=new Reserva();
            reserva.setCod_pabellon(cursor.getString(0));
            reserva.setCod_aula(cursor.getString(1));
            reserva.setHora(cursor.getString(2));
            listReserva.add(reserva);
        }
    }

}
