package com;

public class DNode<T> {
   private T value;       // Valor guardado no nó
   private DNode<T> next;  // Referência para o próximo nó da lista
   private DNode<T> prev; 

   // Construtor 
   public DNode(T v, DNode<T> n, DNode<T> p) {
      value = v;
      next = n;
      prev = p;

   }

   // Getters e Setters
   public T getValue() {
      return value;
   }

   public DNode<T> getNext() {
      return next;
   }

   public DNode<T> getPrev() {
      return prev;
   }
   
   public void setValue(T v) {
      this.value = v;
   }

   public void setNext(DNode<T> n) {
      this.next = n;
   }

   public void setPrev(DNode<T> p) {
      this.prev = p;
   }

}
