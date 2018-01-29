package br.com.mars.sonda.controller;

import br.com.mars.sonda.session.ClienteSession;
import br.com.mars.sonda.viewModel.Planalto;
import br.com.mars.sonda.viewModel.PlanaltoViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("planalto")
public class PlanaltoController {

    @Autowired
    private ClienteSession clienteSession;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> registra(@RequestBody @Valid PlanaltoViewModel planaltoViewModel, BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return ResponseEntity.badRequest().build();

        Planalto planalto = planaltoViewModel.toPlanalto();
        clienteSession.adiciona(planalto);
        return ResponseEntity.status(HttpStatus.CREATED).body(planalto);
    }
}
