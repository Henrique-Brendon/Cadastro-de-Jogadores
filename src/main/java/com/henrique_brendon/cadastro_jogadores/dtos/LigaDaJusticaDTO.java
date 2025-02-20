package com.henrique_brendon.cadastro_jogadores.dtos;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "liga_da_justica")
public record LigaDaJusticaDTO(
    @JacksonXmlProperty(localName = "codinomes") CodinomesDTO codinomnes
) implements CodinomeDTO{

    @Override
    public List<String> getCodinomes() {
        return codinomnes.codinomes();
    }
    
}

record CodinomesDTO(
    @JacksonXmlElementWrapper(useWrapping = false) @JacksonXmlProperty(localName = "codinome") List<String> codinomes
) {
    
}
