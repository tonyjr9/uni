package teste1treino;
import java.util.Scanner;
   public class ED231 {

      public static void Flag1(int[] ci, int N) {
         int min = 0, max = 0;
         for (int i = 0; i < N - 1; i++) {
            int dif = ci[i + 1] - ci[i];
            if (i == 0) min = dif;
            if (dif > max) {
               max = dif;
            } else if (dif < min) {
               min = dif;
            }
         }
         System.out.println(min + " " + max); 
      }

      public static void Flag2(int[] ci, int N) {
         int Plength = 0, Pcount = 0, PmaxL = 0;
         boolean isCounted = false;

         for (int i = 1; i < N; i++) {

            int dif = ci[i] - ci[i-1];
            float percentage = (float) 100 * dif / ci[i-1];
           
            if (percentage <= 5.0) {
               if (!isCounted) Pcount++;
               Plength++;
               isCounted = true;
               if (Plength > PmaxL) {
                  PmaxL = Plength;
               }
            } else {
               Plength = 0;
               isCounted = false;
            }
            
      
         }
         System.out.println(Pcount + " " + PmaxL);

      }

      public static void Flag3(int[] ci, int N) {
         int[] scaled = new int[N];
         for (int i = 0; i < N; i++) {
             scaled[i] = ci[i] / 100;
         }
     
         char[][] barGraph = new char[scaled[scaled.length - 1]][N];
     
         for (int i = 0; i < N; i++) {
             int count = scaled[i];
             for (int j = scaled[scaled.length - 1] - 1; j >= 0; j--) {
                 if (count > 0) {
                     barGraph[j][i] = '#';
                     count--;
                 } else {
                     barGraph[j][i] = '.';
                 }
             }
         }
     
         for (char[] barGraph1 : barGraph) {
            StringBuilder strout = new StringBuilder();
            for (int i = 0; i < N; i++) {
               strout.append(barGraph1[i]);
            }
            System.out.println(strout);
         }
     }
     

      public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int N = sc.nextInt();
         int[] Ci = new int[N];
         for (int i = 0; i < N; i++) {
            Ci[i] = sc.nextInt();
         }

         int flag = sc.nextInt();
         sc.close();
         if (flag == 1) {
            Flag1(Ci, N);
         } else if (flag == 2) {
            Flag2(Ci, N);
         } else if (flag == 3) {
            Flag3(Ci, N);
         }
   }
}
