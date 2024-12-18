package com;
import java.util.ArrayList;

public class SinglyLinkedList<T> {

   private Node<T> first;
   private int size;

   public SinglyLinkedList() {
      first = null;
      size = 0;
   }
   
   public int size() {
      return size;
   }

   public boolean isEmpty() {
      return (size == 0);
   }

   public void addFirst(T value) {
      Node<T> newNode = new Node<>(value, first);
      first = newNode;
      size++;
   }

   public void addLast(T value) {
      Node<T> newNode = new Node<>(value, null);
      if (isEmpty()) {
         first = newNode;
      } else {
         Node<T> cur = first;
         while (cur.getNext() != null) {
            cur = cur.getNext();
         }
         cur.setNext(newNode);
      }
      size++;
   }

   public T get(int pos) {
      if (isEmpty() || pos < 0) return null;
  
      Node<T> temp = first;
      int index = 0;
  
      while (temp != null) {
          if (index == pos) {
              return temp.getValue();
          }
          temp = temp.getNext();
          index++;
      }
  
      return null;
   }
   /* 
   public T remove(int pos) {
      if (isEmpty() || pos < 0) return null;
      Node<T> temp = first;
      int index = 0;
      if (pos == 0) {
         Node<T> elemento = first;
         first = first.getNext();
         size--;
         return elemento.getValue();
      } else {
         while (index < pos - 1) {
            temp = temp.getNext();
            if (temp == null) return null;
            index++;
         }
         Node<T> elemento = temp.getNext();
         if (elemento == null) return null;
         temp.setNext(temp.getNext().getNext());
         size--;
         return elemento.getValue();
      }
   }
   */
   
   
   @SuppressWarnings("unchecked")
   public SinglyLinkedList<T> copy() {
    SinglyLinkedList<T> newList = new SinglyLinkedList<>();
    if (this.first == null) {
        return newList;
    }
    
    Node<T> current = this.first;
    newList.first = new Node<>(current.getValue(), null);
    Node<T> newListCurrent = newList.first;
    
    while (current.getNext() != null) {
        current = current.getNext();
        Node<T> newNode = new Node<>(current.getValue(), null);
        newListCurrent.setNext(newNode);
        newListCurrent = newNode;
    }
    
    newList.size = this.size;
    return newList;
   }

   public void duplicate() {
      Node<T> current = first;
      while (current != null) {
          Node<T> duplicateNode = new Node<>(current.getValue(), current.getNext());
          current.setNext(duplicateNode);
          current = duplicateNode.getNext();
          size++;
      }
  }
  
   public int count(T value) {
      Node<T> current = first;
      int count = 0;
      for (int i = 0; i < size; i++) {
         if (current.getValue().equals(value)) count++;
         current = current.getNext();
      }
      return count;
   }

   public void removeAll(T value) {
      while (first != null && first.getValue().equals(value)) {
          first = first.getNext();
          size--;
      }
      
      Node<T> current = first;
      while (current != null && current.getNext() != null) {
          if (current.getNext().getValue().equals(value)) {
              current.setNext(current.getNext().getNext());
              size--;
          } else {
              current = current.getNext();
          }
      }
   }
  


   public SinglyLinkedList<T> reverse(){
      if (size == 0) return null;
      SinglyLinkedList<T> reversedList = new SinglyLinkedList<>();
      
      Node<T> tmp = this.first;
      while (tmp != null){
         reversedList.addFirst(tmp.getValue());
         tmp = tmp.getNext();
      }

      return reversedList;
   }
  
   public int[] occurrences(T elem) {
      ArrayList<Integer> ocurs = new ArrayList<>();
      Node<T> tmp = new Node<>(first.getValue(), first.getNext());
      for (int i = 0; i < this.size; i++) {
         if (tmp.getValue() == elem) {
            ocurs.add(i);
         }
         tmp = tmp.getNext();
      }
      if (ocurs.isEmpty()) return null;
      int[] ocurrences = new int[ocurs.size()];
      
      for (int i = 0; i < ocurs.size(); i++) {
         ocurrences[i] = ocurs.get(i); 
      }
      return ocurrences;
   }

   public void remove(SinglyLinkedList<T> toRemove){
      if (toRemove == null || toRemove.isEmpty() || this.isEmpty()) {
         return; // Nothing to remove
     }
 
     Node<T> current = toRemove.first;
 
     // Iterate through the toRemove list
     while (current != null) {
         T valueToRemove = current.getValue();
         this.removeAll(valueToRemove); // Reuse the removeAll method to remove all occurrences of the value
         current = current.getNext();
     }
   }



   public T getFirst() {
      if (isEmpty()) return null;
      return first.getValue();
   }

   public T getLast() {
      if (isEmpty()) return null;
      Node<T> newNode = first;
      while (newNode.getNext() != null) {
         newNode = newNode.getNext();
      } 
      return newNode.getValue();
   }

   public void removeFirst() {
      if (!isEmpty()) {
         first = first.getNext();
         size--;
      }
   }

   public void removeLast() {
      if (!isEmpty()) {
         if (size == 1) {
            first = null;
         } else {
            Node<T> newNode = first;
            while (newNode.getNext().getNext() != null) {
         
               newNode = newNode.getNext();
            }
            newNode.setNext(null);
         } 
         size--;
      }
   }

   @Override
   public String toString() {
      StringBuilder str = new StringBuilder("{");
      Node<T> newNode = first;
      while (newNode != null) {
         str.append(newNode.getValue());
         newNode = newNode.getNext();
         if (newNode != null) str.append(",");
      }
      str.append("}");
      return str.toString();
   }



   public SinglyLinkedList<T> cut(int a, int b) {
      SinglyLinkedList<T> res = new SinglyLinkedList<>();

      for (int i = 0; i < this.size; i++){
         if (i >= a && i <= b) res.addLast(this.get(i));
      }
      return res;
   }


   public void shift(int k) {
      for (int ki = 0; ki < k; ki++){
         this.addFirst(this.getLast());
         this.removeLast();
      }
   }
}
