import java.util.Scanner;

public class ED222 {
    public static void calcularOut(int[] prof, int T, int K) {
      int N = prof.length;
      int mink = (K + 1) / 2; // Calcula mink diretamente
      int count = 0;          // Contador de profundidades >= T na janela atual
      int seg = 0;            // Número de segmentos válidos

      // Inicializa a janela de tamanho K
      for (int i = 0; i < K; i++) {
         if (prof[i] >= T) count++;
      }
      if (count >= mink) seg++;

      // Move a janela deslizante pelo restante do array
      for (int i = K; i < N; i++) {
         if (prof[i] >= T) count++;         // Adiciona o novo elemento da janela
         if (prof[i - K] >= T) count--;     // Remove o elemento que saiu da janela
         if (count >= mink) seg++;          // Verifica se a janela é válida
      }

      System.out.println(seg);
   }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), K = sc.nextInt(), T = sc.nextInt();
        int[] prof = new int[N];
        for (int n = 0; n < N; n++) {
            prof[n] = sc.nextInt();
        }
        sc.close();
        calcularOut(prof, T, K);
    }
}
