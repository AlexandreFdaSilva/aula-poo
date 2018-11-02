package br.example.jonat.a05_controle_abastecimento;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Abastecimento> abastecimentos =  new ArrayList<Abastecimento>();

        abastecimentos = ListaDAO.getLista(this.getApplicationContext());

        if(abastecimentos.size()>1){
            double autonomia;
            double kmPercorridos;
            double litros = 0;

            kmPercorridos = abastecimentos.get(abastecimentos.size()-1).getKilometros() - abastecimentos.get(0).getKilometros();
            for (int i = 0; i < abastecimentos.size()-1; i++) {
                litros += abastecimentos.get(i).getLitros();
            }

            autonomia = kmPercorridos/litros;

            TextView tvResult = findViewById(R.id.tvResult);

            tvResult.setText(String.valueOf(autonomia));
        }
    }

    public void next(View view) {
        Intent intent = new Intent(this.getApplicationContext(), lista.class);
        startActivity(intent);
    }
}
