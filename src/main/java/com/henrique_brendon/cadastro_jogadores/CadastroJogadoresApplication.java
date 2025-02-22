package com.henrique_brendon.cadastro_jogadores;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CadastroJogadoresApplication {

	public static void main(String[] args) {
		SpringApplication.run(CadastroJogadoresApplication.class, args);
	}

}
