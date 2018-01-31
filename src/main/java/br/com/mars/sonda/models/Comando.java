package br.com.mars.sonda.models;

public enum Comando {
    L(new Esquerda()),
    R(new Direita()),
    M(new Movimento());

    private Movimentavel movimentavel;

    Comando(Movimentavel movimentavel) {
        this.movimentavel = movimentavel;
    }

    public Movimentavel getMovimentavel() {
        return movimentavel;
    }
}
