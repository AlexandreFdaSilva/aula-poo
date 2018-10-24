package br.example.jonat.a04_calculadora_area;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class rectangle02 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangle02);

        double width = this.getIntent().getDoubleExtra("width", -1);
        double height = this.getIntent().getDoubleExtra("height", -1);
        double area = width * height;



        TextView tvHeight = (TextView) findViewById(R.id.tvHeight);
        tvHeight.setText(Double.toString(height));
        TextView tvWidth = (TextView) findViewById(R.id.tvWidth);
        tvWidth.setText(Double.toString(width));

        TextView tvAreaResultR = (TextView) findViewById(R.id.tvAreaResultR);
        NumberFormat nf = DecimalFormat.getInstance();
        nf.setMaximumFractionDigits(2);
        tvAreaResultR.setText(nf.format(area) +"cm²");
    }

    public void onClickBack(View v){
        Intent openMainScreen = new Intent(this, MainActivity.class);
        openMainScreen.addFlags(openMainScreen.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(openMainScreen);
    }
}
