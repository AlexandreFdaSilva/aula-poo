package br.example.jonat.a04_calculadora_area;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class rectangle01 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangle01);
    }

    public void onClickCalculateR(View v){
        EditText etWidth = findViewById(R.id.etEnterTheWidth);
        EditText etHeight = findViewById(R.id.etEnterTheHeight);

        int cond = 1;
        if(etWidth.getText().toString().compareTo("") == 0){
            etWidth.setError(getString(R.string.insert_a_number));
            cond = 0;
        }
        if(etHeight.getText().toString().compareTo("") == 0){
            etHeight.setError(getString(R.string.insert_a_number));
            cond = 0;
        }
        if(cond == 0)
            return;

        double width=0;
        double height=0;
        try {
            width = Double.parseDouble(etWidth.getText().toString());
            height = Double.parseDouble(etHeight.getText().toString());
        }catch(Exception e){
            Toast errorMessage = Toast.makeText(this, R.string.error_message, Toast.LENGTH_LONG);
            errorMessage.show();
            return;
        }

        Intent openRectangle02Screen = new Intent(this.getApplicationContext(), rectangle02.class);

        openRectangle02Screen.putExtra("width", width);
        openRectangle02Screen.putExtra("height", height);

        this.startActivity(openRectangle02Screen);
    }
}
