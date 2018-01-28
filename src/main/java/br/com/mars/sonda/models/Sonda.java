package br.com.mars.sonda.models;

import java.util.Objects;

public class Sonda {
    private final DirecaoCardinal direcaoCardinal;
    private final Posicao posicao;

    public Sonda(DirecaoCardinal direcaoCardinal, Posicao posicao) {

        this.direcaoCardinal = direcaoCardinal;
        this.posicao = posicao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sonda)) return false;
        Sonda sonda = (Sonda) o;
        return direcaoCardinal == sonda.direcaoCardinal &&
                Objects.equals(posicao, sonda.posicao);
    }

    @Override
    public int hashCode() {

        return Objects.hash(direcaoCardinal, posicao);
    }
}
