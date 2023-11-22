package devandroid.paulo.appgaseta.datasource;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import devandroid.paulo.appgaseta.api.AppUtil;
import devandroid.paulo.appgaseta.api.UtilData;
import devandroid.paulo.appgaseta.datamodel.AbastecimentoDataModel;
import devandroid.paulo.appgaseta.model.Abastecimento;

public class AppDataBase extends SQLiteOpenHelper {

    public static final String DB_NAME = "gaseta.sqlite";
    public static final int DB_VERSION = 1;
    SQLiteDatabase db;
    Cursor cursor;

    public AppDataBase(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        Log.d(AppUtil.TAG, "AppDataBase: Criando Banco de Dados");
        db = getWritableDatabase();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(AbastecimentoDataModel.criarTabela());
        Log.d(AppUtil.TAG, "AppDataBase: Tabela Abastecimento " + AbastecimentoDataModel.queryCriarTabela);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    /**
     * Metodo para inserir no banco de dados
     *
     * @return
     */
    public boolean insert(String tabela, ContentValues dados) {

        db = getWritableDatabase();

        boolean retorno = false;

        try {
            retorno = db.insert(tabela, null, dados) > 0;
        } catch (Exception e) {
            Log.d(AppUtil.TAG, "AppDataBase.insert: Erro ao inserir dados tabela " + tabela + " " + e.getMessage());
        }

        return retorno;
    }

    public boolean update(String tabela, ContentValues dados) {

        db = getWritableDatabase();

        boolean retorno = false;

        try {
            retorno = db.update(tabela, dados, "id = ?", new String[]{String.valueOf(dados.get("id"))}) > 0;
        } catch (Exception e) {
            Log.d(AppUtil.TAG, "AppDataBase.insert: Erro ao inserir dados tabela " + tabela + " " + e.getMessage());
        }

        return retorno;
    }

    public boolean deleteByID(String tabela, int id) {

        db = getWritableDatabase();

        boolean retorno = false;

        try {
            retorno = db.delete(tabela, "id = ?", new String[]{String.valueOf(id)}) > 0;
        } catch (Exception e) {
            Log.d(AppUtil.TAG, "AppDataBase.deleteByID: Erro ao deletar dados tabela " + tabela + " " + e.getMessage());
        }

        return retorno;
    }

    @SuppressLint("Range")
    public Abastecimento ultimoRegistro() {
        Abastecimento registro = new Abastecimento();
        String query = "SELECT *  FROM "+AbastecimentoDataModel.TABELA+" ORDER BY  id DESC LIMIT 1";
        cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                registro = new Abastecimento();

                registro.setIdAbastecimento(cursor.getInt(cursor.getColumnIndex(AbastecimentoDataModel.ID)));
                registro.setPrecoGasolina(cursor.getDouble(cursor.getColumnIndex(AbastecimentoDataModel.PRECOGASOLINA)));
                registro.setPrecoEtanol(cursor.getDouble(cursor.getColumnIndex(AbastecimentoDataModel.PRECOETANOL)));
                registro.setQtdLitros(cursor.getDouble(cursor.getColumnIndex(AbastecimentoDataModel.QTDLITROS)));
                registro.setTotalPagar(cursor.getDouble(cursor.getColumnIndex(AbastecimentoDataModel.TOTALPAGAR)));
                registro.setKmAtual(cursor.getInt(cursor.getColumnIndex(AbastecimentoDataModel.KMATUAL)));
                registro.setKmAntigo(cursor.getInt(cursor.getColumnIndex(AbastecimentoDataModel.KMANTIGO)));
                registro.setKmConsumo(cursor.getInt(cursor.getColumnIndex(AbastecimentoDataModel.KMCONSUMO)));
                registro.setCombustivelSelecionado(cursor.getString(cursor.getColumnIndex(AbastecimentoDataModel.COMBUSTIVELSELECIONADO)));
                registro.setDataAbastecimento(cursor.getString(cursor.getColumnIndex(AbastecimentoDataModel.DATAABASTECIMENTO)));

            } while (cursor.moveToNext());
        } else {

        }

        return registro;
    }

    @SuppressLint("Range")
    public List<Abastecimento> listarDados() {
        List<Abastecimento> lista = new ArrayList<>();

        Abastecimento registro;
        String query = "select * from (SELECT * FROM "+AbastecimentoDataModel.TABELA+" ORDER BY id desc LIMIT 5) as x order by x.id";
        cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                registro = new Abastecimento();

                registro.setIdAbastecimento(cursor.getInt(cursor.getColumnIndex(AbastecimentoDataModel.ID)));
                registro.setPrecoGasolina(cursor.getDouble(cursor.getColumnIndex(AbastecimentoDataModel.PRECOGASOLINA)));
                registro.setPrecoEtanol(cursor.getDouble(cursor.getColumnIndex(AbastecimentoDataModel.PRECOETANOL)));
                registro.setQtdLitros(cursor.getDouble(cursor.getColumnIndex(AbastecimentoDataModel.QTDLITROS)));
                registro.setTotalPagar(cursor.getDouble(cursor.getColumnIndex(AbastecimentoDataModel.TOTALPAGAR)));
                registro.setKmAtual(cursor.getInt(cursor.getColumnIndex(AbastecimentoDataModel.KMATUAL)));
                registro.setKmAntigo(cursor.getInt(cursor.getColumnIndex(AbastecimentoDataModel.KMANTIGO)));
                registro.setKmConsumo(cursor.getInt(cursor.getColumnIndex(AbastecimentoDataModel.KMCONSUMO)));
                registro.setCombustivelSelecionado(cursor.getString(cursor.getColumnIndex(AbastecimentoDataModel.COMBUSTIVELSELECIONADO)));
                registro.setDataAbastecimento(cursor.getString(cursor.getColumnIndex(AbastecimentoDataModel.DATAABASTECIMENTO)));

                lista.add(registro);

            } while (cursor.moveToNext());
        } else {

        }

        return lista;
    }
}
