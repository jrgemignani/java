// Leetcode problem to list all paths from the root to a leaf node
// O(n) time and O(n) stack
//

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Map;
import java.util.HashMap;

public class BinaryTreePaths {

   // method to return a List of Strings representing all the paths 
   // from the root node of the tree to it's leaves. If the tree
   // is empty, it returns an empty list.
   private static <T> List<String> binaryTreePaths(TreeNode<T> root){
      List<String> paths = new ArrayList<String>();
      if (root == null) return paths;

      // we need a stack for dfs and for the paths
      Stack<TreeNode<T>> dfsStack = new Stack<TreeNode<T>>();
      Stack<String> pathStack = new Stack<String>();
      // initialize both stacks
      dfsStack.push(root);
      pathStack.push(String.valueOf(root.getValue()));
      // while we still have nodes to process
      while(!dfsStack.isEmpty() && !pathStack.isEmpty()){
         TreeNode<T> node = dfsStack.pop();
         TreeNode<T> left = node.getLeftChild();
         TreeNode<T> right = node.getRightChild();
         String path = pathStack.pop();
         if (right != null){
            dfsStack.push(right);
            pathStack.push(path + "->" + String.valueOf(right.getValue()));
         }
         if (left != null){
            dfsStack.push(left);
            pathStack.push(path + "->" + String.valueOf(left.getValue()));
         }
         if (left == null && right == null){
            paths.add(path);
         }
      }
      return paths;
   }

   private static <T> void print(List<T> list){
      System.out.print("[");
      int len = (list == null) ? 0 : list.size();
      for (int i = 0; i < len; i++){
         if (i+1 < len)
            System.out.print("\"" + list.get(i) + "\", ");
         else 
            System.out.print("\"" + list.get(i) + "\"");
      }
      System.out.println("]");
   }

   public static void main(String[] args){
      Integer[] bta0 = {1, 2, 3, 5};
      Integer[] bta1 = {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
      Integer[] bta2 = {1, 2, 3};
      Integer[] bta3 = {1};
      Integer[] bta4 = {};
      Integer[] bta5 = null;
      Integer[][] btas = {bta0, bta1, bta2, bta3, bta4, bta5};

      for (Integer[] bta : btas){
         TreeNode<Integer> root = TreeNode.<Integer>createTree(bta);
         List<String> paths = binaryTreePaths(root);
         print(paths);
      }
   }
}
