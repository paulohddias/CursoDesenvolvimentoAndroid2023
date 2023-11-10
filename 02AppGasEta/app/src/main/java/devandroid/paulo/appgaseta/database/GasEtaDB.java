package devandroid.paulo.appgaseta.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import devandroid.paulo.appgaseta.model.Curso;

public class GasEtaDB extends SQLiteOpenHelper {

    public static final String DB_NAME = "gaseta.db";
    public static final int DB_VERSION = 1;
    Curso curso;
    SQLiteDatabase db;



    public GasEtaDB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //QUERY SQL para Criar Tablela
        String sqlTabelaCombustivel = "CREATE TABLE Combustivel (id INTEGER PRIMARY KEY AUTOINCREMENT, nomeCombustivel TEXT, precoCombustivel REAL, recomendacao TEXT)";
        db.execSQL(sqlTabelaCombustivel);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldversion, int newVersion) {

    }

    //TODO metodos para implementar um CRUD
}
