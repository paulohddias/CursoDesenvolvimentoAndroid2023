package devandroid.paulo.minhaideia.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import devandroid.paulo.minhaideia.R;
import devandroid.paulo.minhaideia.api.AppUtil;
import devandroid.paulo.minhaideia.controller.ClienteController;
import devandroid.paulo.minhaideia.controller.ProdutoController;
import devandroid.paulo.minhaideia.datamodel.ClienteDataModel;
import devandroid.paulo.minhaideia.model.Cliente;
import devandroid.paulo.minhaideia.model.Produto;

public class MainActivity extends AppCompatActivity {
    Cliente objCliente;

    TextView txtNome, txtEmail;

    ClienteController clienteController;
    Cliente cliente;
    ProdutoController produtoController;
    Produto produto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(AppUtil.TAG, "onCreate: Tela principal carregada...");

        // Bundle bundle = getIntent().getExtras();

        // Log.d(AppUtil.TAG, "onCreate: Nome... "+ bundle.getString("nome"));
        // Log.d(AppUtil.TAG, "onCreate: Email... "+ bundle.getString("email"));


        txtNome = findViewById(R.id.txtNome);
        txtEmail = findViewById(R.id.txtemail);

        //txtNome.setText(bundle.getString("nome"));
        //txtEmail.setText(bundle.getString("email"));

        cliente = new Cliente();
        cliente.setNome("Paulo Dias");
        cliente.setEmail("paulohddias@gmail.com");

        clienteController = new ClienteController(this);
        if (clienteController.incluir(cliente)) {
            Toast.makeText(MainActivity.this,
                    "Cliente " + cliente.getNome() + " incluiso com sucesso...", Toast.LENGTH_LONG).show();
            Log.i(AppUtil.TAG, "MainActivity.Cliente: " + cliente.getNome() + " incluiso com sucesso...");
        } else {
            Toast.makeText(MainActivity.this,
                    "Cliente " + cliente.getNome() + " não incluiso com sucesso...", Toast.LENGTH_LONG).show();
            Log.e(AppUtil.TAG, "MainActivity.Cliente: " + cliente.getNome() + " não incluiso com sucesso...");
        }

        produto = new Produto();
        produto.setNome("Teclado");
        produto.setFornecedor("Dell");

        produtoController = new ProdutoController(this);

        if (produtoController.incluir(produto)) {
            Toast.makeText(MainActivity.this,
                    "Cliente " + produto.getNome() + " incluiso com sucesso...", Toast.LENGTH_LONG).show();
            Log.i(AppUtil.TAG, "MainActivity.Produto: " + produto.getNome() + " incluiso com sucesso...");
        } else {
            Toast.makeText(MainActivity.this,
                    "Cliente " + produto.getNome() + " não incluiso com sucesso...", Toast.LENGTH_LONG).show();
            Log.e(AppUtil.TAG, "MainActivity.Produto: " + produto.getNome() + " não incluiso com sucesso...");
        }

        for (Cliente cli:clienteController.getAllClientes(ClienteDataModel.TABELA)) {
            Log.d(AppUtil.TAG, "MainActivity.listar Cliente: "+cli.getNome());
        }

    }
}