package ucsm.reservas_clientes;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import ucsm.reservas_clientes.Entidades.Reserva;

public class AdaptadorHorarios extends RecyclerView.Adapter<AdaptadorHorarios.ViewHolderDatos> {
    ArrayList<Reserva> listReserva;
    public AdaptadorHorarios(ArrayList<Reserva> listReserva) {

        this.listReserva = listReserva;
    }
    @Override
    public ViewHolderDatos onCreateViewHolder(ViewGroup viewGroup, int i) {
        return null;
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

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView dato,dato2,dato3;

        public ViewHolderDatos(View itemView) {
            super(itemView);
            dato=itemView.findViewById(R.id.dato_pabellon);
            dato2=itemView.findViewById(R.id.aula);
            dato3=itemView.findViewById(R.id.hora);
        }
    }
}
