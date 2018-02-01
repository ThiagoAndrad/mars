package br.com.mars.sonda.service;

import br.com.mars.sonda.models.DirecaoCardinal;
import br.com.mars.sonda.models.Posicao;
import br.com.mars.sonda.models.Sonda;
import br.com.mars.sonda.session.ClienteSession;
import br.com.mars.sonda.viewModel.Planalto;
import br.com.mars.sonda.viewModel.SondaViewModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SondaServiceTest {

    private @Mock ClienteSession clienteSession;

    private @Mock Sonda sonda;

    @Test
    public void deveAdicionarSondaCasoExistaUmPlanaltoCadastrado() {
        SondaService sondaService = new SondaService(clienteSession);
        SondaViewModel sondaViewModel = new SondaViewModel(DirecaoCardinal.E, 10, 10);
        Posicao posicao = new Posicao(10, 10);

        when(clienteSession.getPlanalto()).thenReturn(Optional.of(new Planalto(posicao)));
        sondaService.registra(sondaViewModel);
        verify(clienteSession).adiciona(any(Sonda.class));

    }

    @Test
    public void deveInvocarMetodoParaMovimentarSonda() {
        SondaService sondaService = new SondaService(clienteSession);
        Posicao posicao = new Posicao(10, 10);

        when(clienteSession.getSonda()).thenReturn(Optional.of(sonda));
        sondaService.movimenta(new ArrayList<>());
        verify(sonda).mover(any(ArrayList.class));
    }
}