package com;

public class ED212 {
   public static int[] sumLevels(BTree<Integer> t){
      int[] list = new int[t.depth() + 1];
      BTNode<Integer> tmp = t.getRoot();
      MyQueue<BTNode<Integer>> queue = new LinkedListQueue<>();
      queue.enqueue(tmp);
      for (int l = 0; l <= t.depth() ; l ++) {
         int sum = 0;
         int size = queue.size();
         for (int n = 0; n < size; n++){
            tmp = queue.dequeue();
            if (tmp.getLeft() != null) queue.enqueue(tmp.getLeft());
            if (tmp.getRight() != null) queue.enqueue(tmp.getRight());
            sum += tmp.getValue();
         }
         list[l] = sum;
      }
      return list;
   }
}
