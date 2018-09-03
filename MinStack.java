import java.util.Stack;

class MinStack<T extends Comparable<T>>{
   private Stack<T> stack = new Stack<T>();
   private Stack<T> min = new Stack<T>();

   public void push(T data){
      if (min.isEmpty() || (min.peek().compareTo(data) >= 0))
         min.push(data);
      stack.push(data);
   }

   public T pop(){
      if (stack.isEmpty()) return null;
      if (min.peek().compareTo(stack.peek()) == 0)
         min.pop();
      return stack.pop();
   }

   public T top(){
      return (stack.isEmpty()) ? null : stack.peek();
   }

   public T getMin(){
      return (min.isEmpty()) ? null : min.peek();
   }

   public static void main(String[] args){
      MinStack<Integer> minStack = new MinStack<Integer>();
      minStack.push(-2);
      minStack.push(0);
      minStack.push(-3);
      System.out.println(minStack.getMin());
      minStack.pop();
      System.out.println(minStack.top());
      System.out.println(minStack.getMin());
   }
}
