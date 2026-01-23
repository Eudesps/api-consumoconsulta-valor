package com.consultacarros.consumoapi.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Automovel(String codigo,String nome){
    @Override
    public String toString() {
        return "Código: " + codigo +
                "| Nome: " + nome + "\n";
    }
}
