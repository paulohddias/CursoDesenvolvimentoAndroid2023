package devandroid.paulo.minhaideia.datamodel;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ProdutoDataModel {
    //Nome da Tabela
    public static final String TABELA = "produto";

    //Atributos da Tabela
    public static final String ID = "id"; //INTEGER
    public static final String NOME = "nome"; //TEXT
    public static final String FORNECEDOR = "fornecedor"; //TEXT

    //Query para criar a tabela no banco de daods
    public static String queryCriarTabela = "";

    //Metodo para gerar o Script para criar a tabela
    public static String criarTabela() {
        //Concatenção de String

        queryCriarTabela += "CREATE TABLE " + TABELA + " (";
        queryCriarTabela += ID + " INTEGER PRIMARY KEY AUTOINCREMENT, ";
        queryCriarTabela += NOME + " TEXT, ";
        queryCriarTabela += FORNECEDOR + " TEXT ";
        queryCriarTabela += ")";
        return queryCriarTabela;
    }
}
