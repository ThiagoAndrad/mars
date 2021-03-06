package br.com.mars.sonda.controller;

import br.com.mars.sonda.models.ComandosViewModel;
import br.com.mars.sonda.models.Sonda;
import br.com.mars.sonda.service.SondaService;
import br.com.mars.sonda.session.ClienteSession;
import br.com.mars.sonda.validator.SondaViewModelValidator;
import br.com.mars.sonda.viewModel.SondaViewModel;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;

import javax.validation.Valid;
import java.util.Optional;

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

    @InitBinder("sondaViewModel")
    protected void initBinder(WebDataBinder binder){
        binder.setValidator(sondaViewModelValidator);
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

    @PatchMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> movimenta(@RequestBody @Valid ComandosViewModel comandosViewModel, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }
        return sondaService.movimenta(comandosViewModel.getComandos());
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getSonda() {
        Optional<Sonda> possivelSonda = clienteSession.getSonda();
        if (possivelSonda.isPresent()) {
            Sonda sonda = possivelSonda.get();
            return ResponseEntity.ok(sonda);
        }
        return ResponseEntity.notFound().build();

    }
}
