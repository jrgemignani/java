import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

class CloneGraph {

   private static class UndirectedGraphNode {
      int label;
      private List<UndirectedGraphNode> neighbors;
      UndirectedGraphNode(int label){
         this.label = label;
         this.neighbors = new ArrayList<UndirectedGraphNode>();
      }
   }

   // BFS clone method
   public UndirectedGraphNode cloneGraph(UndirectedGraphNode node){
      if (node == null) return null;

      Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
      Set<UndirectedGraphNode> visited = new HashSet<UndirectedGraphNode>();
      Map<Integer, UndirectedGraphNode> nodes = new HashMap<Integer, UndirectedGraphNode>();

      int head = node.label;
      queue.add(node);
      while (!queue.isEmpty()){
         UndirectedGraphNode curr = queue.remove();
         if (visited.contains(curr)) continue;
         visited.add(curr);
         UndirectedGraphNode clone = nodes.get(curr.label);
         if (clone == null){
            clone = new UndirectedGraphNode(curr.label);
            nodes.put(curr.label, clone);
         }
         for (UndirectedGraphNode neighbor : curr.neighbors){
            UndirectedGraphNode clonei = nodes.get(neighbor.label);
            if (clonei == null){
               clonei = new UndirectedGraphNode(neighbor.label);
               nodes.put(neighbor.label, clonei);
            }
            clone.neighbors.add(clonei);
            queue.add(neighbor);
         }
      }
      return nodes.get(head);
   }
}
