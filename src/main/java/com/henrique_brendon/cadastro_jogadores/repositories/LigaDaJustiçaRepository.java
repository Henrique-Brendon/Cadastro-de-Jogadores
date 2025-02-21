package com.henrique_brendon.cadastro_jogadores.repositories;


import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClient;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.henrique_brendon.cadastro_jogadores.dtos.CodinomeDTO;
import com.henrique_brendon.cadastro_jogadores.dtos.LigaDaJusticaDTO;
import com.henrique_brendon.cadastro_jogadores.entities.enums.GrupoCodinome;

@Repository
public class LigaDaJustiçaRepository implements CodinomeRepository {

    @Override
    public CodinomeDTO buscarCodinomes() throws Exception {
        var codinomes = RestClient.builder()
            .baseUrl(GrupoCodinome.LIGA_DA_JUSTICA.getUri())
            .build()
            .get()
            .retrieve()
            .body(String.class);

        var xmlMapper = new XmlMapper();
        var ligaDaJustica = xmlMapper.readValue(codinomes, LigaDaJusticaDTO.class);
        return ligaDaJustica;
    }

} 
