import java.util.Scanner;

public class CountPrimes {
    public static int countPrimes(long start, long end) {
        // Cria um array booleano para marcar se os números são primos
        boolean[] isPrime = new boolean[(int)end + 1];
        // Inicializa todos os números como primos
        for (long i = 2; i <= end; i++) {
            isPrime[(int) i] = true;
        }
        // Crivo de Eratóstenes para encontrar todos os primos até B
        for (long i = 2; i << 2 <= end; i++) {
            if (isPrime[(int) i]) {
                for (long j = i * i; j <= end; j += i) {
                    isPrime[(int) j] = false; // Marca múltiplos de i como não primos
                }
            }
        }
        // Contagem de números primos no intervalo [A, B]
        int count = 0;
        for (long i = start; i <= end; i++) {
            if (isPrime[(int) i]) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Leitura dos valores A = start e B = end
        long A = scanner.nextInt();
        long B = scanner.nextInt();
        scanner.close();
        System.out.println(countPrimes(A, B));
    }
}
