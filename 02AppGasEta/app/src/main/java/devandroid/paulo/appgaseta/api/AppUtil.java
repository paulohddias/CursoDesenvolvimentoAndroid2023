package devandroid.paulo.appgaseta.api;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class AppUtil {

    public final static String TAG = "GasEta";


    public static String calcularMelhorOpcao(double gasolina, double etanol) {
        double precoIdeal = gasolina * 0.70;
        String mensagemDeRetorno;

        if (etanol <= precoIdeal) {
            mensagemDeRetorno = "Abastecer com Etanol !!!";
        } else {
            mensagemDeRetorno = "Abastecer com Gasolina !!!";
        }
        return mensagemDeRetorno;
    }

    public static String doubleParaReal(Double valor) {
        Locale ptBr = new Locale("pt", "BR");
        String valorString = NumberFormat.getCurrencyInstance(ptBr).format(valor);
        return valorString;
    }

    public static Double doubleDuasCasasDecimais(Double v) {
        double valor = Math.round(v * 100.0) / 100.0;
        return valor;
    }

    public static String doubleToString(Double v) {
        return v.toString().replace(".",",");
    }
}
