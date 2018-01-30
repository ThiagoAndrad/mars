package br.com.mars.sonda.controller;

import br.com.mars.sonda.models.Sonda;
import br.com.mars.sonda.service.SondaService;
import br.com.mars.sonda.session.ClienteSession;
import br.com.mars.sonda.validator.SondaViewModelValidator;
import br.com.mars.sonda.viewModel.SondaViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;

import javax.validation.Valid;

@RestController
@RequestMapping("sonda")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class SondaController {

    private SondaService sondaService;

    private SondaViewModelValidator sondaViewModelValidator;

    private ClienteSession clienteSession;

    private SondaController(SondaService sondaService, SondaViewModelValidator sondaViewModelValidator, ClienteSession clienteSessio) {
        this.sondaService = sondaService;
        this.sondaViewModelValidator = sondaViewModelValidator;
        clienteSession = clienteSessio;
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder){
        binder.addValidators(sondaViewModelValidator);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> registra(@RequestBody @Valid SondaViewModel sondaViewModel, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors()
                    .stream()
                    .map(o -> o.getCode())
                    .toArray());
        }

        return sondaService.registra(sondaViewModel);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Sonda getSonda(){
        return clienteSession.getSonda();
    }
}
