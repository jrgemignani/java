// Generic TreeNode class for help with LeetCode problems. But, not 
// completely compatible with them.
// It contains methods for building TreeNode trees from Binary Tree 
// arrays print the node values. It is expected that the nodes of 
// the tree have unique values.
//

import java.util.Map;
import java.util.HashMap;

//public class TreeNode<T extends Comparable<T>> {
public class TreeNode<T> {

   private TreeNode<T> left = null;
   private TreeNode<T> right = null;
   private final T value;

   public TreeNode(T value){
      this.value = value;
   }

   public TreeNode<T> getLeftChild(){
      return this.left;
   }

   public TreeNode<T> getRightChild(){
      return this.right;
   }

   public T getValue(){
      return this.value;
   }

   @Override
   public String toString(){
      return "[" + this.value + "]";
   }

   // method to create a tree from a binary tree array
   public static <U extends Comparable<U>> TreeNode<U> createTree(U[] btreeArray){
      // return null if null BT array is passed
      if (btreeArray == null || btreeArray.length == 0) return null;

      // create a map of node value to TreeNode 
      Map<U, TreeNode<U>> map = new HashMap<U, TreeNode<U>>();
      // iterate through the BT array and create the TreeNodes
      for (U value : btreeArray){
         if (value != null){
            TreeNode<U> node = new TreeNode<U>(value);
            map.put(value, node);
         }
      }
      // now iterate and add the links to the children
      int len = btreeArray.length;
      for (int i = 0; i < len; i++){
         if (btreeArray[i] == null) continue;
         TreeNode<U> node = map.get(btreeArray[i]);
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
   public static <U extends Comparable<U>> TreeNode<U> findNode(TreeNode<U> root, U value){
      // if the node is null, return null
      if (root == null) return null;
      // if the node value equals the passed value, return the node
      if (root.value.compareTo(value) == 0) return root;
      // check left side
      TreeNode<U> temp = findNode(root.left, value);
      if (temp != null) return temp;
      // check right side
      return findNode(root.right, value);
   }
}
