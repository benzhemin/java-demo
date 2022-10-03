package lambada;

import java.util.stream.IntStream;

public class Prime {

    static boolean isPrimeNormal(int number) {
        boolean isPrime = true;

        for (int i=2; i<number; i++) {
            if (number % i == 0) {
                isPrime = false;
                break;
            }
        }

        return number > 1 && isPrime;
    }

    static boolean isPrimeFunctional(int number) {
        boolean canDivide = IntStream.range(2, number)
                .anyMatch(index -> number % index == 0);

        return number > 1 && !canDivide;
    }

    public static void main(String[] args) {
        for (int i = 1; i < 8; i++) {
            if (isPrimeNormal(i)) {
                System.out.println("prime: " + i);
            }
        }

        for (int i = 1; i < 8; i++) {
            if (isPrimeFunctional(i)) {
                System.out.println("prime: " + i);
            }
        }
    }
}
