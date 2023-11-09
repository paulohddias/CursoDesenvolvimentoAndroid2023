package devandroid.paulo.appgaseta.util;

import java.text.NumberFormat;
import java.util.Locale;

public class UtilGasEta {

    public static String calcularMelhorOpcao(double gasolina, double etanol, double qtdLitros) {
        double precoIdeal = gasolina * 0.70;
        double totalPagar;
        String mensagemDeRetorno;

        if (qtdLitros == 0) {
            qtdLitros = 1;
        }

        if (etanol <= precoIdeal) {
            totalPagar = etanol * qtdLitros;
            mensagemDeRetorno = "Abastecer com Etanol Total " + doubleParaReal(totalPagar);
        } else {
            totalPagar = gasolina
                    * qtdLitros;
            mensagemDeRetorno = "Abastecer com Gasolina Total " + doubleParaReal(totalPagar);
        }
        return mensagemDeRetorno;
    }

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

    public static String doubleParaReal(Double valor){
        Locale ptBr = new Locale("pt", "BR");
        String valorString = NumberFormat.getCurrencyInstance(ptBr).format(valor);
        return valorString;
    }
}
