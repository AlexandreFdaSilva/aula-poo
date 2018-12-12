package br.example.jonat.a05_controle_abastecimento;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MostrarAbastecimento extends AppCompatActivity {

    private TextView sPosto;
    private TextView etKmAtual;
    private TextView etLitrosAbastecidos;
    private TextView etData;
    private TextView etLatitude;
    private TextView etLongitude;
    private Abastecimento abastecimento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_abastecimento);

        etKmAtual = findViewById(R.id.etKmAtual);
        etLitrosAbastecidos = findViewById(R.id.etLitrosAbastecidos);
        etData = findViewById(R.id.etData);
        sPosto = findViewById(R.id.sPosto);
        etLatitude = findViewById(R.id.etLatitude);
        etLongitude = findViewById(R.id.etLongitude);

        this.abastecimento = (Abastecimento) getIntent().getSerializableExtra("abastecimento");

        if(this.abastecimento != null){
            this.etKmAtual.setText(String.valueOf(this.abastecimento.getKilometros()));
            this.etLitrosAbastecidos.setText(String.valueOf(this.abastecimento.getLitros()));
            this.etData.setText(this.abastecimento.getData());
            this.sPosto.setText(this.abastecimento.getPosto());
            this.etLatitude.setText(String.valueOf(this.abastecimento.getLatitude()));
            this.etLongitude.setText(String.valueOf(this.abastecimento.getLongitude()));
        }else{
            this.etKmAtual.setText("nao encontrado");
            this.etLitrosAbastecidos.setText("nao encontrado");
            this.etData.setText("nao encontrado");
            this.sPosto.setText("nao encontrado");
            this.etLatitude.setText("nao encontrado");
            this.etLongitude.setText("nao encontrado");
        }
    }


    public void backBtn(View view) {
        Intent intent =  new Intent(this.getApplicationContext(), lista.class);
        startActivity(intent);
    }
}
