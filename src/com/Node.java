package com;

public class Node<T> {
   private T value;       // Valor guardado no nó
   private Node<T> next;  // Referência para o próximo nó da lista

   // Construtor 
   public Node(T v, Node<T> n) {
      value = v;
      next = n;
   }

   // Getters e Setters
   public T getValue() {
      return value;
   }

   public Node<T> getNext() {
      return next;
   }

   public void setValue(T v) {
      value = v;
   }

   public void setNext(Node<T> node) {
      next = node;
   }
   
   
}

