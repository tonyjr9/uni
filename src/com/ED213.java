package com;

public class ED213 {
    public static String maxSum(BTree<Integer> t) {
        if (t == null || t.isEmpty()) return "";

        StringBuilder bestPath = new StringBuilder();
        int[] maxSum = new int[] {Integer.MIN_VALUE};

        findMaxPath(t.getRoot(), 0, new StringBuilder(), bestPath, maxSum);
        return bestPath.toString();
    }

    private static void findMaxPath(BTNode<Integer> node, int currentSum, StringBuilder currentPath, 
        StringBuilder bestPath, int[] maxSum) {
        if (node == null) return;

        currentSum += node.getValue();

        if (node.getLeft() == null && node.getRight() == null) {
            if (currentSum > maxSum[0]) {
                maxSum[0] = currentSum;
                bestPath.setLength(0);
                bestPath.append(currentPath);
            }
            return;
        }

        if (node.getLeft() != null) {
            currentPath.append('E'); 
            findMaxPath(node.getLeft(), currentSum, currentPath, bestPath, maxSum);
            currentPath.deleteCharAt(currentPath.length() - 1);
        }

        if (node.getRight() != null) {
            currentPath.append('D');
            findMaxPath(node.getRight(), currentSum, currentPath, bestPath, maxSum);
            currentPath.deleteCharAt(currentPath.length() - 1);
        }
    }
}
