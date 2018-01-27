package br.com.mars.sonda.viewModel;

import br.com.mars.sonda.models.DirecaoCardinal;
import br.com.mars.sonda.models.Posicao;
import br.com.mars.sonda.models.Sonda;

public class SondaViewModel {

    private  DirecaoCardinal direcaoCardinal;

    private int eixoX;

    private int eixoY;

    public Sonda toSonda() {
        Posicao posicao = new Posicao(eixoX, eixoY);
        return new Sonda(direcaoCardinal, posicao);
    }

    public void setDirecaoCardinal(DirecaoCardinal direcaoCardinal) {
        this.direcaoCardinal = direcaoCardinal;
    }

    public void setEixoX(int eixoX) {
        this.eixoX = eixoX;
    }

    public void setEixoY(int eixoY) {
        this.eixoY = eixoY;
    }
}
