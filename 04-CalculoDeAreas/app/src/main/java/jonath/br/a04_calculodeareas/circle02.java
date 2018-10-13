package jonath.br.a04_calculodeareas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class circle02 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle02);

        double radius = this.getIntent().getDoubleExtra("radius", -1);
        double area = Math.PI * (radius*radius);

        TextView tvShowRadius = (TextView) findViewById(R.id.tvShowRadius);
        tvShowRadius.setText(Double.toString(radius));

        TextView tvAreaResult = (TextView) findViewById(R.id.tvAreaResult);
        NumberFormat nf = DecimalFormat.getInstance();
        nf.setMaximumFractionDigits(2);
        tvAreaResult.setText(nf.format(area));
    }

    public void onClickBack(View v){
        Intent openMainScreen = new Intent(this.getApplicationContext(), MainActivity.class);
        this.startActivity(openMainScreen);
    }
}
