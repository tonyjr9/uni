import java.util.Scanner;
public class testeComplexidade {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.close();
    int i = 1; 
    while (n > 1) {
      i *= n;
      n--;
    }
    System.out.println(i);
  }
}
