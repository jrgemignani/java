import java.util.List;

// interface for a directed graph node
interface DiGraphNode {
   // the node label
   public String getLabel();
   // the list of weighted edges
   public List<WeightedEdge> getEdges();
   // the toString method
   public String toString();
}
