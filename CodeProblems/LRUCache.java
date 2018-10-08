import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.LinkedList;

class LRUCache<K,V> {
   
   private static class Entry<K,V> {
      private final K key;
      private final V value;

      private Entry(K key, V value){
         this.key = key;
         this.value = value;
      }
   }

   private final Map<K,Entry<K,V>> members;
   private final List<Entry<K,V>> cache;
   private final int capacity;

   public LRUCache(int capacity){
      this.capacity = capacity;
      this.members = new HashMap<K,Entry<K,V>>();
      this.cache = new LinkedList<Entry<K,V>>();
   }

   private void update(K key, V value){
      Entry<K,V> entry = members.get(key);
      list.remove(entry);
   }

   private void evict(){
   }
}
