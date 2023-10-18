package devandroid.paulo.applistacurso.controller;

import android.content.SharedPreferences;

import devandroid.paulo.applistacurso.model.Pessoa;
import devandroid.paulo.applistacurso.view.MainActivity;

public class PessoaController {
    SharedPreferences preferences;
    SharedPreferences.Editor listaVip;
    public static final String NOME_PREFERENCES = "pref_listavip";

    public PessoaController(MainActivity mainActivity){
        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        listaVip = preferences.edit();
    }
    public void salvar(Pessoa pessoa) {
        listaVip.putString("primeiroNome", pessoa.getPrimeiroNome());
        listaVip.putString("sobreNome", pessoa.getSobreNome());
        listaVip.putString("cursoDesejado", pessoa.getCursoDesejado());
        listaVip.putString("telefoneContato", pessoa.getTelefoneContato());

        listaVip.apply();
    }

    public Pessoa buscar(Pessoa pessoa){
        pessoa.setPrimeiroNome(preferences.getString("primeiroNome", ""));
        pessoa.setSobreNome(preferences.getString("sobreNome", ""));
        pessoa.setCursoDesejado(preferences.getString("cursoDesejado", ""));
        pessoa.setTelefoneContato(preferences.getString("telefoneContato", ""));
        return pessoa;
    }

    public void limpar(){
        listaVip.clear();
        listaVip.apply();
    }
}
