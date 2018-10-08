// Weighted edge implementation for a directed graph node
class Edge implements WeightedEdge {
   private final DiGraphNode u;
   private final DiGraphNode v;
   private final int weight;

   public Edge(DiGraphNode u, DiGraphNode v, int weight){
      this.u = u;
      this.v = v;
      this.weight = weight;
   }
   @Override
   public DiGraphNode getU(){
      return u;
   }
   @Override
   public DiGraphNode getV(){
      return v;
   }
   @Override
   public int getWeight(){
      return weight;
   }
}
