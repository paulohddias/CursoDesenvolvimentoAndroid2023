package devandroid.paulo.appgaseta.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import devandroid.paulo.appgaseta.model.Abastecimento;

public class GasEtaDB extends SQLiteOpenHelper {

    private static final String DB_NAME = "gaseta.db";
    private static final int DB_VERSION = 1;
    Cursor cursor;
    SQLiteDatabase db;


    public GasEtaDB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //QUERY SQL para Criar Tablela

        String sqlTabelaAbasteciemnto = "CREATE TABLE Abastecimento (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "dataAbastecimento DATE, " +
                "precoGasolina REAL, " +
                "precoEtanol REAL, " +
                "qtdLitros REAL, " +
                "qtdLitrosConsumo REAL, " +
                "totalPagar REAL, " +
                "kmAtual INTEGER, " +
                "kmAntigo INTEGER, " +
                "kmConsumo INTEGER, " +
                "combustivelSelecionado TEXT" + ")";

        db.execSQL(sqlTabelaAbasteciemnto);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldversion, int newVersion) {

    }

    //TODO metodos para implementar um CRUD

    public void salvarObjeto(String tabela, ContentValues dados) {
        db.insert(tabela, null, dados);
    }

    public List<Abastecimento> listarDados() {
        List<Abastecimento> lista = new ArrayList<>();

        Abastecimento registro;
        String query = "select * from (SELECT * FROM Abastecimento ORDER BY id desc LIMIT 5) as x order by x.id";
        cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                registro = new Abastecimento();

                registro.setIdAbastecimento(cursor.getInt(0));
                registro.setPrecoGasolina(cursor.getDouble(1));
                registro.setPrecoEtanol(cursor.getDouble(2));
                registro.setQtdLitros(cursor.getDouble(3));
                registro.setTotalPagar(cursor.getDouble(4));
                registro.setKmAtual(cursor.getInt(5));
                registro.setKmAntigo(cursor.getInt(6));
                registro.setKmConsumo(cursor.getInt(7));
                registro.setCombustivelSelecionado(cursor.getString(8));

                lista.add(registro);

            } while (cursor.moveToNext());
        } else {

        }

        return lista;
    }

    public Abastecimento ultimoRegistro() {
        Abastecimento registro = new Abastecimento();
        String query = "SELECT *  FROM Abastecimento ORDER BY  id DESC LIMIT 1";
        cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                registro = new Abastecimento();

                registro.setIdAbastecimento(cursor.getInt(0));
                registro.setPrecoGasolina(cursor.getDouble(1));
                registro.setPrecoEtanol(cursor.getDouble(2));
                registro.setQtdLitros(cursor.getDouble(3));
                registro.setTotalPagar(cursor.getDouble(4));
                registro.setKmAtual(cursor.getInt(5));
                registro.setKmAntigo(cursor.getInt(6));
                registro.setKmConsumo(cursor.getInt(7));
                registro.setCombustivelSelecionado(cursor.getString(8));

            } while (cursor.moveToNext());
        } else {

        }

        return registro;
    }

    public void alterarObejto(String tabela, ContentValues dados) {
        int id = dados.getAsInteger("id");
        db.update(tabela, dados, "id=?", new String[]{Integer.toString(id)});
    }

    public void deletarObjeto(String tabela, int id) {
        db.delete(tabela, "id=?", new String[]{Integer.toString(id)});
    }

}
