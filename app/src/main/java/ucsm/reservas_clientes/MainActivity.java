package ucsm.reservas_clientes;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.ads.MobileAds;

import ucsm.reservas_clientes.Entidades.AplicacionDB;

public class MainActivity extends AppCompatActivity {
    private LinearLayout fondo;
    private SQLiteDatabase db;
    private EditText user,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user = (EditText) findViewById(R.id.txt_user);
        pass=(EditText)findViewById(R.id.txt_passw);
        AplicacionDB application=new AplicacionDB(this);
        db=application.getWritableDatabase();

        String query="SELECT codigo,dni FROM Alumnos WHERE codigo='"+user.getText().toString()+"' and dni='"+pass.getText().toString()+"'";
        Cursor c=db.rawQuery(query,null);
        while (c.moveToNext()){
            if(c.isFirst()){
                c.moveToFirst();
                String dd=c.getString(1);
                String cc=c.getString(0);
            }
        }
        SharedPreferences sp=getSharedPreferences("Preferencias",Context.MODE_PRIVATE);
    }

    public void Logearse(View view){
        String tempass="";
        String tempuser="";
        String usuario=user.getText().toString();
        String contrasena=pass.getText().toString();
        if(usuario.length()==0 || contrasena.length()==0){
            Snackbar.make(view,"Complete los campos",Snackbar.LENGTH_LONG).show();
            //Toast.makeText(this,"Complete los campos",Toast.LENGTH_SHORT).show();
        }
        else {
            String query="SELECT codigo,dni FROM Alumnos WHERE codigo='"+user.getText().toString()+"' and dni='"+pass.getText().toString()+"'";
            Cursor c=db.rawQuery(query,null);
            while (c.moveToNext()){
                if(c.isFirst()){
                    c.moveToFirst();
                    tempass=c.getString(1);
                    tempuser=c.getString(0);
                    c.close();
                }
            }
            if(tempass.equals(contrasena) || tempuser.equals(contrasena)) {
                saveLoginSharedPreferences(usuario,contrasena);
                Intent act2=new Intent(getApplicationContext(),MenuLateral.class);
                startActivity(act2);
            }
            else {
                Toast.makeText(this,"El usuario no existe",Toast.LENGTH_LONG).show();
            }
        }
    }

    public void saveLoginSharedPreferences(String usuario, String contrasena){//Guarda las preferencias compartidas
        SharedPreferences sp=getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        editor.putString("usuario",usuario);
        editor.putString("contrasena",contrasena);
        editor.apply();
    }

    /*public static String leerPreferencias(Context context, String Pref){
        SharedPreferences preferences = context.getSharedPreferences(PREFS_KEY, MODE_PRIVATE);
        return  preferences.getString(keyPref, "");
    }*/

}
