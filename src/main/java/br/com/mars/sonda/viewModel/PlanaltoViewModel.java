package br.com.mars.sonda.viewModel;

import br.com.mars.sonda.models.Posicao;

import javax.validation.constraints.Min;

public class PlanaltoViewModel {

    @Min(0)
    private int eixoX;

    @Min(0)
    private int eixoY;

    public PlanaltoViewModel(int eixoX, int eixoY) {
        this.eixoX = eixoX;
        this.eixoY = eixoY;
    }

    @Deprecated
    public PlanaltoViewModel() { }

    public void setEixoX(int eixoX) {
        this.eixoX = eixoX;
    }

    public void setEixoY(int eixoY) {
        this.eixoY = eixoY;
    }

    public Planalto toPlanalto() {

        Posicao norteLeste = new Posicao(eixoX, eixoY);
        return new Planalto(norteLeste);
    }
}
