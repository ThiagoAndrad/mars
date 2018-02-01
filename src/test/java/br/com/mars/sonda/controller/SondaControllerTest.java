package br.com.mars.sonda.controller;

import br.com.mars.sonda.models.Comando;
import br.com.mars.sonda.models.DirecaoCardinal;
import br.com.mars.sonda.models.Posicao;
import br.com.mars.sonda.models.Sonda;
import br.com.mars.sonda.session.ClienteSession;
import br.com.mars.sonda.viewModel.Planalto;
import org.json.JSONArray;
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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Optional;

import static br.com.mars.sonda.models.Comando.L;
import static br.com.mars.sonda.models.Comando.M;
import static br.com.mars.sonda.models.Comando.R;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
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

        int eixoX = 10;
        int eixoY = 11;
        String json = new JSONObject()
                .put("eixoX", eixoX)
                .put("eixoY", eixoY)
                .put("direcaoCardinal", DirecaoCardinal.W)
                .toString();

        Posicao posicao = new Posicao(eixoX, eixoY);
        Planalto planalto = new Planalto(posicao);

        given(clienteSession.getPlanalto()).willReturn(Optional.ofNullable(planalto));


        mvc.perform(post("/sonda")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isAccepted())
                .andExpect(jsonPath("$.direcaoCardinal", is(DirecaoCardinal.W.toString())))
                .andExpect(jsonPath("$.posicao.eixoX", is(eixoX)))
                .andExpect(jsonPath("$.posicao.eixoY", is(eixoY)))
                .andExpect(jsonPath("$.planalto.norteLeste.eixoX", is(eixoX)))
                .andExpect(jsonPath("$.planalto.norteLeste.eixoY", is(eixoY)))
                .andExpect(jsonPath("$.planalto.sulOeste.eixoX", is(0)))
                .andExpect(jsonPath("$.planalto.sulOeste.eixoY", is(0)));
    }

    @Test
    public void naoPermiteCadastrarSondaSeUmaDasCoordenadasEstiveremForaDoPlanalto() throws Exception {
        String json = new JSONObject()
                .put("eixoX", 10)
                .put("eixoY", 10)
                .put("direcaoCardinal", DirecaoCardinal.W)
                .toString();

        Posicao posicao = new Posicao(9,10);
        Planalto planalto = new Planalto(posicao);

        given(clienteSession.getPlanalto()).willReturn(Optional.ofNullable(planalto));


        mvc.perform(post("/sonda")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void naoPermiteCadastrarSondaCasoNaoExistaUmPlanaltoCadastrado() throws Exception {
        String json = new JSONObject()
                .put("eixoX", 10)
                .put("eixoY", 10)
                .put("direcaoCardinal", DirecaoCardinal.W)
                .toString();

        given(clienteSession.getPlanalto()).willReturn(Optional.ofNullable(null));

        mvc.perform(post("/sonda")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void retornaASondaCadastrada() throws Exception {

        Posicao posicao = new Posicao(9,10);
        Planalto planalto = new Planalto(posicao);
        Sonda sonda = new Sonda(DirecaoCardinal.S, new Posicao(9, 9), planalto);
        given(clienteSession.getSonda()).willReturn(Optional.ofNullable(sonda));

        mvc.perform(get("/sonda"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.direcaoCardinal", is(DirecaoCardinal.S.toString())))
                .andExpect(jsonPath("$.posicao.eixoX", is(9)))
                .andExpect(jsonPath("$.posicao.eixoY", is(9)))
                .andExpect(jsonPath("$.planalto.norteLeste.eixoX", is(9)))
                .andExpect(jsonPath("$.planalto.norteLeste.eixoY", is(10)))
                .andExpect(jsonPath("$.planalto.sulOeste.eixoX", is(0)))
                .andExpect(jsonPath("$.planalto.sulOeste.eixoY", is(0)));
    }

    @Test
    public void retorna404CasoNaoEncontreASonda() throws Exception {
        given(clienteSession.getSonda()).willReturn(Optional.ofNullable(null));

        mvc.perform(get("/sonda"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void movimentaSondaNoPlano() throws Exception {

        Posicao posicao = new Posicao(9,10);
        Planalto planalto = new Planalto(posicao);
        Sonda sonda = new Sonda(DirecaoCardinal.N, new Posicao(5, 5), planalto);

        given(clienteSession.getSonda()).willReturn(Optional.ofNullable(sonda));

        JSONArray comandos = new JSONArray()
                .put(M)
                .put(R)
                .put(M)
                .put(L)
                .put(M);
        String json = new JSONObject()
                .put("comandos", comandos)
                .toString();

        mvc.perform(patch("/sonda")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isAccepted())
                .andExpect(jsonPath("$.direcaoCardinal", is(DirecaoCardinal.N.toString())))
                .andExpect(jsonPath("$.posicao.eixoX", is(6)))
                .andExpect(jsonPath("$.posicao.eixoY", is(7)))
                .andExpect(jsonPath("$.planalto.norteLeste.eixoX", is(9)))
                .andExpect(jsonPath("$.planalto.norteLeste.eixoY", is(10)))
                .andExpect(jsonPath("$.planalto.sulOeste.eixoX", is(0)))
                .andExpect(jsonPath("$.planalto.sulOeste.eixoY", is(0)));
    }

    @Test
    public void naoTentaMovimentarSondaCasoNaoTenhaComandos() throws Exception {

        String json = new JSONObject()
                .put("comandos", new JSONArray())
                .toString();

        mvc.perform(patch("/sonda")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void naoMovimentaSondaSeNaoEncontrarSonda() throws Exception {
        given(clienteSession.getSonda()).willReturn(Optional.ofNullable(null));

        JSONArray comandos = new JSONArray()
                .put(L)
                .put(M);
        String json = new JSONObject()
                .put("comandos", comandos)
                .toString();

        mvc.perform(patch("/sonda")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isBadRequest());
    }
}