package com.streams;

import util.BasicVideogame;
import util.Database;
import util.Review;
import util.Videogame;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamIntermediateOperators {

    public static void main(String[] args) {
        // Obtiene un stream de la lista de videojuegos desde la base de datos
        Stream<Videogame> videogames = Database.videogames.stream();

        // Llama al método dropWhileOperator para filtrar y mostrar los videojuegos que empiezan con 'M'
        dropWhileOperator(videogames);
    }

    // Método que limita el stream a los primeros 5 videojuegos y los imprime
    static void limitOperator(Stream<Videogame> stream) {
        List<Videogame> r = stream.limit(5).collect(Collectors.toList());
        r.forEach(System.out::println);
    }

    // Método que salta los primeros 15 videojuegos y muestra el resto
    static void skipOperator(Stream<Videogame> stream) {
        List<Videogame> r = stream.skip(15).collect(Collectors.toList());
        r.forEach(System.out::println);
    }

    // Método que filtra los videojuegos basándose en diferentes condiciones y los imprime
    static void filterOperator(Stream<Videogame> stream) {
        List<Videogame> r = stream
                .filter(v -> v.getPrice() > 12.0)
                .filter(v -> !v.getIsDiscount())
                .filter(v -> v.getOfficialWebsite().contains("forza"))
                .collect(Collectors.toList());

        r.forEach(System.out::println);
    }

    // Método que mapea los videojuegos a una versión básica y muestra tanto los básicos como sus títulos
    static void mapOperator(Stream<Videogame> stream) {
        List<BasicVideogame> basicVideogames = stream
                .map(v -> {
                    return BasicVideogame.builder()
                            .name(v.getName())
                            .price(v.getPrice())
                            .console(v.getConsole())
                            .build();
                }).collect(Collectors.toList());

        List<String> titles = basicVideogames.stream()
                .map(BasicVideogame::getName)
                .collect(Collectors.toList());

        basicVideogames.forEach(System.out::println);
        System.out.println("-----");
        titles.forEach(System.out::println);
    }

    // Método que aplana las críticas de los videojuegos y las muestra
    static void flatMapOperator(Stream<Videogame> stream) {
        List<Review> r = stream.flatMap(v -> v.getReviews().stream()).collect(Collectors.toList());
        System.out.println(r);
    }

    // Método que muestra el total de críticas de todos los videojuegos
    static void mapVSFlatMapOperator(Stream<Videogame> stream) {
        Long totalReviews = stream.flatMap(v -> v.getReviews().stream()).count();
        System.out.println(totalReviews);
    }

    // Método que modifica temporalmente el nombre de los videojuegos a vacío y los imprime
    static void peekOperator(Stream<Videogame> stream) {
        stream.peek(v -> v.setName("")).forEach(System.out::println);
    }

    // Método que ordena los videojuegos según la cantidad de críticas y los muestra
    static void sortOperator(Stream<Videogame> stream) {
        List<Videogame> listSorted = stream
                .sorted(Comparator.comparingInt(v -> v.getReviews().size()))
                .collect(Collectors.toList());

        listSorted.forEach(System.out::println);
    }

    // Método que toma los videojuegos mientras el nombre no empiece con 'M' y los muestra
    static void takeWhileOperator(Stream<Videogame> stream) {
        List<Videogame> r = stream
                .sorted(Comparator.comparing(Videogame::getName))
                .takeWhile(v -> !v.getName().startsWith("M"))
                .collect(Collectors.toList());

        r.forEach(System.out::println);
    }

    // Método que elimina los videojuegos mientras el nombre no empiece con 'M' y los muestra
    static void dropWhileOperator(Stream<Videogame> stream) {
        List<Videogame> r = stream
                .sorted(Comparator.comparing(Videogame::getName))
                .dropWhile(v -> !v.getName().startsWith("M"))
                .collect(Collectors.toList());

        r.forEach(System.out::println);
    }
}
