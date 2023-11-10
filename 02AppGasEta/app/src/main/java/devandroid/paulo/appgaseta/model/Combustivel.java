package devandroid.paulo.appgaseta.model;

public class Combustivel {

    private String nomeCombustivel;
    private double precoCombustivel;

    public String getNomeCombustivel() {
        return nomeCombustivel;
    }

    public void setNomeCombustivel(String nomeCombustivel) {
        this.nomeCombustivel = nomeCombustivel;
    }

    @Override
    public String toString() {
        return "Combustivel{" +
                "nomeCombustivel='" + nomeCombustivel + '\'' +
                ", precoCombustivel=" + precoCombustivel +
                '}';
    }
}
