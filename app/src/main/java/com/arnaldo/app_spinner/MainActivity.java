package com.arnaldo.app_spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et_valor1;
    private EditText et_valor2;
    private Spinner spinner;
    private TextView tv_resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_valor1 = (EditText) findViewById(R.id.et_valor1);
        et_valor2 = (EditText) findViewById(R.id.et_valor2);
        spinner = (Spinner) findViewById(R.id.spinner);
        tv_resultado = (TextView) findViewById(R.id.tv_resultado);


        String[] opciones = {"sumar", "restar", "multiplicar", "dividir"}; //Arreglo unidimensional
        //El ArrayAdapter sirve para comunicar el arreglo con el spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item_formato, opciones); //Se pone el formato personalizado que creamos
        spinner.setAdapter(adapter); //Se pone el adapter creado al spinner
    }

    //Metodo del boton calcular
    public void Calcular(View v) {
        int et_valor1_int = Integer.parseInt(et_valor1.getText().toString());
        int et_valor2_int = Integer.parseInt(et_valor2.getText().toString());

        String seleccionado = spinner.getSelectedItem().toString();

        switch (seleccionado) {
            case ("sumar"):
                int sumar = et_valor1_int + et_valor2_int;
                tv_resultado.setText(sumar + "");
                break;
            case ("restar"):
                int restar = et_valor1_int - et_valor2_int;
                tv_resultado.setText(restar + "");
                break;
            case ("multiplicar"):
                int multiplicar = et_valor1_int * et_valor2_int;
                tv_resultado.setText(multiplicar + "");
                break;
            case ("dividir"):
                if (et_valor2_int == 0) {
                    Toast.makeText(this, "El segundo valor no puede ser cero", Toast.LENGTH_LONG).show();
                } else {
                    int dividir = et_valor1_int / et_valor2_int;
                    tv_resultado.setText(dividir + "");
                }
                break;
        }
    }
}
