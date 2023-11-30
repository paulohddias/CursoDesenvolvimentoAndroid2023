package devandroid.paulo.minhaideia.view;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
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
    TableLayout table;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(AppUtil.TAG, "onCreate: Tela principal carregada...");

        // Bundle bundle = getIntent().getExtras();

        // Log.d(AppUtil.TAG, "onCreate: Nome... "+ bundle.getString("nome"));
        // Log.d(AppUtil.TAG, "onCreate: Email... "+ bundle.getString("email"));


        //txtNome = findViewById(R.id.txtNome);
        //txtEmail = findViewById(R.id.txtemail);

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

        for (Cliente cli : clienteController.getAllClientes(ClienteDataModel.TABELA)) {
            Log.d(AppUtil.TAG, "MainActivity.listar Cliente: " + cli.getNome());
        }


        //TableLayout table = new TableLayout(this);
        table = findViewById(R.id.tb_tabela);

        table.setStretchAllColumns(true);
        table.setShrinkAllColumns(true);

        TableRow rowTitle = new TableRow(this);
        rowTitle.setGravity(Gravity.CENTER_HORIZONTAL);

        TableRow rowDayLabels = new TableRow(this);
        TableRow rowHighs = new TableRow(this);
        TableRow rowLows = new TableRow(this);
        TableRow rowConditions = new TableRow(this);
        rowConditions.setGravity(Gravity.CENTER);

        TextView empty = new TextView(this);

        // title column/row
        TextView title = new TextView(this);
        title.setText("Java Weather Table");

        title.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 18);
        title.setGravity(Gravity.CENTER);
        title.setTypeface(Typeface.SERIF, Typeface.BOLD);

        TableRow.LayoutParams params = new TableRow.LayoutParams();
        params.span = 6;

        rowTitle.addView(title, params);

        // labels column
        TextView highsLabel = new TextView(this);
        highsLabel.setText("Day High");
        highsLabel.setTypeface(Typeface.DEFAULT_BOLD);

        TextView lowsLabel = new TextView(this);
        lowsLabel.setText("Day Low");
        lowsLabel.setTypeface(Typeface.DEFAULT_BOLD);

        TextView conditionsLabel = new TextView(this);
        conditionsLabel.setText("Conditions");
        conditionsLabel.setTypeface(Typeface.DEFAULT_BOLD);

        rowDayLabels.addView(empty);
        rowHighs.addView(highsLabel);
        rowLows.addView(lowsLabel);
        rowConditions.addView(conditionsLabel);

        // day 1 column
        TextView day1Label = new TextView(this);
        day1Label.setText("Feb 7");
        day1Label.setTypeface(Typeface.SERIF, Typeface.BOLD);

        TextView day1High = new TextView(this);
        day1High.setText("28°F");
        day1High.setGravity(Gravity.CENTER_HORIZONTAL);

        TextView day1Low = new TextView(this);
        day1Low.setText("15°F");
        day1Low.setGravity(Gravity.CENTER_HORIZONTAL);

        ImageView day1Conditions = new ImageView(this);
        day1Conditions.setImageResource(R.drawable.ic_bomba2);

        rowDayLabels.addView(day1Label);
        rowHighs.addView(day1High);
        rowLows.addView(day1Low);
        rowConditions.addView(day1Conditions);

        // day2 column
        TextView day2Label = new TextView(this);
        day2Label.setText("Feb 8");
        day2Label.setTypeface(Typeface.SERIF, Typeface.BOLD);

        TextView day2High = new TextView(this);
        day2High.setText("26°F");
        day2High.setGravity(Gravity.CENTER_HORIZONTAL);

        TextView day2Low = new TextView(this);
        day2Low.setText("14°F");
        day2Low.setGravity(Gravity.CENTER_HORIZONTAL);

        ImageView day2Conditions = new ImageView(this);
        day2Conditions.setImageResource(R.drawable.ic_bomba1);

        rowDayLabels.addView(day2Label);
        rowHighs.addView(day2High);
        rowLows.addView(day2Low);
        rowConditions.addView(day2Conditions);

        // day3 column
        TextView day3Label = new TextView(this);
        day3Label.setText("Feb 9");
        day3Label.setTypeface(Typeface.SERIF, Typeface.BOLD);

        TextView day3High = new TextView(this);
        day3High.setText("23°F");
        day3High.setGravity(Gravity.CENTER_HORIZONTAL);

        TextView day3Low = new TextView(this);
        day3Low.setText("3°F");
        day3Low.setGravity(Gravity.CENTER_HORIZONTAL);

        ImageView day3Conditions = new ImageView(this);
        day3Conditions.setImageResource(R.drawable.ic_bomba2);

        rowDayLabels.addView(day3Label);
        rowHighs.addView(day3High);
        rowLows.addView(day3Low);
        rowConditions.addView(day3Conditions);

        // day4 column
        TextView day4Label = new TextView(this);
        day4Label.setText("Feb 10");
        day4Label.setTypeface(Typeface.SERIF, Typeface.BOLD);

        TextView day4High = new TextView(this);
        day4High.setText("17°F");
        day4High.setGravity(Gravity.CENTER_HORIZONTAL);

        TextView day4Low = new TextView(this);
        day4Low.setText("5°F");
        day4Low.setGravity(Gravity.CENTER_HORIZONTAL);

        ImageView day4Conditions = new ImageView(this);
        day4Conditions.setImageResource(R.drawable.ic_bomba1);

        rowDayLabels.addView(day4Label);
        rowHighs.addView(day4High);
        rowLows.addView(day4Low);
        rowConditions.addView(day4Conditions);

        // day5 column
        TextView day5Label = new TextView(this);
        day5Label.setText("Feb 11");
        day5Label.setTypeface(Typeface.SERIF, Typeface.BOLD);

        TextView day5High = new TextView(this);
        day5High.setText("19°F");
        day5High.setGravity(Gravity.CENTER_HORIZONTAL);

        TextView day5Low = new TextView(this);
        day5Low.setText("6°F");
        day5Low.setGravity(Gravity.CENTER_HORIZONTAL);

        ImageView day5Conditions = new ImageView(this);
        day5Conditions.setImageResource(R.drawable.ic_bomba2);

        rowDayLabels.addView(day5Label);
        rowHighs.addView(day5High);
        rowLows.addView(day5Low);
        rowConditions.addView(day5Conditions);

        table.addView(rowTitle);
        table.addView(rowDayLabels);
        table.addView(rowHighs);
        table.addView(rowLows);
        table.addView(rowConditions);

        Log.e(AppUtil.TAG, "MainActivity.setContentView: antes ERRO DE MERDA");

       // setContentView(table);

        Log.e(AppUtil.TAG, "MainActivity.setContentView: ERRO DE MERDA");

    }

}