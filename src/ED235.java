import java.util.Scanner;

public class ED235 {

   public static void dtriangulo(int l) {

      for (int linha = 0; linha < l; linha++){
         for (int i = 0; i < l; i++){
            if (linha + i < l) {
               System.out.print('#');
            } else {
               System.out.print('.');
            }
            
         }
         System.out.println();
      }
   }
   
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int N = sc.nextInt();
      int[] ci = new int[N];
      for (int i = 0; i < N; i++) {
         ci[i] = sc.nextInt();
      }
      sc.close();
      for (int l : ci) {
         dtriangulo(l);

      }

   }
   
}
