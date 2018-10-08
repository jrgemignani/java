import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;
import java.util.Stack;

// Generic Graph utilities class
class GraphUtils {

   // Visit function, also the target function
   private static class Visit<T extends Comparable<T>> implements VisitFunction<T> {

      private final T stopValue;
      private Visit(T stopValue){
         this.stopValue = stopValue;
      }

      @Override
      public boolean visit(GraphNode<T> node){
         System.out.println("Node data = " + node);
         return (stopValue.compareTo(node.getData()) == 0);
      }
   }

   // Iterative BFS 
   public static <T> boolean BFS(GraphNode<T> root, VisitFunction<T> function){
      if (root == null) return false;

      Queue<GraphNode<T>> queue = new LinkedList<GraphNode<T>>();
      Set<GraphNode<T>> set = new HashSet<GraphNode<T>>();

      queue.add(root);
      while (!queue.isEmpty()){
         GraphNode<T> parent = queue.remove();
         if (set.contains(parent)) continue;
         set.add(parent);
         if (function.visit(parent)) return true;

         List<GraphNode<T>> children = parent.getChildren();
         for (GraphNode<T> child : children)
            queue.add(child);
      }
      return false;
   }

   public static <T> boolean DFS(GraphNode<T> root, VisitFunction<T> function){
      if (root == null) return false;

      Stack<GraphNode<T>> stack = new Stack<GraphNode<T>>();
      Set<GraphNode<T>> set = new HashSet<GraphNode<T>>();

      stack.push(root);
      while (!stack.isEmpty()){
         GraphNode<T> parent = stack.pop();
         if (set.contains(parent)) continue;
         set.add(parent);
         if (function.visit(parent)) return true;

         List<GraphNode<T>> children = parent.getChildren();
         for (GraphNode<T> child : children)
            stack.push(child);
      }
      return false;
   }

   private static GraphNode<Integer> createTestGraph(){
      GraphNode<Integer> root = new GraphNode<Integer>(0);
      GraphNode<Integer> node1 = new GraphNode<Integer>(1);
      GraphNode<Integer> node2 = new GraphNode<Integer>(2);
      GraphNode<Integer> node3 = new GraphNode<Integer>(3);
      GraphNode<Integer> node4 = new GraphNode<Integer>(4);
      GraphNode<Integer> node5 = new GraphNode<Integer>(5);
      GraphNode<Integer> node6 = new GraphNode<Integer>(6); 
      GraphNode<Integer> node7 = new GraphNode<Integer>(7);
      GraphNode<Integer> node8 = new GraphNode<Integer>(8);
      GraphNode<Integer> node9 = new GraphNode<Integer>(9);

      root.addChild(node1);
      root.addChild(node2);
      root.addChild(node3);
      node1.addChild(node4);
      node1.addChild(node5);
      node2.addChild(node6);
      node2.addChild(node7);
      node2.addChild(node8);
      node3.addChild(node8);
      node3.addChild(node9);
      
      return root;
   }

   public static void main(String[] args){
      GraphNode<Integer> root = createTestGraph();
      VisitFunction<Integer> function = new Visit<Integer>(8);

      System.out.println("BFS output for graph -");
      System.out.println(BFS(root, function));

      System.out.println("DFS output for graph -");
      System.out.println(DFS(root, function));
   }
}
