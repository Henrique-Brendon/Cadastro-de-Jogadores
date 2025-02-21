package com.henrique_brendon.cadastro_jogadores.entities;

import org.springframework.validation.annotation.Validated;

import com.henrique_brendon.cadastro_jogadores.entities.enums.GrupoCodinome;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Validated
public record Jogador(
    @NotBlank String nome,
    @NotBlank @Email String email,
    String telefone,
    String codinome,
    @NotNull GrupoCodinome grupoCodinome
) {
    
}
