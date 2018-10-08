// interface for a weighted edge in a directed graph
interface WeightedEdge {
   // get the value of u
   public DiGraphNode getU();
   // get the value of v
   public DiGraphNode getV();
   // get the weight of the edge
   public int getWeight();
}
