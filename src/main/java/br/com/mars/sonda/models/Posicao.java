package br.com.mars.sonda.models;

import java.util.Objects;

public class Posicao {
    private final int eixoX;
    private final int eixoY;

    public Posicao(int eixoX, int eixoY) {
        this.eixoX = eixoX;
        this.eixoY = eixoY;
    }

    public int getEixoX() {
        return eixoX;
    }

    public int getEixoY() {
        return eixoY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Posicao)) return false;
        Posicao posicao = (Posicao) o;
        return eixoX == posicao.eixoX &&
                eixoY == posicao.eixoY;
    }

    @Override
    public int hashCode() {

        return Objects.hash(eixoX, eixoY);
    }

    public boolean isMaiorQue(Posicao outraPosicao) {
        return this.eixoX > outraPosicao.getEixoX() || this.eixoY > outraPosicao.getEixoY();
    }
}
