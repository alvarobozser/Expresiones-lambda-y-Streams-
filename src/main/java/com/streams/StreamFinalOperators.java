package com.streams;

import util.Database;
import util.Videogame;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamFinalOperators {

    public static void main(String[] args) {
        // Obtiene un stream de la lista de videojuegos desde la base de datos
        Stream<Videogame> videogames = Database.videogames.stream();

        // Llama al método forEachOperator para imprimir cada videojuego en el stream
        forEachOperator(videogames);
    }

    // Método que cuenta el número de videojuegos en el stream y lo imprime
    static void countOperator(Stream<Videogame> stream) {
        System.out.println(stream.count());
    }

    // Método que imprime cada videojuego en el stream
    static void forEachOperator(Stream<Videogame> stream) {
        stream.forEach(System.out::println);
    }

    // Método que verifica si algún videojuego tiene más de una unidad vendida y lo imprime
    static void anyMatchOperator(Stream<Videogame> stream) {
        boolean r = stream.anyMatch(v -> v.getTotalSold() > 1);
        System.out.println(r);
    }

    // Método que verifica si todos los videojuegos tienen más de 150 unidades vendidas y lo imprime
    static void allMatchOperator(Stream<Videogame> stream) {
        boolean r = stream.allMatch(v -> v.getTotalSold() > 150);
        System.out.println(r);
    }

    // Método que verifica si ninguno de los videojuegos tiene críticas y lo imprime
    static void noneMatchOperator(Stream<Videogame> stream) {
        boolean r = stream.noneMatch(v -> v.getReviews().isEmpty());
        System.out.println(r);
    }

    // Método que encuentra el primer videojuego en el stream y lo imprime
    static void findFirstOperator(Stream<Videogame> stream) {
        Optional<Videogame> r = stream.findFirst();
        System.out.println(r);
    }

    // Método que encuentra cualquier videojuego en el stream y lo imprime
    static void findAnyOperator(Stream<Videogame> stream) {
        Optional<Videogame> r = stream.findAny();
        System.out.println(r);
    }

    // Método que suma el total de unidades vendidas de los videojuegos con descuento y lo imprime
    static void  reduceOperator(Stream<Videogame> stream) {
        Optional<Integer> r = stream
                .filter(Videogame::getIsDiscount)
                .map(Videogame::getTotalSold)
                .reduce(Integer::sum);

        System.out.println(r);
    }

    // Método que encuentra el videojuego con el nombre máximo lexicográficamente y lo imprime
    static void maxOperator(Stream<Videogame> stream) {
        Optional<Videogame> r = stream.max(Comparator.comparing(Videogame::getName));
        System.out.println(r.get().getName());
    }

    // Método que encuentra el videojuego con el nombre mínimo lexicográficamente y lo imprime
    static void minOperator(Stream<Videogame> stream) {
        Optional<Videogame> r = stream.min(Comparator.comparing(Videogame::getName));
        System.out.println(r.get().getName());
    }
}
