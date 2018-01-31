package br.com.mars.sonda.models;

public class Esquerda implements Movimentavel {
    @Override
    public void executa(Sonda sonda) {
        sonda.virarAEsquerda();
    }
}
