package cadastrospinner.caiogabrielnunes.cadastrocomspinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    protected EditText nome;
    protected Spinner sexo;
    protected Button btnCadastrar;
    protected ImageView ivSexo;
    protected int[] img = {R.drawable.homem,R.drawable.mulher};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome = (EditText) findViewById(R.id.etNome);
        sexo = (Spinner) findViewById(R.id.sSexo);
        btnCadastrar = (Button) findViewById(R.id.bCadastrar);
        ivSexo = (ImageView) findViewById(R.id.ivSexo);



        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sexo.getSelectedItemPosition() == 0) {
                    ivSexo.setImageResource(img[0]);
                    Toast.makeText(getApplicationContext(),"Senhor " + nome.getText().toString(),Toast.LENGTH_LONG).show();
                } else {
                    ivSexo.setImageResource(img[1]);
                    Toast.makeText(getApplicationContext(),"Senhora " + nome.getText().toString(),Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}
