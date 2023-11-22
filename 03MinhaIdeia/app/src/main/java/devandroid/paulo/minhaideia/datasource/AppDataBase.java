package devandroid.paulo.minhaideia.datasource;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import devandroid.paulo.minhaideia.api.AppUtil;
import devandroid.paulo.minhaideia.datamodel.ClienteDataModel;
import devandroid.paulo.minhaideia.datamodel.ProdutoDataModel;
import devandroid.paulo.minhaideia.model.Cliente;

public class AppDataBase extends SQLiteOpenHelper {

    public static final String DB_NAME = "AppMinhaIdeia.sqlite";
    public static final int DB_VERSION = 1;
    SQLiteDatabase db;

    public AppDataBase(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        Log.d(AppUtil.TAG, "AppDataBase: Criando Banco de Dados");
        db = getWritableDatabase();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ClienteDataModel.criarTabela());
        Log.d(AppUtil.TAG, "AppDataBase: Tabela cliente " + ClienteDataModel.queryCriarTabela);

        db.execSQL(ProdutoDataModel.criarTabela());
        Log.d(AppUtil.TAG, "AppDataBase: Tabela produto " + ProdutoDataModel.queryCriarTabela);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    /**
     * Metodo para inserir no banco de dados
     *
     * @return true ou false
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

    /**
     * Metodo para deletar um dado no banco de dados
     *
     * @return true ou false
     */
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

    /**
     * Metodo para alterar um dado por id
     *
     * @param tabela
     * @param dados
     * @return
     */
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

    @SuppressLint("Range")
    public List<Cliente> getAllClientes(String tabela) {
        db = getWritableDatabase();

        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM " + tabela;

        Cliente obj;

        Cursor cursor;

        cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            do {
                obj = new Cliente();

                obj.setId(cursor.getInt(cursor.getColumnIndex(ClienteDataModel.ID)));
                obj.setNome(cursor.getString(cursor.getColumnIndex(ClienteDataModel.NOME)));
                obj.setEmail(cursor.getString(cursor.getColumnIndex(ClienteDataModel.EMAIL)));

                clientes.add(obj);
            } while (cursor.moveToNext());
        }

        return clientes;
    }


}
