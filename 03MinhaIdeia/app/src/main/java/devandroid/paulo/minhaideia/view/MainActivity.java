package devandroid.paulo.minhaideia.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import devandroid.paulo.minhaideia.R;
import devandroid.paulo.minhaideia.model.Cliente;

public class MainActivity extends AppCompatActivity {

    String TAG = "APP_MINHA_IDEIA";
    Cliente objCliente;

    TextView txtNome, txtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: Tela principal carregada...");

        Bundle bundle = getIntent().getExtras();

        Log.d(TAG, "onCreate: Nome... "+ bundle.getString("nome"));
        Log.d(TAG, "onCreate: Email... "+ bundle.getString("email"));


        txtNome = findViewById(R.id.txtNome);
        txtEmail = findViewById(R.id.txtemail);

        txtNome.setText(bundle.getString("nome"));
        txtEmail.setText(bundle.getString("email"));




    }
}