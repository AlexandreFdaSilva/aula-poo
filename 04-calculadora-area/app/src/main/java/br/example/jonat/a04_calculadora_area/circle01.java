package br.example.jonat.a04_calculadora_area;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class circle01 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle01);
    }

    public void onClickCalculateC(View v){
        EditText etRadius = findViewById(R.id.etCircleRadius);

        if(etRadius.getText().toString().compareTo("") == 0){
            etRadius.setError(getString(R.string.insert_a_number));
            return;
        }

        double radius=0;
        try {
            radius = Double.parseDouble(etRadius.getText().toString());
        }catch(Exception e){
            Toast errorMessage = Toast.makeText(this, R.string.error_message, Toast.LENGTH_LONG);
            errorMessage.show();
            return;
        }

        Intent openCircle02Screen = new Intent(this.getApplicationContext(), circle02.class);

        openCircle02Screen.putExtra("radius", radius);

        this.startActivity(openCircle02Screen);
    }
}
