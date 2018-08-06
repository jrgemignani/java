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
   private static void print(List<List<Integer>> lols){
      System.out.println("[");
      for(List<Integer> list : lols){
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
   private static List<List<Integer>> levelOrder(TreeNode<Integer> root){
      // if passed a null, return a null
      if (root == null) return null;

      // create a queue for BFS
      Queue<TreeNode<Integer>> bfs = new LinkedList<TreeNode<Integer>>();
      // create the list of lists to hold the levels
      List<List<Integer>> levels = new ArrayList<List<Integer>>();
      // create a map for keeping track of the levels
      Map<TreeNode<Integer>, Integer> map = new HashMap<TreeNode<Integer>, Integer>();

      // put in the root, and it's level - 0
      bfs.add(root);
      map.put(root, 0);

      // perform a BFS, storing the nodes for each level expanded
      while(!bfs.isEmpty()){
         TreeNode<Integer> node = bfs.remove();
         TreeNode<Integer> left = node.getLeftChild();
         TreeNode<Integer> right = node.getRightChild();
         Integer value = node.getValue();

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
            levels.add(new ArrayList<Integer>());

         levels.get(level).add(value);
      }
      return levels;
   }

   // helper function to print out the integer array
   private static void print(Integer[] array){
      System.out.print("[");
      for (int i = 0; i < array.length; i++){
         if (i+1 < array.length)
            System.out.print(array[i] + ", ");
         else
            System.out.println(array[i] + "]");
      }
   }

   public static void main(String[] args){
      Integer[] bt1 = {3, 9, 20, null, null, 15, 7};
      Integer[] bt2 = {3, 9, 20, null, null, 15, 7, null, null, null, null, 18};
      Integer[][] bts = {bt1, bt2};

      for (Integer[] bt : bts){
         print(bt);
         TreeNode<Integer> root = TreeNode.<Integer>createTree(bt);
         List<List<Integer>> levels = levelOrder(root);
         print(levels);
         System.out.println();
      }
   }
}
