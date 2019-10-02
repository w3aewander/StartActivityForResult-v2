package br.com.wander.startactivityforresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ResultadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        setTitle(getIntent().getStringExtra("operacao"));
    }

    public void calcular(View v){

        Intent i = getIntent();
        String operacao = i.getStringExtra("operacao");

        Button btnCalcular = findViewById(R.id.btnCalcular);

        EditText edtNum1 = (EditText) findViewById(R.id.edtNum1);
        EditText edtNum2 = (EditText) findViewById(R.id.edtNum2);

        double num1 = Double.parseDouble( edtNum1.getText().toString() );
        double num2 = Double.parseDouble( edtNum2.getText().toString() );
        double resultado = 0;

        switch (operacao){

            case "somar":
                resultado = num1 + num2;
                break;

            case "subtrair":
                resultado = num1 - num2;
                break;

            case "multiplicar":
                resultado = num1 * num2;
                break;

            case "dividir":
                if ( num1 == 0 || num2 == 0 ){
                    Toast.makeText(this,
                            "Operando e operador não pode ser ZERO",
                            Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    resultado = num1 / num2;
                }
                break;

            default :
                resultado = 0;
        }

        Intent r = new Intent();
        //Envia o valor da variável resultado para a activity que a chamou
        r.putExtra("resultado",resultado);

        setResult(RESULT_OK,r);

        finish();



    }
}
