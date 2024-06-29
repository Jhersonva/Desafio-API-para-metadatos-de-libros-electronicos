package com.aluracursos.desafio.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoAPI {

    public String obtenerDatos(String url){

        // Crear un cliente HTTP.
        HttpClient client = HttpClient.newHttpClient();

        // Construir una solicitud HTTP con la URL dada.
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        // Declarar una variable para almacenar la respuesta.
        HttpResponse<String> response = null;

        // Intentar enviar la solicitud y recibir la respuesta.
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            // Manejar excepciones de entrada/salida.
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            // Manejar la excepción de interrupción.
            throw new RuntimeException(e);
        }

        // Obtener el cuerpo de la respuesta en formato JSON.
        String json = response.body();

        // Devolver el JSON obtenido.
        return json;
    }
}
