package ucsm.reservas_clientes;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;


public class contactenos extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view=inflater.inflate(R.layout.fragment_contactenos, container, false);
        final EditText mens=(EditText)view.findViewById(R.id.txt_mensaje);
        Button button=(Button)view.findViewById(R.id.btn_llamar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent llamada=new Intent(Intent.ACTION_DIAL);
                llamada.setData(Uri.parse("tel:983 342 810"));
                startActivity(llamada);
            }
        });
        Button enviar=(Button)view.findViewById(R.id.btn_enviar);
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String body=mens.getText().toString();
                Uri uri = Uri.parse("smsto:983342810");
                Intent it = new Intent(Intent.ACTION_SENDTO, uri);
                it.putExtra("sms_body", body);
                startActivity(it);
                /*SmsManager sms=SmsManager.getDefault();
                sms.sendTextMessage(num,null,mensaje,null,null);*/
                Toast.makeText(view.getContext(),"Mensaje enviado",Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }


}
