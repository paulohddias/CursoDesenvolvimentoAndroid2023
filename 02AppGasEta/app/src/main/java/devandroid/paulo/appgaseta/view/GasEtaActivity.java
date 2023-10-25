package devandroid.paulo.appgaseta.view;

import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

import devandroid.paulo.appgaseta.R;
import devandroid.paulo.appgaseta.util.MaskEditUtil;
import devandroid.paulo.appgaseta.util.MoneyTextWatcher;
import devandroid.paulo.appgaseta.util.UtilGasEta;

public class GasEtaActivity extends AppCompatActivity {

    EditText editGasolina, editEtanol;
    Button btnLimpar, btnSalvar, btnFinalizar, btnCalcular;
    TextView textViewResultado;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaseta);

        editGasolina = findViewById(R.id.editGasolina);
        editEtanol = findViewById(R.id.editEtanol);

        btnFinalizar = findViewById(R.id.btnFinalizar);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnCalcular = findViewById(R.id.btnCalcular);

        textViewResultado = findViewById(R.id.textResultado);

        Locale mLocale = new Locale("pt", "BR");
        editGasolina.addTextChangedListener(new MoneyTextWatcher(editGasolina, mLocale));
        editEtanol.addTextChangedListener(new MoneyTextWatcher(editEtanol, mLocale));

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editGasolina.setText("0");
                editEtanol.setText("0");
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
                Double gasolina, etanol;
                String gas = editGasolina.getText().toString();
                String eta = editEtanol.getText().toString();
                gasolina = MoneyTextWatcher.stringMonetarioToDouble(gas);
                etanol = MoneyTextWatcher.stringMonetarioToDouble(eta);

                String resultado = UtilGasEta.calcularMelhorOpcao(gasolina, etanol);

                textViewResultado.setText(resultado);
            }
        });


    }


}
