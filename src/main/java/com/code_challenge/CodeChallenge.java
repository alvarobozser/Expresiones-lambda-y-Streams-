package com.code_challenge;

import java.util.Arrays;


@FunctionalInterface
interface PerformOperation {
    boolean check(int a);
}

class CodeImpl {

	// Es impar? Devuelve true si es impar, false si es par
	public static PerformOperation isOdd() {
	    // Lambda expression que verifica si el número es impar
	    return n -> (n % 2 != 0);
	}

	// Es un número primo?
	public static PerformOperation isPrime() {
	    // Lambda expression para verificar si el número es primo
	    return n -> {
	        int divider = 1; // Inicialización del divisor
	        int cont = 0; // Contador de divisores

	        // Mientras el divisor sea menor o igual a n
	        while (divider <= n) {
	            // Si n es divisible por el divisor actual, incrementar el contador
	            if (n % divider == 0) cont++;
	            
	            // Si el contador supera 2 (más de dos divisores), salir del bucle
	            if (cont > 2) break;
	            
	            // Incrementar el divisor
	            divider++;
	        }
	        // Devuelve true si el contador es igual a 2 (es primo), false en caso contrario
	        return cont == 2;
	    };
	}

	// Es un número palíndromo? Ejemplo: 98589
	public static PerformOperation isPalindrome() {
	    // Lambda expression para verificar si el número es un palíndromo
	    return n -> {
	        // Convertir el número a String
	        String numString = Integer.toString(n);
	        
	        // Convertir el String a un array de caracteres
	        char[] chars = numString.toCharArray();
	        
	        // Obtener la longitud del array de caracteres
	        int charsLength = chars.length;

	        // Recorrer el array de caracteres desde ambos extremos
	        for (int i = 0, r = charsLength - 1; i < charsLength; i++, r--) {
	            // Si los caracteres en las posiciones i y r son diferentes, no es un palíndromo
	            if (chars[i] != chars[r]) return false;
	        }
	        // Si se han comparado todos los caracteres y son iguales, es un palíndromo
	        return true;
	    };
	}
}

/*public class CodeChallenge {

}
    @Test
    public void startTest() {

        PerformOperation isOdd = CodeImpl.isOdd();
        PerformOperation isPrime = CodeImpl.isPrime();
        PerformOperation isPalindrome = CodeImpl.isPalindrome();

        int[] isOddCases = {3,7,9,2,8};
        int[] isPrimeCases = {2,31,97,42,98};
        int[] isPalindromeCases = {54322345,710101017,888,7848729,783483002};

    
        assertAll( "Test isOdd" ,
                () -> assertTrue(isOdd.check(isOddCases[0])),
                () -> assertTrue(isOdd.check(isOddCases[1])),
                () -> assertTrue(isOdd.check(isOddCases[2])),
                () -> assertFalse(isOdd.check(isOddCases[3])),
                () -> assertFalse(isOdd.check(isOddCases[4]))
        );

       assertAll( "Test isPrime" ,
              () -> assertTrue(isPrime.check(isPrimeCases[0])),
              () -> assertTrue(isPrime.check(isPrimeCases[1])),
              () -> assertTrue(isPrime.check(isPrimeCases[2])),
              () -> assertFalse(isPrime.check(isPrimeCases[3])),
              () -> assertFalse(isPrime.check(isPrimeCases[4]))
       );

       assertAll( "Test isPalindrome" ,
               () -> assertTrue(isPalindrome.check(isPalindromeCases[0])),
               () -> assertTrue(isPalindrome.check(isPalindromeCases[1])),
               () -> assertTrue(isPalindrome.check(isPalindromeCases[2])),
               () -> assertFalse(isPalindrome.check(isPalindromeCases[3])),
               () -> assertFalse(isPalindrome.check(isPalindromeCases[4]))
       );
    }
}*/


// Descomenta para probar con main method
public class CodeChallenge {

    public static void main(String[] args) {
        PerformOperation isOdd = CodeImpl.isOdd();
        PerformOperation isPrime = CodeImpl.isPrime();
        PerformOperation isPalindrome = CodeImpl.isPalindrome();
        int[] isOddCases = {3,7,9,2,8};
        int[] isPrimeCases = {2,31,97,42,98};
        int[] isPalindromeCases = {54322345,710101017,888,7848729,783483002};
        System.out.println("Odd test");
        Arrays.stream(isOddCases).forEach(i -> System.out.println(isOdd.check(i))); //true, true, true, false, false
        System.out.println("isPrime test");
        Arrays.stream(isPrimeCases).forEach(i -> System.out.println(isPrime.check(i))); //true, true, true, false, false
        System.out.println("isPalindrome test");
        Arrays.stream(isPalindromeCases).forEach(i -> System.out.println(isPalindrome.check(i))); //true, true, true, false, false
    }
}


