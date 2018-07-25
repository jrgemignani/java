// Generic Queue implementation using a linked list
// -jrg

import java.util.NoSuchElementException;

class GenericQueue<E> {
   private Link<E> queueHead = null;
   private Link<E> queueTail = null;

   static private class Link<E>{
      private final E data;
      private Link<E> next;

      private Link(E data, Link<E> next){
         this.data = data;
         this.next = next;
      }
   }

   public GenericQueue(){}

   public boolean isEmpty(){
      return (queueHead == null);
   }

   public void add(E data){
      Link<E> link = new Link<E>(data, null);
      if (queueTail != null)
         queueTail.next = link;
      else
         queueHead = link;
      queueTail = link;
   }

   public E remove() throws NoSuchElementException{
      if (isEmpty())
         throw new NoSuchElementException();

      E data = queueHead.data;
      queueHead = queueHead.next;
      if (queueHead == null)
         queueTail = null;
      return data;
   }

   public E poll(){
      if (isEmpty()) return null;

      E data = queueHead.data;
      queueHead = queueHead.next;
      if (queueHead == null)
         queueTail = null;
      return data;

   }
   
   public E peek(){
      if (isEmpty()) return null;
      return queueHead.data;
   }

   public static void main(String[] args) throws Exception{
      GenericQueue<Integer> mQueue1 = new GenericQueue<Integer>();
      GenericQueue<Double> mQueue2 = new GenericQueue<Double>();

      for (int i = 0; i < 10; i++){
         int odd = 2*i +1;
         System.out.println("add(" + odd + ")");
         mQueue1.add(odd);
      }
      for (int i = 0; i < 10; i++){
         double even = 2*i;
         System.out.println("add(" + even + ")");
         mQueue2.add(even);
      }

      while (!mQueue1.isEmpty()){
         System.out.println("remove() = " + mQueue1.remove());
      }
      while (!mQueue2.isEmpty()){
         System.out.println("poll() = " + mQueue2.poll());
      }

   }
}
