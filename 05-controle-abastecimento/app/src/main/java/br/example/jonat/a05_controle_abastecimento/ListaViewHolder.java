package br.example.jonat.a05_controle_abastecimento;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ListaViewHolder extends RecyclerView.ViewHolder {
    private ImageView ivPosto;
    private TextView tvDate;
    private TextView tvKilometers;
    private TextView tvLiters;


    public ListaViewHolder(@NonNull View itemView) {
        super(itemView);
        this.ivPosto = itemView.findViewById(R.id.ivPosto);
        this.tvDate = itemView.findViewById(R.id.tvDate);
        this.tvKilometers = itemView.findViewById(R.id.tvKilometers);
        this.tvLiters = itemView.findViewById(R.id.tvLiters);
    }

    public void atualizaGaveta(Abastecimento objeto){
        String kilometros = "Km: " + String.valueOf(objeto.getKilometros());
        String litros = String.valueOf(objeto.getLitros()) + " L";
        String posto = objeto.getPosto();

        this.tvDate.setText(objeto.getData());
        this.tvKilometers.setText(kilometros);
        this.tvLiters.setText(litros);

        if(posto.equals("Ipiranga")){
            ivPosto.setImageDrawable(ContextCompat.getDrawable(App.getContext(), R.drawable.ipiranga));
        }else if(posto.equals("Petrobras")){
            ivPosto.setImageDrawable(ContextCompat.getDrawable(App.getContext(), R.drawable.petrobras));
        }else if(posto.equals("Shell")){
            ivPosto.setImageDrawable(ContextCompat.getDrawable(App.getContext(), R.drawable.shell));
        }else{
            ivPosto.setImageDrawable(ContextCompat.getDrawable(App.getContext(), R.drawable.texaco));
        }
    }
}
