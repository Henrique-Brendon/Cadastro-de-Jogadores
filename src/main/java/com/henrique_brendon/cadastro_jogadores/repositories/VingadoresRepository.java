package com.henrique_brendon.cadastro_jogadores.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClient;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.henrique_brendon.cadastro_jogadores.dtos.CodinomeDTO;
import com.henrique_brendon.cadastro_jogadores.dtos.VingadoresDTO;
import com.henrique_brendon.cadastro_jogadores.entities.enums.GrupoCodinome;

@Repository
public class VingadoresRepository implements CodinomeRepository{

    @Override
    public CodinomeDTO buscarCodinomes() throws Exception{
        var codenomes = RestClient
            .builder()
            .baseUrl(GrupoCodinome.VINGADORES.getUri())
            .build()
            .get()
            .retrieve()
            .body(String.class);
        
        var objectMapper = new ObjectMapper();
        var vingadores = objectMapper.readValue(codenomes, VingadoresDTO.class);
        
        return vingadores;
    }

}
