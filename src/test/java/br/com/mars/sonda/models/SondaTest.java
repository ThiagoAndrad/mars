package br.com.mars.sonda.models;

import br.com.mars.sonda.viewModel.Planalto;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SondaTest {

    private Sonda sonda;

    @Before
    public void setUp() throws Exception {
        Posicao posicao = new Posicao(0, 0);
        Planalto planalto = new Planalto(posicao);
        sonda = new Sonda(DirecaoCardinal.N, posicao, planalto);
    }

    @Test
    public void aoVirarADireitaPosicionaASondaParaADirecaoConformeARosaDosVentos() {
        sonda.virarADireita();
        DirecaoCardinal direcaoCardinal = sonda.getDirecaoCardinal();
        assertEquals(DirecaoCardinal.E, direcaoCardinal);

        sonda.virarADireita();
        direcaoCardinal = sonda.getDirecaoCardinal();
        assertEquals(DirecaoCardinal.S, direcaoCardinal);

        sonda.virarADireita();
        direcaoCardinal = sonda.getDirecaoCardinal();
        assertEquals(DirecaoCardinal.W, direcaoCardinal);

        sonda.virarADireita();
        direcaoCardinal = sonda.getDirecaoCardinal();
        assertEquals(DirecaoCardinal.N, direcaoCardinal);

    }

    @Test
    public void aoVirarAEsquerdaPosicionaASondaConformeARosaDosVentos() {
        sonda.virarAEsquerda();
        DirecaoCardinal direcaoCardinal = sonda.getDirecaoCardinal();
        assertEquals(DirecaoCardinal.W, direcaoCardinal);

        sonda.virarAEsquerda();
        direcaoCardinal = sonda.getDirecaoCardinal();
        assertEquals(DirecaoCardinal.S, direcaoCardinal);

        sonda.virarAEsquerda();
        direcaoCardinal = sonda.getDirecaoCardinal();
        assertEquals(DirecaoCardinal.E, direcaoCardinal);

        sonda.virarAEsquerda();
        direcaoCardinal = sonda.getDirecaoCardinal();
        assertEquals(DirecaoCardinal.N, direcaoCardinal);

    }

    @Test
    public void aoMoverUmaSondaViradaAoNorteDeveMoverUmaPosicaoAoNorte() {
        Posicao posicaoPlanalto = new Posicao(10, 10);
        Planalto planalto = new Planalto(posicaoPlanalto);
        Posicao posicaoSonda = new Posicao(5, 5);
        Sonda sondaNorte = new Sonda(DirecaoCardinal.N, posicaoSonda, planalto);

        sondaNorte.mover();

        Posicao posicaoEsperada = new Posicao(5, 6);
        assertEquals(posicaoEsperada, sondaNorte.getPosicao());
    }
}