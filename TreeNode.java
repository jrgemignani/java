// Generic TreeNode class for help with LeetCode problems. But, not 
// completely compatible with them.
// It contains methods for building TreeNode trees from Binary Tree 
// arrays print the node values. It is expected that the nodes of 
// the tree have unique values.
//

import java.util.Map;
import java.util.HashMap;

public class TreeNode {

   private TreeNode left = null;
   private TreeNode right = null;
   private final int value;

   public TreeNode(int value){
      this.value = value;
   }

   public TreeNode getLeftChild(){
      return this.left;
   }

   public TreeNode getRightChild(){
      return this.right;
   }

   public int getValue(){
      return this.value;
   }

   @Override
   public String toString(){
      return "[" + this.value + "]";
   }

   // method to create a tree from a binary tree array
   public static TreeNode createTree(Integer[] btreeArray){
      // return null if null BT array is passed
      if (btreeArray == null) return null;

      // create a map of node value to TreeNode 
      Map<Integer, TreeNode> map = new HashMap<Integer, TreeNode>();
      // iterate through the BT array and create the TreeNodes
      for (Integer value : btreeArray){
         if (value != null){
            TreeNode node = new TreeNode(value);
            map.put(value, node);
         }
      }
      // now iterate and add the links to the children
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
      // return the root of the tree
      return map.get(btreeArray[0]);
   }

   // method to find a TreeNode, by it's value, in the tree
   public static TreeNode findNode(TreeNode root, int value){
      // if the node is null, return null
      if (root == null) return null;
      // if the node value equals the passed value, return the node
      if (root.value == value) return root;
      // check left side
      TreeNode temp = findNode(root.left, value);
      if (temp != null) return temp;
      // check right side
      return findNode(root.right, value);
   }
}
