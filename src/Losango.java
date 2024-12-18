import java.util.Scanner;

public class Losango{

    public static void losang(int n){

        int meio = n/2+1; //linhas até ao meio
        int espaco = n/2; //espaço até '#'
        int counter = 0;  //aux para estantes '.'

        for(int i=1; i<=meio; i++){
            System.out.print("");
            for (int j=1; j<=espaco; j++){
                System.out.print(".");
                counter++;
            }

            espaco--;

            for(int j=1; j<=2*i-1; j++){
                System.out.print("#");
                counter++;
            }

            for(int k=1; k<=n-counter ; k++)
                System.out.print(".");

            System.out.println();
            counter=0;
        }

        espaco = 1;
        counter = 0;

        for (int i=1; i<=meio-1; i++){
            System.out.print("");
            for(int j=1; j<=espaco; j++){
                System.out.print(".");
                counter++;
            }

            espaco++;

            for(int j=1; j<=2*(meio-i)-1; j++){
                System.out.print("#");
                counter++;
            }

            for(int k=1; k<=n-counter; k++)
                System.out.print(".");

            System.out.println();
            counter=0;
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        losang(n);
    }
}
