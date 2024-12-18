import java.util.LinkedList;
import java.util.Scanner;

import com.BSTMap;
public class ED172 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BSTMap<String, Integer> palavras = new BSTMap<>();
        LinkedList<String> keys = new LinkedList<>();
        while (sc.hasNext()) {
            String p = sc.next();
            System.out.println("1");
            System.out.println(p);
            if (palavras.get(p) == null){
                palavras.put(p, 1);
                keys.add(p);
            } else {
                palavras.put(p, palavras.get(p) + 1);

            }
            if (sc.hasNext() == false) break;
        }   
        sc.close();
        for (int i = 0; i < keys.size(); i++) {
            System.out.println(keys.get(i) + ": " + palavras.get(keys.get(i)));
        }

    }
}
