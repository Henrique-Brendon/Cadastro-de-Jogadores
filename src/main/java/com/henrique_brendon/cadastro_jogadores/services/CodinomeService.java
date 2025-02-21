package com.henrique_brendon.cadastro_jogadores.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.henrique_brendon.cadastro_jogadores.entities.enums.GrupoCodinome;

@Service
public class CodinomeService {
    
    private final CodinomeRepositoryFactory codinomeRepositoryFactory;

    public CodinomeService(CodinomeRepositoryFactory codinomeRepositoryFactory) {
        this.codinomeRepositoryFactory = codinomeRepositoryFactory;
    }

    public String gerarCodinome(GrupoCodinome grupoCodinome, List<String> codiNomesEmUso) throws Exception {
        var codinomesDisponiveis = listarCodiNomesDisponiveis(grupoCodinome, codiNomesEmUso);
                if (codinomesDisponiveis.isEmpty()) 
                    throw new Exception("Não há codinomes disponíveis para o grupo " + grupoCodinome);
                
                var codinomeSorteado = sortearCodinome(codinomesDisponiveis);
                return codinomeSorteado;
            }
        
    private List<String> listarCodiNomesDisponiveis(GrupoCodinome grupoCodinome, List<String> codiNomesEmUso) throws Exception {
        var codinomes = buscarCodinomes(grupoCodinome);
        
            var codinomesDisponiveis = codinomes
                .stream()
                .filter(codinome -> !codiNomesEmUso.contains(codinome))
                .toList();
            return codinomesDisponiveis;
        }
        
    private List<String> buscarCodinomes(GrupoCodinome grupoCodinome) throws Exception{
        // Factory Pattern
        var codinomeRepository = codinomeRepositoryFactory.create(grupoCodinome);
        return codinomeRepository.buscarCodinomes().getCodinomes();
    }

    private String sortearCodinome(List<String> codinomesDisponiveis) {
        return codinomesDisponiveis
            .get((int) (Math.random() * codinomesDisponiveis.size()));
    }

}
