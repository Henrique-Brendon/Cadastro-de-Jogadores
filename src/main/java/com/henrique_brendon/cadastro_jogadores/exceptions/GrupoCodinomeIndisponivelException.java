package com.henrique_brendon.cadastro_jogadores.exceptions;

public class GrupoCodinomeIndisponivelException extends IllegalArgumentException {
    
    private static final long serialVersionUID = 1L;

    public GrupoCodinomeIndisponivelException() {
        super("Não há codinomes disponíveis para o grupo selecionado.");
    }
    
}
