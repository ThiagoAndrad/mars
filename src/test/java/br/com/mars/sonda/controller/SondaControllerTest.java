package br.com.mars.sonda.controller;

import br.com.mars.sonda.models.DirecaoCardinal;
import br.com.mars.sonda.models.Posicao;
import br.com.mars.sonda.session.ClienteSession;
import br.com.mars.sonda.viewModel.Planalto;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class SondaControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ClienteSession clienteSession;

    @Test
    public void deveCadastrarUmaNovaSonda() throws Exception {

        String json = new JSONObject()
                .put("eixoX", 10)
                .put("eixoY", 11)
                .put("direcaoCardinal", DirecaoCardinal.W)
                .toString();

        Posicao posicao = new Posicao(10, 11);
        Planalto planalto = new Planalto(posicao);

        given(clienteSession.getPlanalto()).willReturn(Optional.ofNullable(planalto));


        mvc.perform(post("/sonda")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.direcaoCardinal", is(DirecaoCardinal.W.toString())))
                .andExpect(jsonPath("$.posicao.eixoX", is(10)))
                .andExpect(jsonPath("$.posicao.eixoY", is(11)))
                .andExpect(jsonPath("$.planalto.norteLeste.eixoX", is(10)))
                .andExpect(jsonPath("$.planalto.norteLeste.eixoY", is(11)))
                .andExpect(jsonPath("$.planalto.sulOeste.eixoX", is(0)))
                .andExpect(jsonPath("$.planalto.sulOeste.eixoY", is(0)));

    }
}