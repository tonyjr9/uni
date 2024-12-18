import com.SinglyLinkedList;
public class TesteSLL {
    public static void main(String[] args) {
        @SuppressWarnings("rawtypes")
        SinglyLinkedList lista1 = new SinglyLinkedList<>();
        lista1.addLast(2);
        lista1.addLast(4);
        lista1.addLast(6);
        lista1.addLast(8);
        lista1.addLast(10);
        System.out.println(lista1.toString());
        lista1.removeAll(6);
        System.out.println(lista1.toString());

   }
}
