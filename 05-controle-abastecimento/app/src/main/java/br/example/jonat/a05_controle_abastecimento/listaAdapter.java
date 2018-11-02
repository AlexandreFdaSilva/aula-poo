package br.example.jonat.a05_controle_abastecimento;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class listaAdapter extends RecyclerView.Adapter {

    public ArrayList<Abastecimento> lista;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i){
        View elementoPai = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_item_lista, viewGroup, false);
        ListaViewHolder gaveta = new ListaViewHolder(elementoPai);
        return gaveta;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ListaViewHolder gaveta = (ListaViewHolder) viewHolder;
        Abastecimento x = lista.get(i);
        gaveta.atualizaGaveta(x);
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
}
