package devandroid.paulo.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import devandroid.paulo.applistacurso.R;
import devandroid.paulo.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    Pessoa pessoa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pessoa = new Pessoa();
        pessoa.setPrimeiroNome("Paulo");
        pessoa.setSobreNome("Dias");
        pessoa.setCursoDesejado("Android");
        pessoa.setTelefoneContato("12-99757353");

        Log.i("POOAndroid", pessoa.toString());
    }
}