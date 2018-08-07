// Leetcode problem to list all paths from the root to a leaf node
// O(n) time and O(n) stack
//

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Map;
import java.util.HashMap;

public class BinaryTreePaths {

   private static class TreeNode {
      private TreeNode left = null;
      private TreeNode right = null;
      private final int val;
      private TreeNode(int val){
         this.val = val;
      }
   }

   // method to return a List of Strings representing all the paths 
   // from the root node of the tree to it's leaves. If the tree
   // is empty, it returns an empty list.
   private static List<String> binaryTreePaths(TreeNode root){
      List<String> paths = new ArrayList<String>();
      if (root == null) return paths;

      // we need a stack for dfs and for the paths
      Stack<TreeNode> dfsStack = new Stack<TreeNode>();
      Stack<String> pathStack = new Stack<String>();
      // initialize both stacks
      dfsStack.push(root);
      pathStack.push(String.valueOf(root.val));
      // while we still have nodes to process
      while(!dfsStack.isEmpty() && !pathStack.isEmpty()){
         TreeNode node = dfsStack.pop();
         String path = pathStack.pop();
         if (node.right != null){
            dfsStack.push(node.right);
            pathStack.push(path + "->" + String.valueOf(node.right.val));
         }
         if (node.left != null){
            dfsStack.push(node.left);
            pathStack.push(path + "->" + String.valueOf(node.left.val));
         }
         if (node.left == null && node.right == null){
            paths.add(path);
         }
      }
      return paths;
   }

   private static TreeNode createTree(Integer[] btreeArray){
      if (btreeArray == null || btreeArray.length == 0) return null;

      Map<Integer, TreeNode> map = new HashMap<Integer, TreeNode>();
      for (Integer val : btreeArray){
         if (val != null){
            TreeNode node = new TreeNode(val);
            map.put(val, node);
         }
      }
      int len = btreeArray.length;
      for (int i = 0; i < len; i++){
         if (btreeArray[i] == null) continue;
         TreeNode node = map.get(btreeArray[i]);
         int li = 2*i+1;
         int ri = 2*i+2;
         if (li < len && btreeArray[li] != null){
            node.left = map.get(btreeArray[li]);
         }
         if (ri < len && btreeArray[ri] != null){
            node.right = map.get(btreeArray[ri]);
         }
      }
      return map.get(btreeArray[0]);
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
         TreeNode root = createTree(bta);
         List<String> paths = binaryTreePaths(root);
         print(paths);
      }
   }
}
