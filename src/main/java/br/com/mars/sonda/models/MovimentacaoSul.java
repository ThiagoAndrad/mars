package br.com.mars.sonda.models;

public class MovimentacaoSul implements RegraDeMovimentacao {
    @Override
    public Posicao mover(Posicao posicao) {
        return new Posicao(posicao.getEixoX(), posicao.getEixoY() + - 1);
    }
}
