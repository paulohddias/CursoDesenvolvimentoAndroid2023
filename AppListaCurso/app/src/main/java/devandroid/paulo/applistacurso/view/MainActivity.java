package devandroid.paulo.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import devandroid.paulo.applistacurso.R;
import devandroid.paulo.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    Pessoa pessoa;
    EditText editPrimeiroNome, editSobrenome, editNomeCurso, editTelefoneContato;
    Button btnLimpar, btnSalvar, btnFinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pessoa = new Pessoa();
        pessoa.setPrimeiroNome("Paulo");
        pessoa.setSobreNome("Dias");
        pessoa.setCursoDesejado("Android");
        pessoa.setTelefoneContato("12-99757353");

        editPrimeiroNome = findViewById(R.id.editPrimeiroNome);
        editSobrenome = findViewById(R.id.editSobrenome);
        editNomeCurso = findViewById(R.id.editNomeCurso);
        editTelefoneContato = findViewById(R.id.editTelefoneContato);

        btnFinalizar = findViewById(R.id.btnFinalizar);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);

        editPrimeiroNome.setText(pessoa.getPrimeiroNome());
        editSobrenome.setText(pessoa.getSobreNome());
        editNomeCurso.setText(pessoa.getCursoDesejado());
        editTelefoneContato.setText(pessoa.getTelefoneContato());

        Log.i("POOAndroid", pessoa.toString());
    }
}