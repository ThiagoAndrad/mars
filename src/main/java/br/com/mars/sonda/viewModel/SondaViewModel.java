package br.com.mars.sonda.viewModel;

import br.com.mars.sonda.models.DirecaoCardinal;
import br.com.mars.sonda.models.Posicao;
import br.com.mars.sonda.models.Sonda;

import javax.validation.constraints.Min;

public class SondaViewModel {

    private  DirecaoCardinal direcaoCardinal;

    @Min(0)
    private int eixoX;

    @Min(0)
    private int eixoY;

    public SondaViewModel(DirecaoCardinal direcaoCardinal, int eixoX, int eixoY) {
        this.direcaoCardinal = direcaoCardinal;
        this.eixoX = eixoX;
        this.eixoY = eixoY;
    }

    @Deprecated
    public SondaViewModel() { }

    public void setDirecaoCardinal(DirecaoCardinal direcaoCardinal) {
        this.direcaoCardinal = direcaoCardinal;
    }

    public void setEixoX(int eixoX) {
        this.eixoX = eixoX;
    }

    public void setEixoY(int eixoY) {
        this.eixoY = eixoY;
    }

    public DirecaoCardinal getDirecaoCardinal() {
        return direcaoCardinal;
    }

    public Posicao getPosicao(){
        return new Posicao(eixoX, eixoY);
    }

}
