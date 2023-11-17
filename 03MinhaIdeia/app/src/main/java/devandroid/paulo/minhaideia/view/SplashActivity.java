package devandroid.paulo.minhaideia.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import devandroid.paulo.minhaideia.R;
import devandroid.paulo.minhaideia.model.Cliente;

public class SplashActivity extends AppCompatActivity {

    public static final int TIME_OUT_SPLASH = 1000 * 3;
    Cliente objCliente;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(devandroid.paulo.minhaideia.R.layout.activity_splash);

        imageView = findViewById(R.id.imageView);
        Glide.with(this)
                .load(R.drawable.ic_bomba2)
                .into(imageView);

        cumutarTelaSplash();
    }

    private void cumutarTelaSplash() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //GasEtaDB db = new GasEtaDB(SplashActivity.this);

                objCliente = new Cliente("Dias",
                        "paulohddias@gmail.com",
                        "12997757353",
                        38,
                        true);

                Intent telaPrincipal = new Intent(SplashActivity.this, MainActivity.class);

                Bundle bundle = new Bundle();
                bundle.putString("nome", objCliente.getNome());
                bundle.putString("email", objCliente.getEmail());

                telaPrincipal.putExtras(bundle);

                startActivity(telaPrincipal);
                finish();
            }
        }, TIME_OUT_SPLASH);
    }
}