package com.aluracursos.desafio.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//Utilice la libreria Jackson para mapear los datos.
@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosAutor(

        //Datos de los autores que quiero obtener
        @JsonAlias("name") String nombre,
        @JsonAlias("birth_year") String fechaDeNacimiento
) {
}
