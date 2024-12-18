import java.util.Scanner;

public class ED200 {

    public static void interpretarCaso(Scanner sc) {
        int L = sc.nextInt(), C = sc.nextInt();
        sc.nextLine();
        char[][] petri = new char[L][C];
        
        for (int l = 0; l < L; l++) {
            String line = sc.nextLine();
            for (int c = 0; c < C; c++){
                petri[l][c] = line.charAt(c);
            }
        }

        

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < N; i++) {
            interpretarCaso(sc);
        }
    }
}