import java.util.Stack;
import java.util.Set;
import java.util.HashSet;
import java.util.NoSuchElementException;

class KthSmallestBST {

   private static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
   }

   // 1st attempt
   // per problem, assuming a valid BS tree and valid k. so, no input
   // or bounds checks.
   public int kthSmallestBST1(TreeNode root, int k){
      Stack<TreeNode> stack = new Stack<TreeNode>();
      Set<TreeNode> visited = new HashSet<TreeNode>();

      int visits = 0;
      int value = 0;
      stack.push(root);

      while (visits != k) {
         TreeNode parent = stack.pop();
         if (visited.contains(parent)){
            visits++;
            value = parent.val;
            continue;
         }
         visited.add(parent);
         if (parent.right != null) stack.push(parent.right);
         stack.push(parent);
         if (parent.left != null) stack.push(parent.left);
      }

      return value;
   }
  
   // 2nd attempt
   public int kthSmallestBST2(TreeNode root, int k){
      if (root == null) 
         throw new NullPointerException("TreeNode root is null");
      if (k < 1)
         throw new IllegalArgumentException("Invalid k value < 1");

      Stack<TreeNode> stack = new Stack<TreeNode>();
      TreeNode curr = root;
      int visits = 0;
     
      // in order traversal DFS
      while (curr != null){
         while (curr != null){ 
            stack.push(curr);
            curr = curr.left;
         }
         while (curr == null && !stack.isEmpty()){
            curr = stack.pop();
            visits++;
            if (visits == k) return curr.val;
            curr = curr.right;
         }
      }
      if (curr == null)
         throw new NoSuchElementException("No element was found for given k");

      return -1;
   }

   int visits = 0;
   int value = 0;
   public int kthSmallestBST3(TreeNode root, int k){
      if (root == null) return value;
      kthSmallestBST3(root.left, k);
      visits++;
      if (visits == k) value = root.val;
      kthSmallestBST3(root.right, k);
      return value;
   }
}
