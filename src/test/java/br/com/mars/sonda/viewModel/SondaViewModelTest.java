package br.com.mars.sonda.viewModel;

import br.com.mars.sonda.models.DirecaoCardinal;
import br.com.mars.sonda.models.Posicao;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SondaViewModelTest {

    @Test
    public void deveRetornarUmaPosicaoBaseadoNasCoordenadas() {
        int eixoX = 10;
        int eixoY = 10;
        SondaViewModel sondaViewModel = new SondaViewModel(DirecaoCardinal.N, eixoX, eixoY);
        Posicao posicaoEsperada = new Posicao(eixoX, eixoY);

        Posicao posicao = sondaViewModel.getPosicao();

        assertEquals(posicaoEsperada, posicao);
    }
}