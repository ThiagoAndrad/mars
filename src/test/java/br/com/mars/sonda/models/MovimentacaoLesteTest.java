package br.com.mars.sonda.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MovimentacaoLesteTest {

    private MovimentacaoLeste movimentacaoLeste;

    @Before
    public void setUp() {
        movimentacaoLeste = new MovimentacaoLeste();
    }

    @Test
    public void deveRetornarNovaPosicaoComUmaPosicaoAMaisNaDirecaoLeste() {
        Posicao posicao = new Posicao(10, 10);
        Posicao posicaoEsperada = new Posicao(11, 10);
        Posicao novaPosicao = movimentacaoLeste.mover(posicao);

        assertEquals(posicaoEsperada, novaPosicao);
    }


}