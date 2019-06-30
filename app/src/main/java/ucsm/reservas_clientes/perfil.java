package ucsm.reservas_clientes;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ucsm.reservas_clientes.Entidades.AplicacionDB;


public class perfil extends Fragment {
    SQLiteDatabase db;
    TextView perfil,correo,telefono,cod;
    View view;
    String codigo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_perfil, container, false);
        Castear();
        LlenaDatos();
        /*SharedPreferences sharedPreferences=getActivity().getSharedPreferences("MainActivity",Context.MODE_PRIVATE);
        codigo=sharedPreferences.getString("usuario","no hay usuario");
        AplicacionDB application=new AplicacionDB(getActivity());
        db=application.getReadableDatabase();
        Cursor c=db.rawQuery("Select nombre from Alumnos where codigo='"+codigo+"'",null);
        while (c.moveToNext()){
            perfil.setText(c.getString(0));
        }*/
        db.close();
        return view;
    }

    private void Castear(){
        perfil=view.findViewById(R.id.txt_nombre);
        cod=view.findViewById(R.id.txt_codigo);
        correo=view.findViewById(R.id.txt_correo);
        telefono=view.findViewById(R.id.txt_telefono);
    }

    private void LlenaDatos(){
        SharedPreferences sharedPreferences=getActivity().getSharedPreferences("MainActivity",Context.MODE_PRIVATE);
        codigo=sharedPreferences.getString("usuario","no hay usuario");
        AplicacionDB application=new AplicacionDB(getActivity());
        db=application.getReadableDatabase();
        Cursor c=db.rawQuery("Select nombre,codigo,telefono,correo from Alumnos where codigo='"+codigo+"'",null);
        while (c.moveToNext()){
            if(c.isFirst()){
                c.moveToFirst();
                perfil.setText(c.getString(0));
                cod.setText(c.getString(1));
                telefono.setText(c.getString(2));
                correo.setText(c.getString(3));
                c.close();
            }
        }
    }

}
