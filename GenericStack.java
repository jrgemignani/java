// Generic Stack implementation using a linked list
// -jrg

import java.util.EmptyStackException;

class GenericStack<E> {
   private Link<E> stack = null;

   static private class Link<E>{
      private final E data;
      private final Link<E> next;

      private Link(E data, Link<E> next){
         this.data = data;
         this.next = next;
      }
   }

   public GenericStack(){}

   public boolean isEmpty(){
      return (stack == null);
   }

   public void push(E data){
      stack = new Link<E>(data, stack);
   }

   public E pop() throws EmptyStackException{
      if (isEmpty())
         throw new EmptyStackException();
      E data = stack.data;
      stack = stack.next;
      return data;
   }
   
   public E peek() throws EmptyStackException{
      if (isEmpty())
         throw new EmptyStackException();
      return stack.data;
   }

   public static void main(String[] args) throws EmptyStackException{
      GenericStack<Integer> mStack1 = new GenericStack<Integer>();
      GenericStack<Double> mStack2 = new GenericStack<Double>();

      for (int i = 0; i < 10; i++){
         int odd = 2*i +1;
         System.out.println("push(" + odd + ")");
         mStack1.push(odd);
      }
      for (int i = 0; i < 10; i++){
         double even = 2*i;
         System.out.println("push(" + even + ")");
         mStack2.push(even);
      }

      while (!mStack1.isEmpty()){
         System.out.println("pop() = " + mStack1.pop());
      }
      while (!mStack2.isEmpty()){
         System.out.println("pop() = " + mStack2.pop());
      }

      //mStack1.peek();

   }
}
