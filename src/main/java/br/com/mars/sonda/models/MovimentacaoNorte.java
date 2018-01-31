package br.com.mars.sonda.models;

public class MovimentacaoNorte implements RegraDeMovimentacao {
    @Override
    public Posicao mover(Posicao posicao) {
        return new Posicao(posicao.getEixoX(), posicao.getEixoY() + 1);
    }
}
