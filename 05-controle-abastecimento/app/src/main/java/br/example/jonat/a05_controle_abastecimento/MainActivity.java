package br.example.jonat.a05_controle_abastecimento;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private boolean permissao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentManager fm = MainActivity.this.getSupportFragmentManager();
        for(int i = 0; i < fm.getBackStackEntryCount(); ++i) {
            fm.popBackStack();
        }

        setContentView(R.layout.activity_main);

        //verifica se ja tem permissao de gps
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            //pede permissao ao usuario
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        }else{
            permissao = true;
        }

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

    @Override//verifica se o usuario deu acesso ou nao ao utilizar o gps
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    permissao = true;
                } else {
                    Toast.makeText(this, "Não vai funcionar!!!", Toast.LENGTH_LONG).show();
                }
                return;
            }
        }
    }

    public void next(View view) {
        Intent intent = new Intent(this.getApplicationContext(), lista.class);
        intent.putExtra("permissao", permissao);
        startActivity(intent);
    }
}
