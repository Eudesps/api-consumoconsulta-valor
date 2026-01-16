package com.consultacarros.consumoapi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class ConverteDados {
    private ObjectMapper mapper = new ObjectMapper();

    //como a classe é generica, é interessante na hora de chamar o método, passar também a classe que se deseja
    //converter no momento de sua utilização.
    public <T> List<T> converteLista(String json, Class<T> classe) {
        try {
            return mapper.readValue(
                    json,
                    mapper.getTypeFactory().constructCollectionType(List.class, classe)
            );
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
