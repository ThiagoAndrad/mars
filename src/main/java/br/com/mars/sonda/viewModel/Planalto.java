package br.com.mars.sonda.viewModel;

import br.com.mars.sonda.models.Posicao;

import java.util.Objects;

public class Planalto {

    private final Posicao norteLeste;

    private final Posicao sulOeste = new Posicao(0, 0);

    public Planalto(Posicao norteLeste) {
        this.norteLeste = norteLeste;
    }

    public Posicao getNorteLeste() {
        return norteLeste;
    }

    public Posicao getSulOeste() {
        return sulOeste;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Planalto)) return false;
        Planalto planalto = (Planalto) o;
        return Objects.equals(norteLeste, planalto.norteLeste) &&
                Objects.equals(sulOeste, planalto.sulOeste);
    }

    @Override
    public int hashCode() {

        return Objects.hash(norteLeste, sulOeste);
    }
}
