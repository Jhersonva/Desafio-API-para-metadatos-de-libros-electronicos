package com.aluracursos.desafio.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//Haciendo una implementación de mi Interfaz IConvierteDatos
public class ConvierteDatos implements IConvierteDatos{

    //Utilizando la clase ObjectMapper para la conversion de Json a Objetos Java
    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public <T> T convertirDatos(String json, Class<T> clase) {
        try {
            return objectMapper.readValue(json, clase);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
