package br.com.mars.sonda.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MovimentacaoSulTest {

    private MovimentacaoSul movimentacaoSul;

    @Before
    public void setUp() {
        movimentacaoSul = new MovimentacaoSul();
    }

    @Test
    public void deveRetornarNovaPosicaoComUmaPosicaoAMaisNaDirecaoSul() {
        Posicao posicao = new Posicao(10, 10);
        Posicao posicaoEsperada = new Posicao(10, 9);
        Posicao novaPosicao = movimentacaoSul.mover(posicao);

        assertEquals(posicaoEsperada, novaPosicao);
    }


}