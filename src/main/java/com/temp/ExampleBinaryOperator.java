package com.temp;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class ExampleBinaryOperator {

    public static void main(String[] args) {
        // Definir una BiFunction que toma dos cadenas y las normaliza (a mayúsculas y b minúsculas)
        BiFunction<String, String, String> normalizeFunction = (a, b) -> a.toUpperCase() + " - " + b.toLowerCase();

        // Aplicar la BiFunction a "hola" y "mundo" y almacenar el resultado
        String result = normalizeFunction.apply("hola", "mundo");

        // Imprimir el resultado
        System.out.println(result);

        // Definir un BinaryOperator que toma dos cadenas y las normaliza (a mayúsculas y b minúsculas)
        BinaryOperator<String> normalize = (a, b) -> a.toUpperCase() + " - " + b.toLowerCase();

        // Aplicar el BinaryOperator a "hola" y "mundo" y almacenar el resultado
        String result2 = normalize.apply("hola", "mundo");

        // Imprimir el resultado
        System.out.println(result2);
    }
}
