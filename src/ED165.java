import java.util.Scanner;
import com.BSTree;

public class ED165 {
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        BSTree<Integer> Ni = new BSTree<Integer>();
        for (int i = 0; i < N; i++){
            Ni.insert(sc.nextInt());
        }
        int P = sc.nextInt();
        BSTree<Integer> Pi = new BSTree<Integer>();
        for (int p = 0; p < P; p++){
            Pi.insert(sc.nextInt());
        }


    }
}
