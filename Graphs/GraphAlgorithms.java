import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Map;
import java.util.HashMap;

// Wrapper class for some graph algorithms and tests. This is a work in progress.
// Part of its function is to just implement these algorithms. Another part is to 
// help better understand them and their implementation. 
// More will be added -jrg
//
class GraphAlgorithms {

   // minimum spanning tree algorithm - greedy
   public static Integer[][] getMinimumSpan(DiGraphNode[] graph, int s){
      if (graph == null || graph.length == 0 || s < 0 || s > graph.length) 
         return new Integer[0][0];

      Integer[][] pAndw = new Integer[2][graph.length];

      Queue<WeightedEdge> pqueue = new PriorityQueue<WeightedEdge>( (a,b) -> a.getWeight() - b.getWeight());
      Map<DiGraphNode,Integer> map = new HashMap<DiGraphNode,Integer>();

      for (WeightedEdge e : graph[s].getEdges())
         pqueue.add(e);

      for (int i = 0; i < graph.length; i++)
         map.put(graph[i], i);

      pAndw[0][s] = -1;
      pAndw[1][s] = 0;

      while (!pqueue.isEmpty()){
         WeightedEdge e = pqueue.remove();
         int ui = map.get(e.getU());
         int vi = map.get(e.getV());
         if (pAndw[0][vi] != null) continue;
         pAndw[0][vi] = ui;
         pAndw[1][vi] = pAndw[1][ui] + e.getWeight();
         for (WeightedEdge v : e.getV().getEdges())
            pqueue.add(v);
      }
      return pAndw;
   }

   // Bellman-Ford shortest paths algorithm - dynamic programming
   public static boolean bellmanFord(DiGraphNode[] G, Integer[][] predecessor, int s){
      // we want to fail if,...
      if (G == null || G.length == 0)
         throw new IllegalArgumentException("null or empty graph");
      if (predecessor == null)
         throw new IllegalArgumentException("null predecessor");
      if (predecessor[0].length != G.length || predecessor.length != 2)
         throw new IllegalArgumentException("invalid predecessor dimensions");
      if (s < 0 || s >= G.length)
         throw new IllegalArgumentException("start node out of range");

      int vertices = G.length;
      int d = 0;  // distance/weight
      int p = 1;  // parent
    
      Map<DiGraphNode, Integer> map = new HashMap<DiGraphNode, Integer>();

      // init the predecessor (and weight) matrix
      for (int i = 0; i < vertices; i++){
         map.put(G[i], i);
         predecessor[d][i] = null;
         predecessor[p][i] = null;
      }
      // init the start vert.
      predecessor[d][s] = 0;

      //Bellman-Ford core
      for (int i = 0; i < vertices; i++){
         for (DiGraphNode n : G){
            int u = map.get(n);
            for (WeightedEdge e : n.getEdges()){
               int v = map.get(e.getV());
               int w = e.getWeight();
               Integer uw = (predecessor[d][u] == null) ? null : w + predecessor[d][u];
               if (uw == null) continue;
               if ((predecessor[d][v] == null) 
                || (predecessor[d][v] != null && predecessor[d][v] > uw)){ 
                  predecessor[d][v] = uw;
                  predecessor[p][v] = u;
               }
            }
         }
      }
      // check for a negative weight cycle
      for (DiGraphNode n : G){
         int u = map.get(n);
         for (WeightedEdge e : n.getEdges()){
            int v = map.get(e.getV());
            int w = e.getWeight();
            Integer uw = (predecessor[d][u] == null) ? null : w + predecessor[d][u];
            if (uw == null) continue;
            if ((predecessor[d][v] == null) 
             || (predecessor[d][v] != null && predecessor[d][v] > uw)){
               // return false - we have a negative weight cycle
               return false;
            }
         }
      }
      // return true for successful 
      return true;
   }

   // Create the graph in Cormen 24.2, for testing
   public static DiGraphNode[] createGraph24point2(){
      DiGraphNode[] adjList = new DiGraphNode[5];

      DGraphNode s = new DGraphNode("s");
      DGraphNode t = new DGraphNode("t");
      DGraphNode x = new DGraphNode("x");
      DGraphNode y = new DGraphNode("y");
      DGraphNode z = new DGraphNode("z");

      s.addEdge(new Edge(s, t, 3));
      s.addEdge(new Edge(s, y, 5));
      t.addEdge(new Edge(t, x, 6));
      t.addEdge(new Edge(t, y, 2));
      y.addEdge(new Edge(y, t, 1));
      y.addEdge(new Edge(y, x, 4));
      y.addEdge(new Edge(y, z, 6));
      x.addEdge(new Edge(x, z, 2));
      z.addEdge(new Edge(z, x, 7));
      z.addEdge(new Edge(z, s, 3));

      adjList[0] = s;
      adjList[1] = t;
      adjList[2] = x;
      adjList[3] = y;
      adjList[4] = z;

      return adjList;
   }

   // create another graph from Cormen chp 24, for testing
   public static DiGraphNode[] createGraph24pointX(){
      DiGraphNode[] adjList = new DiGraphNode[5];

      DGraphNode s = new DGraphNode("s");
      DGraphNode t = new DGraphNode("t");
      DGraphNode x = new DGraphNode("x");
      DGraphNode y = new DGraphNode("y");
      DGraphNode z = new DGraphNode("z");

      s.addEdge(new Edge(s, t, 6));
      s.addEdge(new Edge(s, y, 7));
      t.addEdge(new Edge(t, x, 3));
      t.addEdge(new Edge(t, y, 8));
      t.addEdge(new Edge(t, z, -4));
      y.addEdge(new Edge(y, x, -3));
      y.addEdge(new Edge(y, z, 9));
      x.addEdge(new Edge(x, t, -2));
      z.addEdge(new Edge(z, x, 7));
      z.addEdge(new Edge(z, s, 2));

      adjList[0] = s;
      adjList[1] = t;
      adjList[2] = x;
      adjList[3] = y;
      adjList[4] = z;

      return adjList;
   }

   // method to print out an array of T
   public static <T> void print(T[] t){
      System.out.print("[");
      for (int i = 0; t != null && i < t.length; i++){
         if (i+1 < t.length)
            System.out.print(t[i] + ", ");
         else
            System.out.print(t[i]);
      }
      System.out.println("]");
   }

   // method to print out a 2D array of T
   public static <T> void print(T[][] t){
      for (T[] row : t)
         print(row);
   }

   // main entry to run a few tests
   public static void main(String[] args){
      // get a directed graph
      DiGraphNode[] adjacencyList = createGraph24point2();
      // get the minimum spanning tree
      Integer[][] pAndw = getMinimumSpan(adjacencyList, 0);
      System.out.println("Minimum spanning tree");
      // print the graph nodes in order of the adjacency list
      print(adjacencyList);
      // print the predecessor matrix
      print(pAndw);

      System.out.println();

      // get another graph
      adjacencyList = createGraph24pointX();
      // create a predecessor matrix to pass in
      pAndw = new Integer[2][adjacencyList.length];
      // run Bellman-Ford against the graph
      boolean status = bellmanFord(adjacencyList, pAndw, 0);
      System.out.println("Bellman-Ford success = " + status);
      // print the graph nodes in order of the adjacency list
      print(adjacencyList);
      // print the predecessor matrix
      print(pAndw);
   }
}
