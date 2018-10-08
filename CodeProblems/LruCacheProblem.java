// LeetCode LRU Cache problem, uses the generic LRU Cache data structure
// and wraps it for use as an Integer cache.
// -jrg

import java.util.NoSuchElementException;

class LruCacheProblem {

   private final LruCache<Integer, Integer> cache;

   public LruCacheProblem(int capacity){
      this.cache = new LruCache<Integer, Integer>(capacity);
   }

   public Integer get(Integer key) throws NullPointerException {
      if (key == null)
         throw new NullPointerException("null key");

      Integer value = null;
      try{
         value = this.cache.get(key);
         
      }
      catch (NoSuchElementException e){
         value = -1;
      }
      finally {
      }
      return value;
   }

   public void put(Integer key, Integer value){
      this.cache.put(key, value);
   }

   public static void main(String[] args){
      LruCacheProblem cache = new LruCacheProblem(2);

      cache.put(1, 1);
      cache.put(2, 2);

      System.out.println("get(1) = " + cache.get(1));       // returns 1

      cache.put(3, 3);                                      // evicts key 2

      System.out.println("get(2) = " + cache.get(2));       // returns -1 (not found)

      cache.put(4, 4);                                      // evicts key 1

      System.out.println("get(1) = " + cache.get(1));       // returns -1 (not found)
      System.out.println("get(3) = " + cache.get(3));       // returns 3
      System.out.println("get(4) = " + cache.get(4));       // returns 4
   }
}
