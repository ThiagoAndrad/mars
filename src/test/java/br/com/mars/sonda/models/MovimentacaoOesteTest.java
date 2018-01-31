package br.com.mars.sonda.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MovimentacaoOesteTest {

    private MovimentacaoOeste movimentacaoOeste;

    @Before
    public void setUp() {
        movimentacaoOeste = new MovimentacaoOeste();
    }

    @Test
    public void deveRetornarNovaPosicaoComUmaPosicaoAMaisNaDirecaoNorte() {
        Posicao posicao = new Posicao(10, 10);
        Posicao posicaoEsperada = new Posicao(9, 10);
        Posicao novaPosicao = movimentacaoOeste.mover(posicao);

        assertEquals(posicaoEsperada, novaPosicao);
    }


}