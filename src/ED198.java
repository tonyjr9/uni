import java.util.Scanner;

public class ED198 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] num = new int[N];
        for (int n = 0; n < N; n++) {
            num[n] = sc.nextInt();
        }
        sc.close();

        // Algoritmo de Kadane
        int maxSoFar = num[0];
        int currentMax = num[0];

        for (int i = 1; i < N; i++) {
            currentMax = Math.max(num[i], currentMax + num[i]);
            maxSoFar = Math.max(maxSoFar, currentMax);
        }

        System.out.println(maxSoFar);
    }
}
