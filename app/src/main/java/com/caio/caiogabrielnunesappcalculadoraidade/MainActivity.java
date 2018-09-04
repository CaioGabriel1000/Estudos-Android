package com.caio.caiogabrielnunesappcalculadoraidade;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.NumberFormat;
import java.text.ParsePosition;

public class MainActivity extends AppCompatActivity {

    private Button btnOk;
    private EditText edtText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOk = (Button) findViewById(R.id.button);
        edtText = (EditText) findViewById(R.id.editText);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texto = edtText.getText().toString();
                texto = testarIdade(texto);
                Toast.makeText(getApplicationContext(),
                        texto, Toast.LENGTH_LONG).show();
            }
        });

    }

    public String testarIdade(String idade) {
        if(isNumeric(idade)) {
            int i;
            try {
                i = Integer.parseInt(idade);
            } catch (Exception e) {
                return "Tente novamente outra idade!";
            }
            if (i >= 0 && i <= 12) {
                return "Criança!";
            } else if (i > 12 && i < 18) {
                return "Adolescente!";
            } else if (i >= 18 && i < 60) {
                return "Adulto!";
            } else if (i >= 60) {
                return "Idoso!";
            } else {
                return "Idade inválida!";
            }
        } else {
            return "Idade inválida!";
        }
    }

    public static boolean isNumeric(String str) {
        NumberFormat formatter = NumberFormat.getInstance();
        ParsePosition pos = new ParsePosition(0);
        formatter.parse(str, pos);
        return str.length() == pos.getIndex();
    }
}
