package com.henrique_brendon.cadastro_jogadores.repositories;

import java.util.List;


import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClient;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.henrique_brendon.cadastro_jogadores.dtos.VingadoresDTO;
import com.henrique_brendon.cadastro_jogadores.entities.enums.GrupoCodinome;

@Repository
public class VingadoresRepository implements CodinomeRepository{

    @Override
    public List<String> buscarCodinomes() throws Exception{
        var codenomes = RestClient
            .builder()
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .defaultHeader(HttpHeaders.ACCEPT, MediaType.TEXT_PLAIN_VALUE)
            .baseUrl(GrupoCodinome.VINGADORES.getUri())
            .build()
            .get()
            .retrieve()
            .body(String.class);
        
        var objectMapper = new ObjectMapper();
        var vingadores = objectMapper.readValue(codenomes, VingadoresDTO.class);
        
        return vingadores.getCodinomes();
    }

}
