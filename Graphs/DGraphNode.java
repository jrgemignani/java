import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

// implementation for a directed graph node with weighted edges. 
class DGraphNode implements DiGraphNode {
   private final String label;
   private final List<WeightedEdge> edges;
   
   public DGraphNode(String label){
      this.label = label;
      this.edges = new ArrayList<WeightedEdge>();
   }

   public boolean addEdge(WeightedEdge edge){
      if (edges == null) return false;
      this.edges.add(edge);
      return true;
   }

   @Override
   public String getLabel(){
      return label;
   }

   @Override
   public List<WeightedEdge> getEdges(){
      return Collections.unmodifiableList(edges);
   }

   @Override
   public String toString(){
      return label;
   }
}
