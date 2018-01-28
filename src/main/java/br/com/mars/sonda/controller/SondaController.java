package br.com.mars.sonda.controller;

import br.com.mars.sonda.models.Sonda;
import br.com.mars.sonda.session.ClienteSession;
import br.com.mars.sonda.viewModel.SondaViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

@RestController
@RequestMapping("sonda")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class SondaController {

    @Autowired
    private ClienteSession clienteSession;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void registra(@RequestBody SondaViewModel sondaViewModel){
        Sonda sonda = sondaViewModel.toSonda();
        clienteSession.adiciona(sonda);
    }
}
