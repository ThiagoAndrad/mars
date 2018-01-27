package br.com.mars.sonda.models;

public class Sonda {
    private final DirecaoCardinal direcaoCardinal;
    private final Posicao posicao;

    public Sonda(DirecaoCardinal direcaoCardinal, Posicao posicao) {

        this.direcaoCardinal = direcaoCardinal;
        this.posicao = posicao;
    }
}
