package jonath.aula.br.a03_calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

        if(Snum_x2.equals("")){
            Enum_x2.setError("Inform a number");
            return;
        }else if(Snum_x.equals("")){
            Enum_x.setError("Inform a number");
            return;
        }else if(Snum.equals("")){
            Enum.setError("Inform a number");
            return;
        }

        Double num_x2;
        Double num_x;
        Double num;

        try{
            num_x2 = Double.parseDouble(Snum_x2);
            num_x = Double.parseDouble(Snum_x);
            num = Double.parseDouble(Snum);
        }catch (Exception e){
            Toast mensagemErro = Toast.makeText(this, "Something wrong happened", Toast.LENGTH_LONG);
            mensagemErro.show();
            return;
        }

        Double delta = (num_x*num_x) - (4*num_x2*num);

        if(delta>=0){
            Double x1 = (-(num_x) + Math.sqrt(delta))/(2 * num_x2);
            Double x2 = (-(num_x) - Math.sqrt(delta))/(2 * num_x2);

            //Toast.makeText(this.getApplicationContext(), "x' = " + x1.toString(), Toast.LENGTH_LONG).show();
            //Toast.makeText(this.getApplicationContext(), "x' = " + x2.toString(), Toast.LENGTH_LONG).show();

            if(x1 == x2) {
                EditText x = (EditText) findViewById(R.id.tv_x);

                x.setVisibility(View.VISIBLE);

                x.setText("x' = x'' = " + x1.toString());
            }else{
                EditText x_1 = (EditText) findViewById(R.id.tv_x_1);
                EditText x_2 = (EditText) findViewById(R.id.tv_x_2);

                x_1.setVisibility(View.VISIBLE);
                x_2.setVisibility(View.VISIBLE);

                x_1.setText("x' = " + x1.toString());
                x_2.setText("x'' = " + x2.toString());
            }
        }else{
            EditText x = (EditText) findViewById(R.id.tv_x);

            x.setVisibility(View.VISIBLE);
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

        EditText x = (EditText) findViewById(R.id.tv_x);
        EditText x_1 = (EditText) findViewById(R.id.tv_x_1);
        EditText x_2 = (EditText) findViewById(R.id.tv_x_2);

        x_1.setVisibility(View.INVISIBLE);
        x_2.setVisibility(View.INVISIBLE);
        x.setVisibility(View.INVISIBLE);

        Button solve = (Button) findViewById(R.id.buttonSolve);
        solve.setVisibility(View.VISIBLE);

        button.setVisibility(View.INVISIBLE);
    }
}
