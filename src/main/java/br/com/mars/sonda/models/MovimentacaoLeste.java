package br.com.mars.sonda.models;

public class MovimentacaoLeste implements RegraDeMovimentacao {
    @Override
    public Posicao mover(Posicao posicao) {
        return new Posicao(posicao.getEixoX() + 1, posicao.getEixoY());
    }
}
