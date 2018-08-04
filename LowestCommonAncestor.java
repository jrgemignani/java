// LeetCode to find lowest common ancestor
//

import java.util.Stack;
import java.util.Map;
import java.util.HashMap;

class LowestCommonAncestor{

   // define our tree node class
   private static class TreeNode {
      private TreeNode left = null;
      private TreeNode right = null;
      private final int val;
      private TreeNode(int val){
         this.val = val;
      }
   }

   // create a tree from a binary tree array representation
   private static TreeNode createTree(Integer[] btreeArray){
      // if passed parameter is null, return null
      if (btreeArray == null) return null;

      // use a map to keep track of the nodes in the tree
      Map<Integer, TreeNode> map = new HashMap<Integer, TreeNode>();
      // load the map with the nodes
      for (Integer val : btreeArray){
         if (val != null){
            TreeNode node = new TreeNode(val);
            map.put(val, node);
         }
      }
      // connect the children
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
      // return the root
      return map.get(btreeArray[0]);
   }

   // recursively decend the tree to find p and q and their lowest parent
   public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
      // if any passed parameters are null, return null
      if (root == null || p == null || q == null) return null;

      // go down the left side until there isn't a left node
      TreeNode left = lowestCommonAncestor(root.left, p, q);
      // go down the right side until there isn't a right node
      TreeNode right = lowestCommonAncestor(root.right, p, q);

      // if it is a leaf and is either p or q, return the node
      if (left == null && right == null && (root == p || root == q)) return root;
      // if the left and right are p and q, return the node
      if ((left == p && right == q) || (left == q && right == p)) return root;
      // if the node is either p or q, return the node
      if (root == p || root == q) return root;
      // if the left isn't null, then it is p, q, or their parent, return it
      if (left != null) return left;
      // if the right isn't null, then it is p, q, or their parent, return it
      if (right != null) return right;
      // otherwise return null
      return null;
   }

   // helper method to find a node, by it's value, in the tree
   private static TreeNode find(TreeNode root, int val){
      if (root == null) return null;
      if (root.val == val) return root;
      TreeNode temp = find(root.left, val);
      if (temp != null) return temp;
      return find(root.right, val);
   }

   // helper method to print a node
   private static void print(TreeNode node){
      System.out.print("[");
      if (node != null) 
         System.out.print(node.val);
      System.out.println("]");
   }

   // main entry point, runs a test against a predefined tree.
   public static void main(String[] args){
      Integer[] bta = {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
      TreeNode root = createTree(bta);

      TreeNode p = find(root, 6);
      print(p);
      TreeNode q = find(root, 4);
      print(q);

      TreeNode lca = lowestCommonAncestor(root, p, q);
      print(lca);
   }
}
