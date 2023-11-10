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

        String sqlTabelaAbasteciemnto ="CREATE TABLE Abastecimento (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "precoGasolina REAL, " +
                "precoEtanol REAL, " +
                "qtdLitros REAL, " +
                "totalPagar REAL, " +
                "kmAtual INTEGER, " +
                "kmAntigo INTEGER, " +
                "combustivelSelecionado TEXT" +
                ")";

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
        String query = "SELECT * FROM Abastecimento";
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
                registro.setCombustivelSelecionado(cursor.getString(7));

                lista.add(registro);

            } while (cursor.moveToNext());
        } else {

        }

        return lista;
    }
}
