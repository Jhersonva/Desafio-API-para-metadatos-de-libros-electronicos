package com.aluracursos.desafio.Principal;

import com.aluracursos.desafio.model.Datos;
import com.aluracursos.desafio.model.DatosLibros;
import com.aluracursos.desafio.service.ConsumoAPI;
import com.aluracursos.desafio.service.ConvierteDatos;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {

    private Scanner teclado = new Scanner(System.in);
    private static final String URL_BASE = "https://gutendex.com/books/";
    private static final String URL_BUSQUEDA = "?search=";
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos();

    public void mostrarElMenu(){

        var json = consumoAPI.obtenerDatos(URL_BASE);
        System.out.println(json);

        var datos = conversor.convertirDatos(json, Datos.class);
        System.out.println(datos);

        //Top 10 libros más descargados
        System.out.println("Top 10 libros más descargados");
        datos.resultados().stream()
                .sorted(Comparator.comparing(DatosLibros::numeroDeDescargas).reversed())
                .limit(10)
                .map(l -> l.titulo().toUpperCase())
                .forEach(System.out::println);

        //Busqueda de libros por nombre
        System.out.println("Ingrese el nombre del libro que desea buscar: ");
        var tituloLibro = teclado.nextLine();
        json = consumoAPI.obtenerDatos(URL_BASE + URL_BUSQUEDA + tituloLibro.replace(" ", "+"));
        var datosBusqueda = conversor.convertirDatos(json, Datos.class);

        Optional<DatosLibros> librosBuscado = datosBusqueda.resultados().stream()
                .filter(l->l.titulo().toUpperCase().contains(tituloLibro.toUpperCase()))
                .findFirst();

        if (librosBuscado.isPresent()){
            System.out.println("Libro encontrado ");
            System.out.println(librosBuscado.get());
        } else {
            System.out.println("Libro no encontrado");
        }

        //Trabajando con Estadisticas
        DoubleSummaryStatistics est = datos.resultados().stream()
                .filter(d->d.numeroDeDescargas()>0)
                .collect(Collectors.summarizingDouble(DatosLibros::numeroDeDescargas));
        System.out.println("Canditad de descargas: " + est.getAverage());
        System.out.println("Cantidad maxima de descargas: " + est.getMax());
        System.out.println("Cantidad minima de descargas: " + est.getMin());
        System.out.println("Cantidad de registros evaluados para calcular las estadisticas: " + est.getCount());
    }
}
