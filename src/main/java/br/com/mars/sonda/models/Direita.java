package br.com.mars.sonda.models;

public class Direita implements Movimentavel {
    @Override
    public void executa(Sonda sonda) {
        sonda.virarADireita();
    }
}
