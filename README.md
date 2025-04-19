# 🎮 Cadastro de Jogadores com Codinomes

Este projeto é uma aplicação web em Java utilizando **Spring Boot** que permite o cadastro de jogadores com a atribuição automática de codinomes a partir de dois grupos: **Vingadores** e **Liga da Justiça**. Os codinomes são obtidos de APIs externas.

---

## 📚 Sumário

- [💡 Objetivo](#💡-objetivo)
- [🚀 Tecnologias Utilizadas](#🚀-tecnologias-utilizadas)
- [📦 Dependências](#📦-dependências)
- [📐 Arquitetura](#📐-arquitetura)
- [🔧 Como Rodar o Projeto](#🔧-como-rodar-o-projeto)
- [🧪 Funcionalidades](#🧪-funcionalidades)
- [🧪 Testes de Integração](#🧪-testes-de-integração)
- [📦 Estrutura do Projeto](#📦-estrutura-do-projeto)
- [📄 Licença](#📄-licença)

---

## 💡 Objetivo

Permitir o cadastro de jogadores com nome, e-mail e telefone, onde cada jogador é automaticamente associado a um **codinome único**, proveniente de um dos dois grupos:

- **Vingadores** (formato JSON)
- **Liga da Justiça** (formato XML)

Se todos os codinomes do grupo selecionado estiverem em uso, uma exceção é lançada impedindo o cadastro.

---

## 🚀 Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring MVC
- Spring Validation
- Spring Cache (Redis)
- Thymeleaf
- Jackson (JSON & XML)
- Banco de Dados H2
- JUnit + Spring Test + MockMvc

---

## 📦 Dependências

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-jdbc</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <scope>runtime</scope>
    <optional>true</optional>
</dependency>
<dependency>
    <groupId>com.fasterxml.jackson.dataformat</groupId>
    <artifactId>jackson-dataformat-xml</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-cache</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <scope>runtime</scope>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
</dependency>
```

## 📐 Arquitetura
O sistema segue uma arquitetura baseada em MVC com o uso dos padrões:

Factory Pattern para escolha do repositório correto conforme o grupo de codinomes.

DTOs para tratar e padronizar as respostas das APIs externas.

Service Layer para abstração da lógica de negócios.

## 🔧 Como Rodar o Projeto
Clone o repositório: git@github.com:Henrique-Brendon/Cadastro-de-Jogadores.git

Configure as URLs das APIs dos codinomes no enum GrupoCodinome.

Rode o projeto com Maven:
./mvnw spring-boot:run

Acesse no navegador:
http://localhost:8080/cadastro-jogador

## 🧪 Funcionalidades
* ✅ Cadastro de jogadores com validação de dados.

* ✅ Sorteio automático de codinomes.

* ✅ Escolha entre grupo Vingadores ou Liga da Justiça.

* ✅ Listagem de todos os jogadores cadastrados.

* ✅ Integração com APIs externas em JSON e XML.

* ✅ Tratamento de exceções quando codinomes estão esgotados.

## 🧪 Testes de Integração
A classe CadastroJogadoresIT cobre os principais fluxos:

* ✅ Cadastro e redirecionamento com dados válidos

* ✅ Listagem sem registros

* ✅ Cadastro de múltiplos jogadores e verificação da listagem

```xml
    @Test
    void cadastrarListarJogadorSucesso() throws Exception {
        ...
    }

    @Test
    void cadastrarJogadorComDadosInvalidos() throws Exception {
        ...
    }

    @Test
    void cadastrarJogadorSemGrupoCodinome() throws Exception {
        ...
    }

    @Test
    void listarJogadoresSemRegistro() throws Exception {
        ...
    }

    @Test
    void cadastrarMultiplosJogadoresEListar() throws Exception {
        ...
    }
```
## 📦 Estrutura do Projeto

``` xml
src/
├── controller/
│   ├── CadastroJogadorController.java
│   └── ListarJogadoresController.java
├── service/
│   ├── JogadorService.java
│   └── CodinomeService.java
├── repository/
│   ├── CodinomeRepository.java
│   ├── VingadoresRepository.java
│   ├── LigaDaJustiçaRepository.java
│   └── CodinomeRepositoryFactory.java
├── model/
│   ├── Jogador.java
│   └── GrupoCodinome.java
├── dto/
│   ├── VingadoresDTO.java
│   ├── LigaDaJusticaDTO.java
│   └── CodinomesDTO.java
├── templates/
│   ├── cadastro_jogador.html
│   └── listagem_jogadores.html

```

## 📄 Licença

Este projeto está sob a licença MIT.  
Sinta-se livre para usar, modificar e compartilhar.

> Projeto desenvolvido com base no vídeo da professora [Giuliana Bezerra](https://www.youtube.com/watch?v=SovNeqEQXD8) no YouTube.
