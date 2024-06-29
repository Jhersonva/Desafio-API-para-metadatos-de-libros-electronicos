package com.aluracursos.desafio.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

//Utilice la libreria Jackson para mapear los datos.
@JsonIgnoreProperties(ignoreUnknown = true)
public record Datos(

        //Lista para traer los datos de los libros
        @JsonAlias("results") List<DatosLibros> resultados

        ) {

}
