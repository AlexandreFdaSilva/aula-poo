package br.example.jonat.a05_controle_abastecimento;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

public class lista extends AppCompatActivity {
    private final int ADICIONAR_ABASTECIMENTO = 1312;
    private listaAdapter adapater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        RecyclerView rvListaAbastecimento = findViewById(R.id.rvLista);

        this.adapater = new listaAdapter();
        this.adapater.lista = ListaDAO.getLista(this.getApplicationContext());

        rvListaAbastecimento.setAdapter(this.adapater);
        rvListaAbastecimento.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));
    }

    public void onClickFAB(View view) {
        Intent intent =  new Intent(this.getApplicationContext(), AdicionarAbastecimento.class);
        startActivityForResult(intent, ADICIONAR_ABASTECIMENTO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == ADICIONAR_ABASTECIMENTO){
            if(resultCode == 1){
                //Toast.makeText(this.getApplicationContext(), "AÇÃO 1!!!!!", Toast.LENGTH_LONG).show();
                this.adapater.notifyDataSetChanged();
            }else{
                Toast.makeText(this.getApplicationContext(), "nao sei de onde veio", Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(this.getApplicationContext(), "deu ruim", Toast.LENGTH_SHORT).show();
        }
    }
}
