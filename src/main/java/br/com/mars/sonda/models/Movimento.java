package br.com.mars.sonda.models;

public class Movimento implements Movimentavel {
    @Override
    public void executa(Sonda sonda) {
        sonda.mover();
    }
}
