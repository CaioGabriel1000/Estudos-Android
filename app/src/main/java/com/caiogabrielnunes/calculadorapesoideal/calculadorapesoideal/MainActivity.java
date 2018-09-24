package com.caiogabrielnunes.calculadorapesoideal.calculadorapesoideal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    protected RadioButton rbHomem;
    protected RadioButton rbMulher;
    protected EditText etAltura;
    protected Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rbHomem = (RadioButton) findViewById(R.id.rbHomem);
        rbMulher = (RadioButton) findViewById(R.id.rbMulher);
        btnOk = (Button) findViewById(R.id.btnOk);
        etAltura = (EditText) findViewById(R.id.etAltura);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float f;
                int k;
                if (rbHomem.isChecked()) {
                    k = 4;
                    try {
                        f = Float.parseFloat(etAltura.getText().toString());
                        f = calcularPesoIdeal(k,f);
                        Toast.makeText(getBaseContext(), "Peso ideal = " + Float.toString(f),
                                Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        Toast.makeText(getBaseContext(), "Você é um homem, mas sua altura é inválida, tente novamente!",
                                Toast.LENGTH_LONG).show();
                    }
                } else if (rbMulher.isChecked()) {
                    k = 2;
                    try {
                        f = Float.parseFloat(etAltura.getText().toString());
                        f = calcularPesoIdeal(k,f);
                        Toast.makeText(getBaseContext(), "Peso ideal = " + Float.toString(f),
                                Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        Toast.makeText(getBaseContext(), "Você é mulher, mas sua altura é inválida, tente novamente!",
                                Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getBaseContext(), "Nenhum valor selecionado, tente novamente!",
                            Toast.LENGTH_LONG).show();
                }

            }
        });


    }
    public float calcularPesoIdeal(int k, float altura) {
        float resultado = altura - 100;
        resultado = ((altura - 150) / k) - resultado;
        return resultado;
    }
}
