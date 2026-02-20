# Consulta Tabela FIPE - Java Spring

Este projeto é uma ferramenta de linha de comando desenvolvida como desafio prático de **Java: trabalhando com lambdas, streams e Spring Framework**. A aplicação consome a API pública da Tabela FIPE para fornecer preços médios de veículos brasileiros de forma rápida e organizada.

## Objetivo
O foco principal é consolidar conhecimentos em:
* **Consumo de APIs REST** (HttpClient).
* **Desserialização de JSON**, com a biblioteca Jackson.
* **Java Streams e Lambdas**, para filtragem e manipulação de dados.
* **Modelagem de dados**, seguindo os princípios de Programação Orientada a Objetos.

---

## Funcionalidades
A aplicação guia o usuário através de um fluxo interativo no console:

1.  **Escolha de Categoria:** Selecione entre Carros, Motos ou Caminhões.
2.  **Seleção de Marca:** Escolha a marca desejada a partir de uma lista gerada em tempo real.
3.  **Busca de Modelo:** Digite um trecho do nome do veículo para filtrar os modelos disponíveis.
4.  **Histórico de Preços:** A aplicação percorre todos os anos disponíveis para o modelo escolhido e exibe uma lista comparativa de valores.

---

## Tecnologias Utilizadas
* **Java 21**
* **Spring Boot:** Estrutura base do projeto
* **Jackson:** Para o mapeamento dos dados JSON
* **API FIPE:** Serviço gratuito de consulta (HTTP REST)

---

## 🔗 Estrutura da API
A aplicação utiliza os seguintes endpoints base:
* `https://parallelum.com.br/fipe/api/v1/carros/marcas`
* `https://parallelum.com.br/fipe/api/v1/carros/marcas/{COD_MARCA}/modelos`
* `https://parallelum.com.br/fipe/api/v1/carros/marcas/{COD_MARCA}/modelos/{COD_MODELO}/anos`

---
Desenvolvido como parte do aprendizado em Java.
