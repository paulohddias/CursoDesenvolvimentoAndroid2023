package devandroid.paulo.appgaseta.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import devandroid.paulo.appgaseta.R;
import devandroid.paulo.appgaseta.controller.CursoController;
import devandroid.paulo.appgaseta.controller.PessoaController;
import devandroid.paulo.appgaseta.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    PessoaController controller;
    CursoController cursoController;

    Pessoa pessoa;
    List<String> nomesDosCursos;
    EditText editPrimeiroNome, editSobrenome, editNomeCurso, editTelefoneContato;
    Button btnLimpar, btnSalvar, btnFinalizar;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        controller = new PessoaController(MainActivity.this);

        cursoController = new CursoController();
        nomesDosCursos = cursoController.dadosParaSpinner();

        pessoa = new Pessoa();
        controller.buscar(pessoa);

        editPrimeiroNome = findViewById(R.id.editGasolina);
        editSobrenome = findViewById(R.id.editEtanol);
        //editNomeCurso = findViewById(R.id.editNomeCurso);
        editTelefoneContato = findViewById(R.id.editTelefoneContato);

        editPrimeiroNome.setText(pessoa.getPrimeiroNome());
        editSobrenome.setText(pessoa.getSobreNome());
        //editNomeCurso.setText(pessoa.getCursoDesejado());
        editTelefoneContato.setText(pessoa.getTelefoneContato());

        spinner = findViewById(R.id.spinnerCursos);

        btnFinalizar = findViewById(R.id.btnFinalizar);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);

        //Adapter
        //Layout
        //Injetar o Adapter ao Spinner - A lista gerada

        ArrayList<String> listaCurso = new ArrayList<>();
        listaCurso = cursoController.dadosParaSpinner();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                listaCurso);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);

        spinner.setAdapter(adapter);


        for (int i = 0; i < listaCurso.size(); i++) {
            if(listaCurso.get(i).equals(pessoa.getCursoDesejado())){
                spinner.setSelection(i);
                break;
            }
        }

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editPrimeiroNome.setText("");
                editSobrenome.setText("");
                //editNomeCurso.setText("");

                editTelefoneContato.setText("");

                controller.limpar();

            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Volte Sempre", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pessoa.setPrimeiroNome(editPrimeiroNome.getText().toString());
                pessoa.setSobreNome(editSobrenome.getText().toString());
                //pessoa.setCursoDesejado(editNomeCurso.getText().toString());
                pessoa.setCursoDesejado(spinner.getSelectedItem().toString());
                pessoa.setTelefoneContato(editTelefoneContato.getText().toString());

                Toast.makeText(MainActivity.this, "Salvo " + pessoa.toString(), Toast.LENGTH_LONG).show();
                controller.salvar(pessoa);

            }
        });

        Log.i("POOAndroid", pessoa.toString());
    }
}