
import com.SinglyLinkedList;

public class ED236 {
   
   public static void main(String[] args) {
      SinglyLinkedList<Integer> lista = new SinglyLinkedList<>();

      for (int i = 0; i < 5; i++) {
         lista.addLast(i*2);
      }
      System.out.println(lista);
      lista.shift(2);
      System.out.println(lista);

   }
}
