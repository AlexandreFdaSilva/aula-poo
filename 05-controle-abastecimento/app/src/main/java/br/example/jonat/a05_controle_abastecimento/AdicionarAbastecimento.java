package br.example.jonat.a05_controle_abastecimento;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class AdicionarAbastecimento extends AppCompatActivity {

    private String postos[] = new String[]{"Ipiranga", "Petrobras", "Shell", "Taxaco"};
    private Spinner sPosto;
    private EditText etKmAtual;
    private EditText etLitrosAbastecidos;
    private EditText etData;
    private double kmAntigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_abastecimento);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, postos);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        this.kmAntigo = this.getIntent().getDoubleExtra("kmAntigo", -1);

        sPosto = (Spinner) findViewById(R.id.sPosto);
        sPosto.setAdapter(adapter);

        etKmAtual = findViewById(R.id.etKmAtual);
        etLitrosAbastecidos = findViewById(R.id.etLitrosAbastecidos);
        etData = findViewById(R.id.etData);
    }

    public void salvarContato(View view) {
        Abastecimento abastecimento = new Abastecimento();

        if(etKmAtual.getText().toString().equals("")){
            this.etKmAtual.setError(getString(R.string.campo_preenchido));
            return;
        }
        if(etLitrosAbastecidos.getText().toString().equals("")){
            this.etLitrosAbastecidos.setError(getString(R.string.campo_preenchido));
            return;
        }
        if(etData.getText().toString().equals("")){
            this.etData.setError(getString(R.string.campo_preenchido));
            return;
        }
        if(Double.parseDouble(etKmAtual.getText().toString()) <= this.kmAntigo){
            this.etKmAtual.setError(getString(R.string.km_maior));
            return;
        }

        abastecimento.setKilometros(Double.parseDouble(etKmAtual.getText().toString()));
        abastecimento.setLitros(Double.parseDouble(etLitrosAbastecidos.getText().toString()));
        abastecimento.setData(etData.getText().toString());
        abastecimento.setPosto(sPosto.getSelectedItem().toString());

        boolean salvo = ListaDAO.salvar(this.getApplicationContext(), abastecimento);

        if(salvo){
            setResult(1);
            finish();
        }else{
            Toast.makeText(this.getApplicationContext(), "Erro ao salvar", Toast.LENGTH_SHORT).show();
        }
    }
}
