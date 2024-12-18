import com.LibBTree;
import com.BTree;
import com.ED213;

import java.util.Scanner;

public class TestBTree {
   public static void main(String[] args) {
      // Ler arvore de inteiros em preorder
      Scanner in = new Scanner(System.in);
      BTree<Integer> t = LibBTree.readIntTree(in);
      in.close();
      // Escrever resultado de chamada a alguns metodos
     
      // Escrever nos da arvore seguindo varias ordens possiveis
      System.out.println(ED213.maxSum(t));
      
     // t.printBFS();
      

   }
}

