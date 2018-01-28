package br.com.mars.sonda.session;

import br.com.mars.sonda.models.Sonda;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION)
public class ClienteSession {


    private Sonda sonda;

    public void adiciona(Sonda sonda) {
        this.sonda = sonda;
    }
}
