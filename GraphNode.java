import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

// Generic Graph node class
class GraphNode<T> {

   private final T data;
   private final List<GraphNode<T>> children;

   public GraphNode(T data){
      this.data = data;
      children = new ArrayList<GraphNode<T>>();
   }

   public T getData(){
      return data;
   }

   public List<GraphNode<T>> getChildren(){
      return Collections.unmodifiableList(children);
   }

   public void addChild(GraphNode<T> node){
      children.add(node);
   }
}
