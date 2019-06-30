package ucsm.reservas_clientes;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import ucsm.reservas_clientes.Entidades.Reserva;

public class AdaptadorDatos extends RecyclerView.Adapter<AdaptadorDatos.ViewHolderDatos> implements View.OnClickListener {
    ArrayList<Reserva> listReserva;
    private View.OnClickListener listener;
    public AdaptadorDatos(ArrayList<Reserva> listReserva) {

        this.listReserva = listReserva;
    }

    @Override
    public ViewHolderDatos onCreateViewHolder(ViewGroup parent, int i) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,null,false);
        view.setOnClickListener(this);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderDatos holder, int position) {
        holder.dato.setText(listReserva.get(position).getCod_pabellon());
        holder.dato2.setText(listReserva.get(position).getCod_aula());
        holder.dato3.setText(listReserva.get(position).getHora());
    }

    @Override
    public int getItemCount() {

        return listReserva.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }

    @Override
    public void onClick(View view) {
        if(listener!=null){
            listener.onClick(view);
        }
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView dato,dato2,dato3;

        public ViewHolderDatos(View itemView) {
            super(itemView);
            dato=itemView.findViewById(R.id.datos);
            dato2=itemView.findViewById(R.id.datos2);
            dato3=itemView.findViewById(R.id.datos3);
        }

    }
}
