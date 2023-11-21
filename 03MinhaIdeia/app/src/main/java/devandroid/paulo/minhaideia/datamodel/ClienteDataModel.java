package devandroid.paulo.minhaideia.datamodel;

public class ClienteDataModel {

    //Nome da Tabela
    public static final String TABELA = "cliente";

    //Atributos da Tabela
    public static final String ID = "id"; //INTEGER
    public static final String NOME = "nome"; //TEXT
    public static final String EMAIL = "email"; //TEXT

    //Query para criar a tabela no banco de daods
    public static String queryCriarTabela = "";

    //Metodo para gerar o Script para criar a tabela
    public static String criarTabela() {
        //Concatenção de String

        queryCriarTabela += "CREATE TABLE " + TABELA + " (";
        queryCriarTabela += ID + " INTEGER PRIMARY KEY AUTOINCREMENT, ";
        queryCriarTabela += NOME + " TEXT, ";
        queryCriarTabela += EMAIL + " TEXT ";
        queryCriarTabela += ")";
        return queryCriarTabela;
    }

}
