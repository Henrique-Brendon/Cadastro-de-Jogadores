package com.henrique_brendon.cadastro_jogadores.repositories;

import com.henrique_brendon.cadastro_jogadores.dtos.CodinomeDTO;

public interface CodinomeRepository {
    
    CodinomeDTO buscarCodinomes() throws Exception;

}
