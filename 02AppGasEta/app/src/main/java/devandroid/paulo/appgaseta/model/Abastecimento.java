package devandroid.paulo.appgaseta.model;

public class Abastecimento {
    private Double precoGasolina, precoEtanol, qtdLitros, totalPagar;
    private int kmAtual, kmAntigo;

    private String combustivelSelecionado;

    public Double getPrecoGasolina() {
        return precoGasolina;
    }

    public void setPrecoGasolina(Double precoGasolina) {
        this.precoGasolina = precoGasolina;
    }

    public Double getPrecoEtanol() {
        return precoEtanol;
    }

    public void setPrecoEtanol(Double precoEtanol) {
        this.precoEtanol = precoEtanol;
    }

    public Double getQtdLitros() {
        return qtdLitros;
    }

    public void setQtdLitros(Double qtdLitros) {
        this.qtdLitros = qtdLitros;
    }

    public Double getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(Double totalPagar) {
        this.totalPagar = totalPagar;
    }

    public int getKmAtual() {
        return kmAtual;
    }

    public void setKmAtual(int kmAtual) {
        this.kmAtual = kmAtual;
    }

    public int getKmAntigo() {
        return kmAntigo;
    }

    public void setKmAntigo(int kmAntigo) {
        this.kmAntigo = kmAntigo;
    }

    public String getCombustivelSelecionado() {
        return combustivelSelecionado;
    }

    public void setCombustivelSelecionado(String combustivelSelecionado) {
        this.combustivelSelecionado = combustivelSelecionado;
    }

    @Override
    public String toString() {
        return "Abastecimento{" +
                "precoGasolina=" + precoGasolina +
                ", precoEtanol=" + precoEtanol +
                ", qtdLitros=" + qtdLitros +
                ", totalPagar=" + totalPagar +
                ", kmAtual=" + kmAtual +
                ", kmAntigo=" + kmAntigo +
                ", combustivelSelecionado='" + combustivelSelecionado + '\'' +
                '}';
    }
}