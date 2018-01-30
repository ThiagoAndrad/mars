package br.com.mars.sonda.service;

import br.com.mars.sonda.models.Sonda;
import br.com.mars.sonda.session.ClienteSession;
import br.com.mars.sonda.viewModel.Planalto;
import br.com.mars.sonda.viewModel.SondaViewModel;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import java.util.Optional;

@Service
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class SondaService {

    private ClienteSession clienteSession;

    public SondaService(ClienteSession clienteSession) {
        this.clienteSession = clienteSession;
    }

    public ResponseEntity<?> registra(SondaViewModel sondaViewModel) {

        Optional<Planalto> possivelPlanalto = clienteSession.getPlanalto();
        if (possivelPlanalto.isPresent()) {
            Sonda sonda = getSonda(sondaViewModel, possivelPlanalto.get());
            clienteSession.adiciona(sonda);
            return ResponseEntity.status(HttpStatus.CREATED).body(sonda);
        }

        return ResponseEntity.badRequest().build();
    }

    private Sonda getSonda(SondaViewModel sondaViewModel, Planalto planalto) {
        return new Sonda(sondaViewModel.getDirecaoCardinal(), sondaViewModel.getPosicao(), planalto);
    }
}
