package com.aluracursos.desafio.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

//Utilice la libreria Jackson para mapear los datos.
 @JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibros(

        //Datos de los libros que quiero obtener y ademas creando otra lista para los datos de los autores
        @JsonAlias("title") String titulo,
        @JsonAlias("authors") List<DatosAutor> autor,
        @JsonAlias("languages") List<String> idiomas,
        @JsonAlias("download_count") Double numeroDeDescargas
) {
}
