package br.com.mars.sonda.viewModel;

import br.com.mars.sonda.models.Posicao;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlanaltoViewModelTest {

    @Test
    public void deveInstanciarUmComAsPosicoesEspecificadasNoViewModel() {
        int eixoX = 10;
        int eixoY = 11;
        PlanaltoViewModel planaltoViewModel = new PlanaltoViewModel(10, 11);
        Planalto planaltoEsperado = new Planalto(new Posicao(eixoX, eixoY));

        Planalto planalto = planaltoViewModel.toPlanalto();

        assertEquals(planaltoEsperado, planalto);
    }
}