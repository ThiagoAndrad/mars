package br.com.mars.sonda.controller;

import br.com.mars.sonda.viewModel.SondaViewModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sonda")
public class SondaController {

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void registra(@RequestBody SondaViewModel sondaViewModel){
    }
}
