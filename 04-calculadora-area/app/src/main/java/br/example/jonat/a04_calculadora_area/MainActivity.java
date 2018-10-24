package br.example.jonat.a04_calculadora_area;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickCircle(View v){
        Intent openCicleScreen = new Intent(this.getApplicationContext(), circle01.class);
        this.startActivity(openCicleScreen);
    }

    public void onClickRectangle(View v){
        Intent openRectangleScreen = new Intent(this.getApplicationContext(), rectangle01.class);
        this.startActivity(openRectangleScreen);

    }

    public void onClickTriangle(View v){
        Intent openTriangleScreen = new Intent(this.getApplicationContext(), triangle01.class);
        this.startActivity(openTriangleScreen);

    }
}
