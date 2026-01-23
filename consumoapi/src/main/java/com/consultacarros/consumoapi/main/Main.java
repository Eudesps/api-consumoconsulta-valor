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
        var tipoAutomovel = scanner.next().toLowerCase();
        String jsonMarca = consumoAPI.obterDados(URL_BASE + tipoAutomovel + "/marcas/");
        List<Automovel> marcas = converte.obterLista(jsonMarca, Automovel.class );
        marcas.forEach(System.out::println);

        //SEGUNDO PASSO
        System.out.println("Informe o código da marca para consulta: ");
        var codigoMarca = scanner.next();

        String jsonCodigoMarca = consumoAPI.obterDados(URL_BASE + tipoAutomovel + "/marcas/" + codigoMarca + "/modelos");

       var automovels = converte.converteDados(jsonCodigoMarca, Modelos.class);
       automovels.modelos().forEach(System.out::println);

    }
}
