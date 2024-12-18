package com;

public class DoublyLinkedList<T> {

   public DNode<T> first;
   public int size;
   public DNode<T> prev;

   public DoublyLinkedList() {
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
      DNode<T> newNode = new DNode<>(value, first, prev);
      first = newNode;
      size++;
   }

   public void addLast(T value){
      DNode<T> newNode = new DNode<>(value, first, prev);
      if (isEmpty()) {
         first = newNode;
      } else {
         DNode<T> cur = first;
         while (cur.getNext() != null) {
            cur = cur.getNext();
         }
         cur.setNext(newNode);
      }
      size++;
   }

   public T getFirst() {
      if (isEmpty()) return null;
      return first.getValue();
   }

   public T getLast(){
      if (isEmpty()) return null;
      DNode<T> newNode = first;
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

   public void removeLast(){
      if (!isEmpty()) {
         if (size == 1) {
            first = null;
         } else {
            DNode<T> newNode = first;
            while (newNode.getNext() != null) {
               newNode = newNode.getNext();
            }
         } 
      size--;
      }
   }

   @Override
   public String toString() {
      String str = "{";
      DNode<T> newNode = first;
      while (newNode != null) {
         str += newNode.getValue();
         newNode = newNode.getNext();
         if (newNode != null) str += ",";
      }
      str += "}";
      return str;
   }
   
}


