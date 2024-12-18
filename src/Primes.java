import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.ArrayList;

public class Primes {
    // Verifica se o número n é primo (apenas divisível por 1 e por si próprio)
    public static boolean isPrime(int n) {
        for (int i = 2; i < java.lang.Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPrime(2));
    }
}

//for (int i = 2; i < java.lang.Math.sqrt(n) ; i++) {
//        if (n % i == 0) {
//        return false;
//        }
//        return true;
