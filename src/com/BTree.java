// -----------------------------------------------------------
// Estruturas de Dados 2024/2025 (CC1007) - DCC/FCUP
// https://www.dcc.fc.up.pt/~fds/aulas/EDados/2425/
// -----------------------------------------------------------
// Arvore binaria "normal"
// (Pedro Ribeiro @ DCC-FCUP)
// -----------------------------------------------------------
package com;

public class BTree<T> {   
   private BTNode<T> root; // raiz da arvore

   // Construtor
   BTree() {
      root = null;
   }

   // Getter e Setter para a raiz
   public BTNode<T> getRoot() {return root;}
   public void setRoot(BTNode<T> r) {root = r;}

   // Verificar se arvore esta vazia
   public boolean isEmpty() {
      return root == null;
   }

   // --------------------------------------------------------

   // Numero de nos da arvore   
   public int numberNodes() {
      return numberNodes(root);
   }

   private int numberNodes(BTNode<T> n) {
      if (n == null) return 0;
      return 1 + numberNodes(n.getLeft()) + numberNodes(n.getRight());
   }

   // --------------------------------------------------------

   // Altura da arvore
   public int depth() {
      return depth(root);
   }

   private int depth(BTNode<T> n) {
      if (n == null) return -1;
      return 1 + Math.max(depth(n.getLeft()), depth(n.getRight()));
   }

   // --------------------------------------------------------
   
   // O elemento value esta contido na arvore?
   public boolean contains(T value) {
      return contains(root, value);
   }

   private boolean contains(BTNode<T> n, T value) {
      if (n==null) return false;
      if (n.getValue().equals(value)) return true;
      return contains(n.getLeft(), value) || contains(n.getRight(), value);
   }

   // --------------------------------------------------------

   // Imprimir arvore em PreOrder
   public void printPreOrder() {
      System.out.print("PreOrder:");
      printPreOrder(root);
      System.out.println();
   }

   private void printPreOrder(BTNode<T> n) {
      if (n==null) return;
      System.out.print(" " + n.getValue() );
      printPreOrder(n.getLeft());
      printPreOrder(n.getRight());
   }

   // --------------------------------------------------------
   
   // Imprimir arvore em InOrder
   public void printInOrder() {
      System.out.print("InOrder:");
      printInOrder(root);
      System.out.println();
   }

   private void printInOrder(BTNode<T> n) {
      if (n==null) return;
      printInOrder(n.getLeft());
      System.out.print(" " + n.getValue());
      printInOrder(n.getRight());
   }

   // --------------------------------------------------------

   // Imprimir arvore em PostOrder
   public void printPostOrder() {
      System.out.print("PostOrder:");
      printPostOrder(root);
      System.out.println();
   }

   private void printPostOrder(BTNode<T> n) {
      if (n==null) return;
      printPostOrder(n.getLeft());
      printPostOrder(n.getRight());
      System.out.print(" " + n.getValue());
   }

   // --------------------------------------------------------

   // Imprimir arvore numa visita em largura (usando TAD Fila)
   public void printBFS() {
      System.out.print("BFS:");
      
      MyQueue<BTNode<T>> q = new LinkedListQueue<BTNode<T>>();
      q.enqueue(root);
      while (!q.isEmpty()) {
         BTNode<T> cur = q.dequeue();
         if (cur != null) {
            System.out.print(" " + cur.getValue());
            q.enqueue(cur.getLeft());
            q.enqueue(cur.getRight());
         }
      }
      System.out.println();
   }

   // --------------------------------------------------------
   
   // Imprimir arvore numa visita em profundidade (usando TAD Pilha)
   public void printDFS() {
      System.out.print("DFS:");
      
      MyStack<BTNode<T>> q = new LinkedListStack<BTNode<T>>();
      q.push(root);
      while (!q.isEmpty()) {
         BTNode<T> cur = q.pop();
         if (cur != null) {
            System.out.print(" " + cur.getValue());
            q.push(cur.getLeft());
            q.push(cur.getRight());
         }
      }
      System.out.println();
   }

   ////////////////////////////////////////////////////////////
   // fim de código fornecido /////////////////////////////////
   ////////////////////////////////////////////////////////////
   // ED204
   public int numberLeafs() {
      return numberLeafs(root);
   }
   private int numberLeafs(BTNode<T> n) {
      if (n==null) return 0;
      if (n.getLeft()==null && n.getRight()==null) return 1;
      return numberLeafs(n.getLeft()) + numberLeafs(n.getRight()); 	
   }
   
   // ED205 POR FAZER
   public boolean strict(){
      return strict(root);
   }
   private boolean strict(BTNode<T> n) {
      return true;
   }
   

   // ED206
   public T path(String s){
      return path(s, root);
   }
   private T path(String s, BTNode<T> n){
      if (s.charAt(0) == 'R') return n.getValue();
      for (int i = 0; i < s.length(); i++){
         if (s.charAt(i) == 'E') {
            n = n.getLeft();
         } else if (s.charAt(i) == 'D') {
            n = n.getRight();
         }
      }
      return n.getValue();
   }

   // ED207
   public int nodesLevel(int k){
      return nodesLevel(k, root);
   } 
   private int nodesLevel(int k, BTNode<T> n) {
      MyQueue<BTNode<T>> fila = new LinkedListQueue<BTNode<T>>();
      if (n == null) return 0;
      if (k == 0) return 1;
      fila.enqueue(n);
      for (int i = 0; i < k; i++) {
         int size = fila.size();
         for (int no = 0; no < size; no++) {
            BTNode<T> NTmp = fila.dequeue();
            if (NTmp.getLeft() != null) fila.enqueue(NTmp.getLeft());
            if (NTmp.getRight() != null) fila.enqueue(NTmp.getRight());
         }
      }
      return fila.size();
   }

   // ED211
   public static int countEven(BTree<Integer> t){
       return countEven1(t);
   }
   private static int countEven1(BTree<Integer> t) {
      BTNode<Integer> n = t.getRoot();
      if (n == null) return 0;

      int count = 0;
      MyQueue<BTNode<Integer>> queue = new LinkedListQueue<>();
      queue.enqueue(n);

      while (!queue.isEmpty()) {
         
         BTNode<Integer> current = queue.dequeue();
         if (current.getValue() % 2 == 0) count++;
         if (current.getLeft() != null) queue.enqueue(current.getLeft());
         if (current.getRight() != null) queue.enqueue(current.getRight());
      }

      return count;
   }

   // ED212
   public static int[] sumLevels(BTree<Integer> t){
      int[] list = new int[t.depth()];
      BTNode<Integer> tmp = t.root;
      MyQueue<BTNode<Integer>> queue = new LinkedListQueue<>();
      queue.enqueue(tmp);
      for (int l = 0; l < t.depth(); l ++) {
         int size = queue.size();
         for (int n = 0; n < size; n++){
            tmp = queue.dequeue();
            if (tmp.getLeft() != null) queue.enqueue(tmp.getLeft());
            if (tmp.getRight() != null) queue.enqueue(tmp.getRight());
            list[l] += tmp.getValue();
         }
      }
      return list;
   }
}