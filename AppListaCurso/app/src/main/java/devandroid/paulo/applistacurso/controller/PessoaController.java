package devandroid.paulo.applistacurso.controller;

import android.content.SharedPreferences;

import devandroid.paulo.applistacurso.model.Pessoa;

public class PessoaController {

    SharedPreferences preferences;
    public static final String NOME_PREFERENCES = "pref_listavip";
    public void salvar(Pessoa pessoa) {
        preferences = getSharedPreferences(NOME_PREFERENCES, 0);
        SharedPreferences.Editor listaVip = preferences.edit();

    }
}
