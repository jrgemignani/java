// LeetCode Binary Tree Level Order Transversal
// O(n) time complexity
//

import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

class BinaryTreeLevelOrderTransveral {

   // helper method to print out the list of lists
   private static <T> void print(List<List<T>> lols){
      System.out.println("[");
      for(List<T> list : lols){
         System.out.print("[");
         int len = list.size();
         for(int i = 0; i < len; i++){
            if (i+1 < len)
               System.out.print(list.get(i) + ", ");
            else
               System.out.print(list.get(i));
         }
         System.out.println("]");
      }
      System.out.println("]");
   }

   // method to create a list of lists with each list being the nodes for 
   // that specific level
   private static <T> List<List<T>> levelOrder(TreeNode<T> root){
      // if passed a null, return a null
      if (root == null) return null;

      // create a queue for BFS
      Queue<TreeNode<T>> bfs = new LinkedList<TreeNode<T>>();
      // create the list of lists to hold the levels
      List<List<T>> levels = new ArrayList<List<T>>();
      // create a map for keeping track of the levels
      Map<TreeNode<T>, Integer> map = new HashMap<TreeNode<T>, Integer>();

      // put in the root, and it's level - 0
      bfs.add(root);
      map.put(root, 0);

      // perform a BFS, storing the nodes for each level expanded
      while(!bfs.isEmpty()){
         TreeNode<T> node = bfs.remove();
         TreeNode<T> left = node.getLeftChild();
         TreeNode<T> right = node.getRightChild();
         T value = node.getValue();

         int level = map.get(node);
         if (left != null){
            bfs.add(left);
            map.put(left, level+1);
         }
         if (right != null){
            bfs.add(right);
            map.put(right, level+1);
         }

         if (level == levels.size())
            levels.add(new ArrayList<T>());

         levels.get(level).add(value);
      }
      return levels;
   }

   // helper function to print out the integer array
   private static <T> void print(T[] array){
      System.out.print("[");
      for (int i = 0; i < array.length; i++){
         if (i+1 < array.length)
            System.out.print(array[i] + ", ");
         else
            System.out.println(array[i] + "]");
      }
   }

   private static <T extends Comparable<T>> void test(T[][] ts){
      for (T[] t : ts){
         print(t);
         TreeNode<T> root = TreeNode.<T>createTree(t);
         List<List<T>> levels = levelOrder(root);
         print(levels);
         System.out.println();
      }
   }

   public static void main(String[] args){
      Integer[] bt1 = {3, 9, 20, null, null, 15, 7};
      Integer[] bt2 = {3, 9, 20, null, null, 15, 7, null, null, null, null, 18};
      Integer[][] bt1s = {bt1, bt2};

      Double[] bt21 = {3.0, 9.0, 20.0, null, null, 15.0, 7.0};
      Double[] bt22 = {3.1, 9.1, 20.1, null, null, 15.1, 7.1, null, null, null, null, 18.1};
      Double[][] bt2s = {bt21, bt22};

      test(bt1s);
      test(bt2s);
   }
}
