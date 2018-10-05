package jonath.aula.br.a03_calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void solveEquation(View button){
        EditText Enum_x2 = (EditText) findViewById(R.id.et_numX2);
        EditText Enum_x = (EditText) findViewById(R.id.et_numX);
        EditText Enum = (EditText) findViewById(R.id.et_num);

        String Snum_x2 = Enum_x2.getText().toString();
        String Snum_x = Enum_x.getText().toString();
        String Snum = Enum.getText().toString();

        int cond=0;
        if(Snum_x2.equals("")){
            Enum_x2.setError(getString(R.string.errorMessage3));
            cond=1;
        }
        if(Snum_x.equals("")){
            Enum_x.setError(getString(R.string.errorMessage3));
            cond=1;
        }
        if(Snum.equals("")){
            Enum.setError(getString(R.string.errorMessage3));
            cond=1;
        }
        if(cond==1)
            return;

        double num_x2;
        double num_x;
        double num;

        try{
            num_x2 = Double.parseDouble(Snum_x2);
            num_x = Double.parseDouble(Snum_x);
            num = Double.parseDouble(Snum);
        }catch (Exception e){
            String error = getString(R.string.errorMessage2);
            Toast mensagemErro = Toast.makeText(this, error, Toast.LENGTH_LONG);
            mensagemErro.show();
            return;
        }

        if(num_x2==0){
            double x1;
            x1 = (-1*num) / num_x;

            TextView x = (TextView) findViewById(R.id.tv_x);

            x.setVisibility(View.VISIBLE);

            x1 = Double.parseDouble(new DecimalFormat("##.##").format(x1));
            x.setText("x = " + Double.toString(x1));
        }else{
            double delta = (num_x*num_x) - (4*num_x2*num);

            if(delta>=0){
                double x1 = (-(num_x) + Math.sqrt(delta))/(2 * num_x2);
                double x2 = (-(num_x) - Math.sqrt(delta))/(2 * num_x2);

                if(x1 == x2){
                    TextView x = (TextView) findViewById(R.id.tv_x);

                    x.setVisibility(View.VISIBLE);

                    x1 = Double.parseDouble(new DecimalFormat("##.##").format(x1));
                    x.setText("x' = x'' = " + Double.toString(x1));
                }else{
                    TextView x_1 = (TextView) findViewById(R.id.tv_x_1);
                    TextView x_2 = (TextView) findViewById(R.id.tv_x_2);

                    x_1.setVisibility(View.VISIBLE);
                    x_2.setVisibility(View.VISIBLE);

                    x1 = Double.parseDouble(new DecimalFormat("##.##").format(x1));
                    x2 = Double.parseDouble(new DecimalFormat("##.##").format(x2));
                    x_1.setText("x' = " +  Double.toString(x1));
                    x_2.setText("x'' = " +  Double.toString(x2));
                }
            }else{
                TextView x = (TextView) findViewById(R.id.tv_x);
                String errorText = getString(R.string.errorMessage);
                x.setText(errorText);
                x.setVisibility(View.VISIBLE);
            }
        }

        Button reset = (Button) findViewById(R.id.buttonReset);
        reset.setVisibility(View.VISIBLE);

        button.setVisibility(View.INVISIBLE);
    }

    public void resetEquation(View button){
        EditText Enum_x2 = (EditText) findViewById(R.id.et_numX2);
        EditText Enum_x = (EditText) findViewById(R.id.et_numX);
        EditText Enum = (EditText) findViewById(R.id.et_num);

        Enum_x2.setText("");
        Enum_x.setText("");
        Enum.setText("");

        TextView x = (TextView) findViewById(R.id.tv_x);
        TextView x_1 = (TextView) findViewById(R.id.tv_x_1);
        TextView x_2 = (TextView) findViewById(R.id.tv_x_2);

        x_1.setVisibility(View.INVISIBLE);
        x_2.setVisibility(View.INVISIBLE);
        x.setVisibility(View.INVISIBLE);

        Button solve = (Button) findViewById(R.id.buttonSolve);
        solve.setVisibility(View.VISIBLE);

        button.setVisibility(View.INVISIBLE);
    }
}
