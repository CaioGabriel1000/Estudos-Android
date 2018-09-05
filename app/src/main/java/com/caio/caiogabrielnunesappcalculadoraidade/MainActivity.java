package com.caio.caiogabrielnunesappcalculadoraidade;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.text.ParsePosition;

public class MainActivity extends AppCompatActivity {

    private Button btnOk;
    private EditText edtText;
    protected ImageView imageView;
    protected int[] img = {R.drawable.aguardando,R.drawable.crianca, R.drawable.adolescente, R.drawable.adulto, R.drawable.idoso};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOk = (Button) findViewById(R.id.button);
        edtText = (EditText) findViewById(R.id.editText);
        imageView = (ImageView) findViewById(R.id.imageView);


        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texto = edtText.getText().toString();
                int i = mudarImagem(texto);
                texto = testarIdade(texto);
                imageView.setImageResource(img[i]);-
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

    public int mudarImagem(String idade) {
        if(isNumeric(idade)) {
            int i;
            try {
                i = Integer.parseInt(idade);
            } catch (Exception e) {
                return 0;
            }
            if (i >= 0 && i <= 12) {
                return 1;
            } else if (i > 12 && i < 18) {
                return 2;
            } else if (i >= 18 && i < 60) {
                return 3;
            } else if (i >= 60) {
                return 4;
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }

    public static boolean isNumeric(String str) {
        NumberFormat formatter = NumberFormat.getInstance();
        ParsePosition pos = new ParsePosition(0);
        formatter.parse(str, pos);
        return str.length() == pos.getIndex();
    }
}
