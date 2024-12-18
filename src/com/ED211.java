package com;

public class ED211 {
    public static int countEven(BTree<Integer> t){
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
}
