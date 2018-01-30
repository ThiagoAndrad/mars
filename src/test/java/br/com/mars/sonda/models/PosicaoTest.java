package br.com.mars.sonda.models;

import org.junit.Test;

import static org.junit.Assert.*;

public class PosicaoTest {

    @Test
    public void seEixosDasPosicoesForemIguaisAosOutrosEixosDevolveFalse() {
        Posicao posicao = new Posicao(10, 10);
        Posicao outraPosicao = new Posicao(10, 10);

        boolean maior = posicao.isMaiorQue(outraPosicao);

        assertFalse(maior);
    }

    @Test
    public void seEixoXDaPosicaoForMaiorQueOOutroExixoXDevolveTrue() {
        Posicao posicao = new Posicao(11, 10);
        Posicao outraPosicao = new Posicao(10, 10);

        boolean maior = posicao.isMaiorQue(outraPosicao);

        assertTrue(maior);
    }

    @Test
    public void seEixoYDaPosicaoForMaiorQueOOutroExixoYDevolveTrue() {
        Posicao posicao = new Posicao(10, 11);
        Posicao outraPosicao = new Posicao(10, 10);

        boolean maior = posicao.isMaiorQue(outraPosicao);

        assertTrue(maior);
    }

    @Test
    public void seEixoXEEixoYDaPosicaoForemMaioresQueOsOutrosExixoXEYDevolveTrue() {
        Posicao posicao = new Posicao(11, 11);
        Posicao outraPosicao = new Posicao(10, 10);

        boolean maior = posicao.isMaiorQue(outraPosicao);

        assertTrue(maior);
    }

    @Test
    public void seEixoXEEixoYDaPosicaoForemMenoresQueOsOutrosExixoXEYDevolveFalse() {
        Posicao posicao = new Posicao(9, 9);
        Posicao outraPosicao = new Posicao(10, 10);

        boolean maior = posicao.isMaiorQue(outraPosicao);

        assertFalse(maior);
    }
}