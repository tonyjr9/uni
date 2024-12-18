import java.util.Scanner;

public class ED199 {
   public static void processarInst(Scanner sc, int I, int B, boolean[] Tesouros) {
      int N = Tesouros.length;
      int index = B - 1;
      int count = (Tesouros[index]) ? 1 : 0;
      Tesouros[index] = false;
      for (int i = 0; i < I; i++) {
         String[] inst = sc.nextLine().split(" ");
         int movimento = Integer.parseInt(inst[1]);
         int dir = (inst[0].equals("D")) ? 0 : 1;

         if (dir == 0) { // Direção direita
               int end = index + movimento;
               for (int k = index + 1; k <= end; k++) {
                  if (Tesouros[k]) {
                     count++;
                     Tesouros[k] = false;
                  }
               }
               index = end;
         } else { // Direção esquerda
               int end = index - movimento;
               for (int k = index - 1; k >= end; k--) {
                  if (Tesouros[k]) {
                     count++;
                     Tesouros[k] = false;
                  }
               }
               index = end;
         }
      }

      System.out.println(count);
    }

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int N = sc.nextInt();
      int B = sc.nextInt();
      int I = sc.nextInt();
      sc.nextLine();
      String Tesouros = sc.nextLine();

      boolean[] tB = new boolean[N];
      for (int t = 0; t < N; t++) {
         tB[t] = (Tesouros.charAt(t) == 'T');
      }
      processarInst(sc, I, B, tB);
      sc.close();
    }
}
