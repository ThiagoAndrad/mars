package br.com.mars.sonda.validator;


import br.com.mars.sonda.models.Posicao;
import br.com.mars.sonda.session.ClienteSession;
import br.com.mars.sonda.viewModel.Planalto;
import br.com.mars.sonda.viewModel.SondaViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.context.WebApplicationContext;

import java.util.Optional;

@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class SondaViewModelValidator implements Validator {

    @Autowired
    private ClienteSession clienteSession;


    @Override
    public boolean supports(Class<?> clazz) {
        return SondaViewModel.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object obj, Errors errors) {

        Optional<Planalto> possivelPlanalto = clienteSession.getPlanalto();
        if (possivelPlanalto.isPresent()) {
            SondaViewModel sondaViewModel = (SondaViewModel)obj;
            Posicao posicao = sondaViewModel.getPosicao();
            if (posicao.isMaiorQue(possivelPlanalto.get().getNorteLeste()))
                errors.reject("posicao incompativel com planalto");

        } else errors.reject("planalto ainda nao cadastrado");
    }
}
