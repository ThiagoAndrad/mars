package br.com.mars.sonda.session;

import br.com.mars.sonda.models.Sonda;
import br.com.mars.sonda.viewModel.Planalto;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.Optional;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION)
public class ClienteSession {


    private Sonda sonda;
    private Planalto planalto;

    public void adiciona(Sonda sonda) {
        this.sonda = sonda;
    }

    public void adiciona(Planalto planalto) {
        this.planalto = planalto;
    }

    public Optional<Planalto> getPlanalto() {
        return Optional.ofNullable(planalto);
    }

    public Sonda getSonda() {
        return sonda;
    }
}
