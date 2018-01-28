package br.com.mars.sonda.viewModel;

import br.com.mars.sonda.models.DirecaoCardinal;
import br.com.mars.sonda.models.Posicao;
import br.com.mars.sonda.models.Sonda;
import org.junit.Assert;
import org.junit.Test;

public class SondaViewModelTest {

    @Test
    public void deveInstanciarUmSondaComADirecaoECoordenadas() {
        DirecaoCardinal norte = DirecaoCardinal.N;
        int eixoX = 10;
        int eixoY = 10;
        SondaViewModel sondaViewModel = new SondaViewModel(norte, eixoX, eixoY);
        Sonda sondaEsperada = new Sonda(norte, new Posicao(eixoX, eixoY));

        Sonda sonda = sondaViewModel.toSonda();

        Assert.assertEquals(sondaEsperada, sonda);
    }
}