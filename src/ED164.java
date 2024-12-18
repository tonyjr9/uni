import com.BSTree;
import java.util.Scanner;

public class ED164 {
    public static BSTree<String> pWord(String word, BSTree<String> words){
        if (!words.contains(word)) words.insert(word);
        return words;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        int count = 0;
        BSTree<String> words = new BSTree<String>();
        for (int n = 0; n < N; n++){
            words = pWord(sc.nextLine(), words);
        }
        sc.close();
        System.out.println(words.numberNodes());
    }
}
