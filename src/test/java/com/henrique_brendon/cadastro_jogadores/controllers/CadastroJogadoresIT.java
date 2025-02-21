package com.henrique_brendon.cadastro_jogadores.controllers;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.hasToString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.henrique_brendon.cadastro_jogadores.entities.Jogador;
import com.henrique_brendon.cadastro_jogadores.entities.enums.GrupoCodinome;

@SpringBootTest
@AutoConfigureMockMvc
public class CadastroJogadoresIT {
    
    @Autowired
    private MockMvc mockMvc;

    @Test
    void cadastrarListarJogadorSucesso() throws Exception {
      var jogador = new Jogador("test", "test@test.com",
          "123456", null, GrupoCodinome.VINGADORES);
  
      mockMvc
          .perform(post("/cadastro-jogador")
              .param("nome", jogador.nome())
              .param("email", jogador.email())
              .param("telefone", jogador.telefone())
              .param("grupoCodinome", jogador.grupoCodinome().name()))
          .andDo(print())
          .andExpect(status().is3xxRedirection())
          .andExpect(redirectedUrl("/listagem-jogadores"));
  
      mockMvc
          .perform(get("/listagem-jogadores"))
          .andDo(print())
          .andExpect(status().isOk())
          .andExpect(view().name("listagem_jogadores"))
          .andExpect(model().attribute("jogadores", hasSize(1)))
          .andExpect(model().attribute("jogadores", contains(allOf(
              hasToString(containsString(jogador.nome())),
              hasToString(containsString(jogador.email())),
              hasToString(containsString(jogador.telefone())),
              hasToString(containsString(jogador.grupoCodinome().name()))))));
    }

    @Test
    void cadastrarJogadorComDadosInvalidos() throws Exception {
        mockMvc
            .perform(post("/cadastro-jogador")
            .param("nome", "")
            .param("email", "")
            .param("telefone", ""))
            .andDo(print())
            .andExpect(status().isOk()) // Permanecer na página de cadastro
            .andExpect(view().name("cadastro_jogador"))
            .andExpect(model().attributeHasErrors("jogador"));
    }

    @Test
    void cadastrarJogadorSemGrupoCodinome() throws Exception {
        mockMvc
            .perform(post("/cadastro-jogador")
            .param("nome", "Jogador teste")
            .param("email", "jogador@teste.com")
            .param("telefone", "999999999"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(view().name("cadastro_jogador"))
            .andExpect(model().attributeHasErrors("jogador"))
            .andExpect(model().attributeHasFieldErrors("jogador", "grupoCodinome"));
    }

    @Test
    void listarJogadoresSemRegistro() throws Exception {
        mockMvc
            .perform(get("/listagem-jogadores"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(view().name("listagem_jogadores"))
            .andExpect(model().attribute("jogadores", hasSize(0)));
    }

    @Test
    void cadastrarMultiplosJogadoresEListar() throws Exception {
        var jogador1 = new Jogador("Jogador 1", "jogador1@test.com", "111111111", null, GrupoCodinome.VINGADORES);
        var jogador2 = new Jogador("Jogador 2", "jogador2@test.com", "222222222", null, GrupoCodinome.LIGA_DA_JUSTICA);

        mockMvc
            .perform(post("/cadastro-jogador")
            .param("nome", jogador1.nome())
            .param("email", jogador1.email())
            .param("telefone", jogador1.telefone())
            .param("grupoCodinome", jogador1.grupoCodinome().name()))
            .andExpect(status().is3xxRedirection());

        mockMvc
            .perform(post("/cadastro-jogador")
            .param("nome", jogador2.nome())
            .param("email", jogador2.email())
            .param("telefone", jogador2.telefone())
            .param("grupoCodinome", jogador2.grupoCodinome().name()))
            .andExpect(status().is3xxRedirection());

        mockMvc
            .perform(get("/listagem-jogadores"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(view().name("listagem_jogadores"))
            .andExpect(model().attribute("jogadores", hasSize(2)));
    }
    
}
