package devandroid.paulo.appgaseta.model;

import java.util.Date;

public class Abastecimento {
    private int idAbastecimento;
    private Double precoGasolina, precoEtanol, qtdLitros, totalPagar, qtdLitrosConsumo;
    private int kmAtual, kmAntigo, kmConsumo;
    private String combustivelSelecionado;
    private String dataAbastecimento;

    public int getIdAbastecimento() {
        return idAbastecimento;
    }

    public void setIdAbastecimento(int idAbastecimento) {
        this.idAbastecimento = idAbastecimento;
    }

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

    public Double getQtdLitrosConsumo() {
        return qtdLitrosConsumo;
    }

    public void setQtdLitrosConsumo(Double qtdLitrosConsumo) {
        this.qtdLitrosConsumo = qtdLitrosConsumo;
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

    public int getKmConsumo() {
        return kmConsumo;
    }

    public void setKmConsumo(int kmConsumo) {
        this.kmConsumo = kmConsumo;
    }

    public String getCombustivelSelecionado() {
        return combustivelSelecionado;
    }

    public void setCombustivelSelecionado(String combustivelSelecionado) {
        this.combustivelSelecionado = combustivelSelecionado;
    }

    public String getDataAbastecimento() {
        return dataAbastecimento;
    }

    public void setDataAbastecimento(String dataAbastecimento) {
        this.dataAbastecimento = dataAbastecimento;
    }

    @Override
    public String toString() {
        return "Abastecimento{" +
                "idAbastecimento=" + idAbastecimento +
                ", precoGasolina=" + precoGasolina +
                ", precoEtanol=" + precoEtanol +
                ", qtdLitros=" + qtdLitros +
                ", totalPagar=" + totalPagar +
                ", qtdLitrosConsumo=" + qtdLitrosConsumo +
                ", kmAtual=" + kmAtual +
                ", kmAntigo=" + kmAntigo +
                ", kmConsumo=" + kmConsumo +
                ", combustivelSelecionado='" + combustivelSelecionado + '\'' +
                ", dataAbastecimento=" + dataAbastecimento +
                '}';
    }
}
