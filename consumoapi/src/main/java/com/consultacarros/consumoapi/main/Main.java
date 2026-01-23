package com.consultacarros.consumoapi.main;

import com.consultacarros.consumoapi.models.Automovel;
import com.consultacarros.consumoapi.models.Modelos;
import com.consultacarros.consumoapi.service.ConsumoAPI;
import com.consultacarros.consumoapi.service.ConverteDados;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private final String URL_BASE = "https://parallelum.com.br/fipe/api/v1/";

    Scanner scanner = new Scanner(System.in);
    ConsumoAPI consumoAPI = new ConsumoAPI();
    private  ConverteDados converte = new ConverteDados();

    public void exibirMenu(){

        System.out.println("******************************** \n" +
                "INFORMAÇÕES SOBRE O PREÇO MÉDIO DE AUTOMÓVEIS \n" +
                "*** Escolha o se é \"carros\", \"motos\" ou \"caminhoes\" ***");

        //
        var jsonConsulta = "";
        var tipoAutomovel = scanner.next().toLowerCase();
        jsonConsulta = consumoAPI.obterDados(URL_BASE + tipoAutomovel + "/marcas/");
        List<Automovel> marcas = converte.obterLista(jsonConsulta, Automovel.class );
        marcas.forEach(System.out::println);

        //SEGUNDO PASSO
        System.out.println("Informe o código da marca para consulta: ");
        var codigoMarca = scanner.next();

        jsonConsulta = consumoAPI.obterDados(URL_BASE + tipoAutomovel + "/marcas/" + codigoMarca + "/modelos");

        var automovels = converte.converteDados(jsonConsulta, Modelos.class);
        automovels.modelos().forEach(System.out::println);

        //TERCEIRO PASSO
        System.out.println("Digite o código do modelo desejado: ");
        var codigoModelo = scanner.next();
        jsonConsulta = consumoAPI.obterDados(URL_BASE + tipoAutomovel + "/marcas/" + codigoMarca
                + "/modelos/" + codigoModelo + "/anos");

        var modelos = converte.obterLista(jsonConsulta, Automovel.class);

        modelos.forEach(e -> System.out.println(consumoAPI.obterDados(URL_BASE + tipoAutomovel + "/marcas/" + codigoMarca
                + "/modelos/" + codigoModelo + "/anos/" + e.codigo())));
        //System.out.println(modelos);


    }
}
