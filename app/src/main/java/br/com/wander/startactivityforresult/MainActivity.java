package br.com.wander.startactivityforresult;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnSomar;
    private Button btnSubtrair;
    private Button btnMultiplicar;
    private Button btnDividir;

    private TextView txtResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSomar = findViewById(R.id.btnSomar);
        btnSubtrair = findViewById(R.id.btnSubtrair);
        btnMultiplicar = findViewById(R.id.btnMultiplicar);
        btnDividir = findViewById(R.id.btnDividir);
        txtResultado = findViewById(R.id.txtResultado);

    }

    public void somar(View v){

        Intent i = new Intent();
        i.setClass(MainActivity.this,ResultadoActivity.class);
        i.putExtra("operacao",AppConstants.OPERACAO_SOMAR);
        startActivityForResult(i,AppConstants.REQUEST_RESULTADO);

    }

    public void subtrair(View v){

        Intent i = new Intent();
        i.setClass(MainActivity.this,ResultadoActivity.class);
        i.putExtra("operacao",AppConstants.OPERACAO_SUBTRAIR);
        startActivityForResult(i,AppConstants.REQUEST_RESULTADO);
    }
    public void multiplicar(View v){

        Intent i = new Intent();
        i.setClass(MainActivity.this,ResultadoActivity.class);
        i.putExtra("operacao",AppConstants.OPERACAO_MULTIPLICAR);
        startActivityForResult(i,AppConstants.REQUEST_RESULTADO);
    }
    public void dividir(View v){

        Intent i = new Intent();
        i.setClass(MainActivity.this,ResultadoActivity.class);
        i.putExtra("operacao",AppConstants.OPERACAO_DIVIDIR);
        startActivityForResult(i,AppConstants.REQUEST_RESULTADO);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if ( requestCode == AppConstants.REQUEST_RESULTADO && resultCode == RESULT_OK){
            double result = data.getDoubleExtra("resultado",0);
            txtResultado.setText( String.valueOf( result));
        }
    }
}
