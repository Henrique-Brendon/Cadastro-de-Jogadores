package com.henrique_brendon.cadastro_jogadores.entities.enums;
// strategy Pattern
public enum GrupoCodinome {
    VINGADORES("Vingadores", 
        "https://raw.githubusercontent.com/uolhost/test-backEnd-Java/master/referencias/vingadores.json"),
    LIGA_DA_JUSTICA("Liga da Justiça",
        "https://raw.githubusercontent.com/uolhost/test-backEnd-Java/master/referencias/liga_da_justica.xml");
    
    private final String nome;
    private final String uri;

    GrupoCodinome(String nome, String uri) {
        this.nome = nome;
        this.uri = uri;
    }

    public String getNome() {
        return nome;
    }

    public String getUri() {
        return uri;
    }
    
}
