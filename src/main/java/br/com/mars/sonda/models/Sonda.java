package br.com.mars.sonda.models;

import br.com.mars.sonda.viewModel.Planalto;

import java.util.List;
import java.util.Objects;

public class Sonda {
    private DirecaoCardinal direcaoCardinal;
    private Posicao posicao;
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

    public void virarADireita() {
        direcaoCardinal = direcaoCardinal.getPontoADireita();
    }

    public void virarAEsquerda() {
        direcaoCardinal = direcaoCardinal.getPontoAEsquerda();
    }

    public void mover() {
        RegraDeMovimentacao regraDeMovimentacao = direcaoCardinal.getRegraDeMovimentacao();
        this.posicao = regraDeMovimentacao.mover(posicao);
    }

    public void mover(List<Comando> comandos) {
        comandos.forEach(c -> c.executa(this));
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
