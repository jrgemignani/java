import java.util.Map;
import java.util.HashMap;

class MaximumBTDepth {

   private static class TreeNode {
      private TreeNode left = null;
      private TreeNode right = null;
      private final int val;
      private TreeNode(int val){
         this.val = val;
      }
   }

   private static TreeNode createTree(Integer[] btreeArray){
      if (btreeArray == null) return null;

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

   private static int maxDepth(TreeNode root){
      if (root == null) return 0;

      int lmax = 1 + maxDepth(root.left);
      int rmax = 1 + maxDepth(root.right);
      return (lmax >= rmax) ? lmax : rmax;
   }

   public static void main(String[] args){
      Integer[] bt = {3, 9, 20, null, null, 15, 7, null, null, null, null, 18};

      TreeNode root = createTree(bt);

      int max = maxDepth(root);
      System.out.println("maxDepth(root) = " + max);
   }
}
