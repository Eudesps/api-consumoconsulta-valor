package com.consultacarros.consumoapi.main;

import com.consultacarros.consumoapi.service.ConsumoAPI;

import java.util.Scanner;

public class Main {
    private final String ENDERECO = "https://parallelum.com.br/fipe/api/v1/";

    Scanner scanner = new Scanner(System.in);
    ConsumoAPI consumoAPI = new ConsumoAPI();

    public void exibirMenu(){

        System.out.println("******************************** \n" +
                "INFORMAÇÕES SOBRE O PREÇO MÉDIO DE AUTOMÓVEIS \n" +
                "*** Escolha o se é \"carros\", \"motos\" ou \"caminhoes\" ***");

        var tipoAutomovel = scanner.next().toLowerCase();

        String json = consumoAPI.obterDados(ENDERECO + tipoAutomovel + "/marcas/");

        System.out.println(json);


    }
}
