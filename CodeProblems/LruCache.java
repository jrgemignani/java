// LeetCode LRU Cache, the generic version.
// -jrg

import java.util.Map;
import java.util.HashMap;
import java.util.NoSuchElementException;

class LruCache<K,V>{

   private static class Element<K,V>{
      private Element<K,V> prev = null;
      private Element<K,V> next = null;
      private final K key;
      private final V value;

      private Element(K key, V value){
         this.key = key;
         this.value = value;
      }
   }

   private final Map<K, Element<K,V>> map = new HashMap<K, Element<K,V>>();
   private Element<K,V> cacheHead = null;
   private Element<K,V> cacheTail = null;
   private final int capacity;
   private int size = 0;

   public LruCache(int capacity) throws IllegalArgumentException{
      if (capacity <= 0){
         String exception = "LruCache: invalid cache size [" + 
            capacity + "] needs to be > 0";
         throw new IllegalArgumentException(exception);
      }
      this.capacity = capacity;
   }

   private void add(Element<K,V> element){
      if (cacheTail == null){
         cacheTail = element;
         cacheHead = element;
      }
      else{
         cacheTail.next = element;
         element.prev = cacheTail;
         cacheTail = element;
      }
      if (size < capacity){
         size++;
      }
      else{
         map.remove(cacheHead.key);
         cacheHead = cacheHead.next;
      }
      map.put(element.key, element);
   }

   private void update(Element<K,V> element){
      if (element.prev != null){
         element.prev.next = element.next;
      }
      else{
         cacheHead = element.next;
      }
      if (element.next != null){
         element.next.prev = element.prev;
      }
      else{
         cacheTail = element.prev;
      }
      size--;
      add(element);
   }

   public void put(K key, V value) throws NullPointerException{
      if (key == null) 
         throw new NullPointerException("null key");

      if (!map.containsKey(key)){
         add(new Element<K,V>(key, value));
      }
      else{
         update(map.get(key));
      }
   }

   public V get(K key) throws NullPointerException, NoSuchElementException{
      if (key == null)
         throw new NullPointerException("null key");

      if (map.containsKey(key)){
         Element<K,V> element = map.get(key);
         update(element);
         return element.value;
      }
      else{
         String exception = "Key [" + key + "] does not exist";
         throw new NoSuchElementException(exception);
      }
   }
}
