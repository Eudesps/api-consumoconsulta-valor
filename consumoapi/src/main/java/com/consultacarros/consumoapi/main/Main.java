package com.consultacarros.consumoapi.main;

import com.consultacarros.consumoapi.models.Marca;
import com.consultacarros.consumoapi.service.ConsumoAPI;
import com.consultacarros.consumoapi.service.ConverteDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private final String ENDERECO = "https://parallelum.com.br/fipe/api/v1/";

    Scanner scanner = new Scanner(System.in);
    ConsumoAPI consumoAPI = new ConsumoAPI();
    private  ConverteDados converte = new ConverteDados();

    public void exibirMenu(){

        System.out.println("******************************** \n" +
                "INFORMAÇÕES SOBRE O PREÇO MÉDIO DE AUTOMÓVEIS \n" +
                "*** Escolha o se é \"carros\", \"motos\" ou \"caminhoes\" ***");

        var tipoAutomovel = scanner.next().toLowerCase();

        String json = consumoAPI.obterDados(ENDERECO + tipoAutomovel + "/marcas/");


        List<Marca> marcas = converte.converteLista(json, Marca.class);
        System.out.println(marcas);


    }
}
