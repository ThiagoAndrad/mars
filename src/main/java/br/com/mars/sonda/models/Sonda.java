package br.com.mars.sonda.models;

import br.com.mars.sonda.viewModel.Planalto;

import java.util.Objects;

public class Sonda {
    private final DirecaoCardinal direcaoCardinal;
    private final Posicao posicao;
    private final Planalto planalto;

    public Sonda(DirecaoCardinal direcaoCardinal, Posicao posicao, Planalto planalto) {

        this.direcaoCardinal = direcaoCardinal;
        this.posicao = posicao;
        this.planalto = planalto;
    }

    public DirecaoCardinal getDirecaoCardinal() {
        return direcaoCardinal;
    }

    public Posicao getPosicao() {
        return posicao;
    }

    public Planalto getPlanalto() {
        return planalto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sonda)) return false;
        Sonda sonda = (Sonda) o;
        return direcaoCardinal == sonda.direcaoCardinal &&
                Objects.equals(posicao, sonda.posicao) &&
                Objects.equals(planalto, sonda.planalto);
    }

    @Override
    public int hashCode() {

        return Objects.hash(direcaoCardinal, posicao, planalto);
    }
}
