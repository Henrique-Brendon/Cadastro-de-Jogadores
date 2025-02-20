package com.henrique_brendon.cadastro_jogadores.repositories;

import java.util.List;

import org.springframework.web.client.RestClient;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.henrique_brendon.cadastro_jogadores.dtos.LigaDaJusticaDTO;
import com.henrique_brendon.cadastro_jogadores.entities.enums.GrupoCodinome;

public class LigaDaJustiçaRepository implements CodinomeRepository {

    @Override
    public List<String> buscarCodinomes() throws Exception {
        var codinomes = RestClient.builder()
            .baseUrl(GrupoCodinome.LIGA_DA_JUSTICA.getUri())
            .build()
            .get()
            .retrieve()
            .body(String.class);

        var xmlMapper = new XmlMapper();
        var ligaDaJustica = xmlMapper.readValue(codinomes, LigaDaJusticaDTO.class);
        return ligaDaJustica.getCodinomes();
    }

} 
