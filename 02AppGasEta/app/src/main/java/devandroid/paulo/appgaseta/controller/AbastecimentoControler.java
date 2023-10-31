package devandroid.paulo.appgaseta.controller;

import android.content.SharedPreferences;

import devandroid.paulo.appgaseta.model.Abastecimento;
import devandroid.paulo.appgaseta.view.GasEtaActivity;

public class AbastecimentoControler {

    SharedPreferences preferences;
    SharedPreferences.Editor spEditorAbastecimento;

    public static final String NOME_PREFERENCES = "pref_abastecimento";


    public AbastecimentoControler(GasEtaActivity gasEtaActivity) {
        preferences = gasEtaActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        spEditorAbastecimento = preferences.edit();
    }

    public void salvar(Abastecimento abastecimento) {
        spEditorAbastecimento.putInt("kmAntigo", abastecimento.getKmAntigo());
        spEditorAbastecimento.putInt("kmAtual", abastecimento.getKmAtual());
        spEditorAbastecimento.putString("precoEtanol", abastecimento.getPrecoEtanol().toString());
        spEditorAbastecimento.putString("precoGasolina", abastecimento.getPrecoGasolina().toString());
        spEditorAbastecimento.putString("qtdLitros", abastecimento.getQtdLitros().toString());
        spEditorAbastecimento.putString("totalApagar", abastecimento.getTotalPagar().toString());


        spEditorAbastecimento.apply();


    }

    public Abastecimento buscar(Abastecimento abastecimento) {
        abastecimento.setKmAntigo(preferences.getInt("kmAntigo", 0));
        abastecimento.setKmAtual(preferences.getInt("kmAtual", 0));
        abastecimento.setPrecoEtanol((double) preferences.getFloat("precoEtanol", 0));
        abastecimento.setPrecoGasolina((double) preferences.getFloat("precoGasolina", 0));
        abastecimento.setQtdLitros((double) preferences.getFloat("qtdLitros", 0));
        abastecimento.setTotalPagar((double) preferences.getFloat("totalApagar", 0));


        return abastecimento;
    }

    public void limpar() {
        spEditorAbastecimento.clear();
        spEditorAbastecimento.apply();
    }

}
