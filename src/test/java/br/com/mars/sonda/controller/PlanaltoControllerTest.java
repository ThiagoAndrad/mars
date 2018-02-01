package br.com.mars.sonda.controller;

import br.com.mars.sonda.models.DirecaoCardinal;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class PlanaltoControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void deveCadastrarUmNovoPlanalto() throws Exception {

        int eixoX = 10;
        int eixoY = 20;
        String json = new JSONObject()
                .put("eixoX", eixoX)
                .put("eixoY", eixoY)
                .put("direcaoCardinal", DirecaoCardinal.W)
                .toString();

        mvc.perform(post("/planalto")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isAccepted())
                .andExpect(jsonPath("$.norteLeste.eixoX", is(eixoX)))
                .andExpect(jsonPath("$.norteLeste.eixoY", is(eixoY)))
                .andExpect(jsonPath("$.sulOeste.eixoX", is(0)))
                .andExpect(jsonPath("$.sulOeste.eixoY", is(0)));
    }

    @Test
    public void retornaErroCasoTesntePassarPosicoesNegativas() throws Exception {
        int eixoX = -1;
        int eixoY = -1;
        String json = new JSONObject()
                .put("eixoX", eixoX)
                .put("eixoY", eixoY)
                .put("direcaoCardinal", DirecaoCardinal.W)
                .toString();

        mvc.perform(post("/planalto")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isBadRequest());
    }
}