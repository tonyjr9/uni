package teste1treino;
import com.SinglyLinkedList;
import java.util.Arrays;

public class ED232 {

   public static void main(String[] args) {
       SinglyLinkedList<Integer> lista = new SinglyLinkedList<>();
        
       for (int i = 1; i < 5; i++){
        lista.addLast(i * 2);
       }

       System.out.println(lista.reverse());

       lista.addFirst(2);
       lista.addLast(4);
       System.out.println(lista);

       System.out.print(Arrays.toString(lista.occurrences(4 )));
       SinglyLinkedList<Integer> lista2 = new SinglyLinkedList<>();
       lista2.addFirst(4);
       SinglyLinkedList<String> lista3 = new SinglyLinkedList<>();
       lista3.addLast("a");
       lista3.addLast("b");
       lista3.addLast("c");
       System.out.println(lista3.size() + " " + lista3.reverse());
       System.out.print(lista3.toString());



       
   }
}
