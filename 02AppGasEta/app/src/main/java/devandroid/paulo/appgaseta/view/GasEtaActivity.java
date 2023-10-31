package devandroid.paulo.appgaseta.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Locale;

import devandroid.paulo.appgaseta.R;
import devandroid.paulo.appgaseta.controller.AbastecimentoControler;
import devandroid.paulo.appgaseta.model.Abastecimento;
import devandroid.paulo.appgaseta.util.MoneyTextWatcher;
import devandroid.paulo.appgaseta.util.UtilGasEta;

public class GasEtaActivity extends AppCompatActivity {

    Abastecimento abastecimento;
    AbastecimentoControler abastecimentoControler;
    EditText editGasolina, editEtanol, editQtdLitros, editTotalPagar, editKmAtual;
    TextInputLayout txtGasolina, txtEtanol;
    Button btnLimpar, btnSalvar, btnFinalizar, btnCalcular;
    TextView textViewResultado;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaseta);

        abastecimento = new Abastecimento();
        abastecimentoControler = new AbastecimentoControler(GasEtaActivity.this);

        //abastecimentoControler.buscar(abastecimento);

        editGasolina = findViewById(R.id.editGasolina);
        editEtanol = findViewById(R.id.editEtanol);
        editQtdLitros = findViewById(R.id.editQtdLitros);
        editTotalPagar = findViewById(R.id.editTotalPagar);
        editKmAtual = findViewById(R.id.editKmAtual);

        txtGasolina = findViewById(R.id.txtGasolina);
        txtEtanol = findViewById(R.id.txtEtanol);


        btnFinalizar = findViewById(R.id.btnFinalizar);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnCalcular = findViewById(R.id.btnCalcular);

        textViewResultado = findViewById(R.id.textResultado);

        Locale mLocale = new Locale("pt", "BR");
        editGasolina.addTextChangedListener(new MoneyTextWatcher(editGasolina, mLocale));
        editEtanol.addTextChangedListener(new MoneyTextWatcher(editEtanol, mLocale));
        editTotalPagar.addTextChangedListener(new MoneyTextWatcher(editTotalPagar, mLocale));


        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                limpar();
                abastecimentoControler.limpar();
            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(GasEtaActivity.this, "Volte Sempre", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(GasEtaActivity.this, "Não faz nada!!!", Toast.LENGTH_LONG).show();

            }
        });

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double gasolina, etanol, qtdLitros, totalPagar;
                int kmAtual;

                if (validadeForm() == true) {
                    gasolina = MoneyTextWatcher.stringMonetarioToDouble(editGasolina.getText().toString());
                    etanol = MoneyTextWatcher.stringMonetarioToDouble(editEtanol.getText().toString());

                    totalPagar = MoneyTextWatcher.stringMonetarioToDouble(editTotalPagar.getText().toString());
                    qtdLitros = Double.parseDouble(editQtdLitros.getText().toString());
                    kmAtual = Integer.parseInt(editKmAtual.getText().toString());

                    abastecimento.setPrecoGasolina(gasolina);
                    abastecimento.setPrecoEtanol(etanol);
                    abastecimento.setKmAtual(kmAtual);
                    abastecimento.setQtdLitros(qtdLitros);
                    abastecimento.setTotalPagar(totalPagar);


                    String resultado = UtilGasEta.calcularMelhorOpcao(gasolina, etanol, qtdLitros);

                    textViewResultado.setText(resultado);
                    abastecimentoControler.salvar(abastecimento);

                }


            }
        });


    }

    public void limpar() {
        editGasolina.setText("0");
        editEtanol.setText("0");
        editQtdLitros.setText("0");
        editKmAtual.setText("0");
        editTotalPagar.setText("0");
        textViewResultado.setText("Resultado");
    }

    public boolean validadeForm() {
        if (editGasolina.getText().toString().isEmpty() || editGasolina.getText().toString().equals("R$ 0,00")) {
            txtGasolina.setErrorEnabled(true);
            txtGasolina.setError("Preencher o valor da gasolina!!!");
            editGasolina.requestFocus();
        } else if (editEtanol.getText().toString().isEmpty() || editEtanol.getText().toString().equals("R$ 0,00")) {
            txtEtanol.setErrorEnabled(true);
            txtEtanol.setError("Preencher o valor do etanol!!!");
            editEtanol.requestFocus();
        } else {
            txtGasolina.setErrorEnabled(false);
            txtEtanol.setErrorEnabled(false);

            if (editTotalPagar.getText().toString().isEmpty()) {
                editTotalPagar.setText("0");
            }
            if (editQtdLitros.getText().toString().isEmpty()) {
                editQtdLitros.setText("0");
            }
            if (editKmAtual.getText().toString().isEmpty()) {
                editKmAtual.setText("0");
            }
            return true;
        }
        return false;
    }

}
