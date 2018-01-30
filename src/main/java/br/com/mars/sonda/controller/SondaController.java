package br.com.mars.sonda.controller;

import br.com.mars.sonda.service.SondaService;
import br.com.mars.sonda.viewModel.SondaViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

import javax.validation.Valid;

@RestController
@RequestMapping("sonda")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class SondaController {

    @Autowired
    private SondaService sondaService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> registra(@RequestBody @Valid SondaViewModel sondaViewModel, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }

        return sondaService.registra(sondaViewModel);
    }
}
