package br.com.mars.sonda.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MovimentacaoNorteTest {

    private MovimentacaoNorte movimentacaoNorte;

    @Before
    public void setUp() {
        movimentacaoNorte = new MovimentacaoNorte();
    }

    @Test
    public void deveRetornarNovaPosicaoComUmaPosicaoAMaisNaDirecaoNorte() {
        Posicao posicao = new Posicao(10, 10);
        Posicao posicaoEsperada = new Posicao(10, 11);
        Posicao novaPosicao = movimentacaoNorte.mover(posicao);

        assertEquals(posicaoEsperada, novaPosicao);
    }
}