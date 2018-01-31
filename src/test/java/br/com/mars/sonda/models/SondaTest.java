package br.com.mars.sonda.models;

import br.com.mars.sonda.viewModel.Planalto;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static br.com.mars.sonda.models.Comando.*;
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

    @Test
    public void aoMoverUmaSondaViradaAoLesteDeveMoverUmaPosicaoAoLeste() {
        Posicao posicaoPlanalto = new Posicao(10, 10);
        Planalto planalto = new Planalto(posicaoPlanalto);
        Posicao posicaoSonda = new Posicao(5, 5);
        Sonda sondaLeste = new Sonda(DirecaoCardinal.E, posicaoSonda, planalto);

        sondaLeste.mover();

        Posicao posicaoEsperada = new Posicao(6, 5);
        assertEquals(posicaoEsperada, sondaLeste.getPosicao());
    }

    @Test
    public void aoMoverUmaSondaViradaAoSulDeveMoverUmaPosicaoAoSul() {
        Posicao posicaoPlanalto = new Posicao(10, 10);
        Planalto planalto = new Planalto(posicaoPlanalto);
        Posicao posicaoSonda = new Posicao(5, 5);
        Sonda sondaSul = new Sonda(DirecaoCardinal.S, posicaoSonda, planalto);

        sondaSul.mover();

        Posicao posicaoEsperada = new Posicao(5, 4);
        assertEquals(posicaoEsperada, sondaSul.getPosicao());
    }

    @Test
    public void aoMoverUmaSondaViradaAoOesteDeveMoverUmaPosicaoAoOeste() {
        Posicao posicaoPlanalto = new Posicao(10, 10);
        Planalto planalto = new Planalto(posicaoPlanalto);
        Posicao posicaoSonda = new Posicao(5, 5);
        Sonda sondaOeste = new Sonda(DirecaoCardinal.W, posicaoSonda, planalto);

        sondaOeste.mover();

        Posicao posicaoEsperada = new Posicao(4, 5);
        assertEquals(posicaoEsperada, sondaOeste.getPosicao());
    }

    @Test
    public void aoReceberUmaListaDeComandosAEsquerdaEMoverMovimentaASondaParaPosicao() {
        Posicao posicaoPlanalto = new Posicao(5, 5);
        Planalto planalto = new Planalto(posicaoPlanalto);
        Posicao posicaoSonda = new Posicao(1, 2);

        Sonda sonda = new Sonda(DirecaoCardinal.N, posicaoSonda, planalto);
        List<Comando> comandos = Arrays.asList(L, M, L, M, L, M, L, M, M);

        sonda.mover(comandos);

        Posicao posicaoEsperada = new Posicao(1, 3);
        Sonda sondaEsperada = new Sonda(DirecaoCardinal.N, posicaoEsperada, planalto);

        assertEquals(sondaEsperada, sonda);
    }

    @Test
    public void aoReceberUmaListaDeComandosADireitaEMoverMovimentaASondaParaPosicao() {
        Posicao posicaoPlanalto = new Posicao(5, 5);
        Planalto planalto = new Planalto(posicaoPlanalto);
        Posicao posicaoSonda = new Posicao(3, 3);

        Sonda sonda = new Sonda(DirecaoCardinal.E, posicaoSonda, planalto);
        List<Comando> comandos = Arrays.asList(M, M, R, M, M, R, M, R, R, M);

        sonda.mover(comandos);

        Posicao posicaoEsperada = new Posicao(5, 1);
        Sonda sondaEsperada = new Sonda(DirecaoCardinal.E, posicaoEsperada, planalto);

        assertEquals(sondaEsperada, sonda);
    }
}