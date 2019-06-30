package ucsm.reservas_clientes;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.ArrayList;
import java.util.SplittableRandom;

import ucsm.reservas_clientes.Entidades.AplicacionDB;
import ucsm.reservas_clientes.Entidades.Reserva;


public class reserva_aula extends Fragment {
    private View view;
    private Button buscar,reservar;
    private Spinner pabellon,aula;
    ArrayList<Reserva> listReserva;
    RecyclerView recycler;
    SQLiteDatabase db;
    String hora;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_reserva_aula, container, false);
        Castear();
        recycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false));
        listReserva=new ArrayList<>();
        recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        consultarLista();
        AdaptadorDatos adapter=new AdaptadorDatos(listReserva);
        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hora=listReserva.get(recycler.getChildAdapterPosition(view)).getHora();
                Snackbar snackbar=Snackbar.make(container,"Hora:"+listReserva.get(recycler.getChildAdapterPosition(view)).getHora(),Snackbar.LENGTH_INDEFINITE);
                snackbar.show();
            }
        });
        recycler.setAdapter(adapter);
        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recycler.setVisibility(View.VISIBLE);
                reservar.setVisibility(View.VISIBLE);
                buscar.setVisibility(View.GONE);
            }
        });
        reservar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AplicacionDB aplication=new AplicacionDB(getContext());
                db=aplication.getWritableDatabase();
                db.execSQL("Update Reserva_aula set estado='true' where hora='"+hora+"' and dia='Lunes'");
                Toast.makeText(getActivity(),"Reserva realizada",Toast.LENGTH_LONG).show();
            }
        });
        /*listDatos=new ArrayList<>();

        for (int i=0;i<=25;i++){
            listDatos.add("Pabellon "+i);
        }

        AdaptadorDatos adapter=new AdaptadorDatos(listDatos);
        recycler.setAdapter(adapter);*/


        pabellon.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Base de datos Seleccion de Aula segun pabellon

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return view;
    }

    private void consultarLista() {
        AplicacionDB aplication=new AplicacionDB(getContext());
        db=aplication.getReadableDatabase();
        Reserva reserva=null;
        String query="Select codigo_pabellon,codigo_aula,hora from Reserva_aula where dia='Lunes'";
        Cursor cursor=db.rawQuery(query,null);
        while (cursor.moveToNext()){
            reserva=new Reserva();
            reserva.setCod_pabellon(cursor.getString(0));
            reserva.setCod_aula(cursor.getString(1));
            reserva.setHora(cursor.getString(2));
            listReserva.add(reserva);
        }
    }



    private void Castear(){
        pabellon=view.findViewById(R.id.spn_pabellon);
        aula=view.findViewById(R.id.spn_aula);
        recycler=view.findViewById(R.id.reciclerId);
        buscar=view.findViewById(R.id.btn_busca_aulas);
        reservar=view.findViewById(R.id.btn_reservar);
    }

}
