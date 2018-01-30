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

    }
}