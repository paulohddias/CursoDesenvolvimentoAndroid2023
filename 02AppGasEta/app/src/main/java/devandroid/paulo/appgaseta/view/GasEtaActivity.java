package devandroid.paulo.appgaseta.view;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
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
    EditText editGasolina, editEtanol, editQtdLitros, editKmAtual;
    TextInputLayout txtGasolina, txtEtanol, txtQtdLitors, txtKmAtual;
    Button btnLimpar, btnSalvar, btnFinalizar, btnCalcular;
    TextView textViewResultado;

    TableLayout tabHistorico;

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
        editKmAtual = findViewById(R.id.editKmAtual);

        txtGasolina = findViewById(R.id.txtGasolina);
        txtEtanol = findViewById(R.id.txtEtanol);
        txtQtdLitors = findViewById(R.id.txtQtdLitros);
        txtKmAtual = findViewById(R.id.txtKmAtual);

        btnFinalizar = findViewById(R.id.btnFinalizar);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnCalcular = findViewById(R.id.btnCalcular);

        textViewResultado = findViewById(R.id.textResultado);

        tabHistorico = findViewById(R.id.tabHistorico);

        Locale mLocale = new Locale("pt", "BR");
        editGasolina.addTextChangedListener(new MoneyTextWatcher(editGasolina, mLocale));
        editEtanol.addTextChangedListener(new MoneyTextWatcher(editEtanol, mLocale));


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

                    qtdLitros = Double.parseDouble(editQtdLitros.getText().toString());
                    kmAtual = Integer.parseInt(editKmAtual.getText().toString());

                    abastecimento.setPrecoGasolina(gasolina);
                    abastecimento.setPrecoEtanol(etanol);
                    abastecimento.setKmAtual(kmAtual);
                    abastecimento.setQtdLitros(qtdLitros);
                    abastecimento.setTotalPagar(250.0);

                    String resultado = UtilGasEta.calcularMelhorOpcao(gasolina, etanol, qtdLitros);

                    abastecimento.setCombustivelSelecionado(abastecimentoControler.combustivelSelecionado(resultado));
                    abastecimento.setTotalPagar(abastecimentoControler.totalPagarSelecionado(resultado));

                    textViewResultado.setText(resultado);
                    abastecimentoControler.salvar(abastecimento);
                    dadosTabela(tabHistorico, abastecimento);

                }


            }
        });


    }

    public void limpar() {
        editGasolina.setText("0");
        editEtanol.setText("0");
        editQtdLitros.setText("0");
        editKmAtual.setText("0");
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
        } else if (editQtdLitros.getText().toString().isEmpty() || editQtdLitros.getText().toString().equals("0")) {
            txtQtdLitors.setErrorEnabled(true);
            txtQtdLitors.setError("Preencher a quantidade de litros!!!");
            editQtdLitros.requestFocus();
        } else if (editKmAtual.getText().toString().isEmpty() || editKmAtual.getText().toString().equals("0")) {
            txtKmAtual.setErrorEnabled(true);
            txtKmAtual.setError("Preencher o KM atual!!!");
            editKmAtual.requestFocus();
        } else {
            txtGasolina.setErrorEnabled(false);
            txtEtanol.setErrorEnabled(false);
            txtQtdLitors.setErrorEnabled(false);
            txtKmAtual.setErrorEnabled(false);

            return true;
        }
        return false;
    }

    public void criarLinhaTabela(TableLayout tableLayout) {
        View vLinha = new View(this);
        vLinha.setBackgroundColor(Color.parseColor("#2c3e50"));
        vLinha.setMinimumHeight(5);
        tableLayout.addView(vLinha);
    }

    public void dadosTabela(TableLayout tableLayout, Abastecimento abastecimento) {
        TableRow tr_head = new TableRow(this);


        TextView labelCombustivel = new TextView(this);
        labelCombustivel.setText(abastecimento.getCombustivelSelecionado());
        tr_head.addView(labelCombustivel);

        TextView labelPreco = new TextView(this);
        labelPreco.setText(UtilGasEta.doubleParaReal(abastecimento.getPrecoGasolina()));
        tr_head.addView(labelPreco);

        TextView labelLitros = new TextView(this);
        labelLitros.setText(abastecimento.getQtdLitros().toString());
        tr_head.addView(labelLitros);

        TextView labelKmAtual = new TextView(this);
        labelKmAtual.setText(Integer.toString(abastecimento.getKmAtual()));
        tr_head.addView(labelKmAtual);

        TextView labelTotalPagar = new TextView(this);
        labelTotalPagar.setText(UtilGasEta.doubleParaReal(abastecimento.getTotalPagar()));
        tr_head.addView(labelTotalPagar);

        TextView labelConsumo = new TextView(this);
        labelConsumo.setText("200");
        tr_head.addView(labelConsumo);

        tableLayout.addView(tr_head, new TableLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT));

        criarLinhaTabela(tableLayout);

    }

}
