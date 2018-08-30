import java.util.NoSuchElementException;

class Heap {

   private final int[] heap;
   private final int capacity;
   private int next = 1;

   public Heap(int capacity) throws IllegalArgumentException {
      if (capacity < 2)
         throw new IllegalArgumentException("Minimum heap capacity must be > 1");
      this.capacity = capacity;
      heap = new int[capacity+1];
   }

   private int left(int i){
      return 2*i;
   }

   private int right(int i){
      return 2*i + 1;
   }
 
   private int parent(int i){
      return i/2;
   }

   private boolean hasHeapProperty(int p, int c){
      if (p < 1 || p >= next) return true;
      if (c < 1 || c >= next) return true;
      return (heap[p] < heap[c]);
   }

   private int remove(int i) throws IllegalArgumentException, NoSuchElementException {
      if (isEmpty())
         throw new IllegalArgumentException("Empty heap");
      if (i >= next)
         throw new NoSuchElementException("Invalid element");

      int value = heap[i];
      heap[i] = heap[next-1];
      next--;
      if (getSize() >1) heapifyDown(i);
      return value; 
   }

   private void heapifyDown(int i){
      if (isEmpty())
         throw new IllegalArgumentException("Empty heap");
      if (i < 1 || i >= next)
         throw new IllegalArgumentException("Out of range");
      if (next == 2) return;
     
      while (i < next && (!hasHeapProperty(i, left(i)) || !hasHeapProperty(i, right(i)))){
         int k = 0;
         int l = left(i);
         int r = right(i);

         if (!hasHeapProperty(i, l) && !hasHeapProperty(i, r))
            k = hasHeapProperty(l, r) ? l : r;
         else
            k = hasHeapProperty(i, l) ? r : l;

         int temp = heap[i];
         heap[i] = heap[k];
         heap[k] = temp;
         i = k;
      }
      
   }

   private void heapifyUp(int i) throws IllegalArgumentException {
      if (isEmpty())
         throw new IllegalArgumentException("Empty heap");
      if (i < 1 || i >= next)
         throw new IllegalArgumentException("Out of range");
      if (next == 2) return;

      while (i > 1 && !hasHeapProperty(parent(i), i)){
         int temp = heap[parent(i)];
         heap[parent(i)] = heap[i];
         heap[i] = temp;
         i = parent(i);
      }
   }

   public int getSize(){
      return this.next-1;
   }

   public int getCapacity(){
      return this.capacity;
   }

   public boolean isEmpty(){
      return (next == 1);
   }

   public void add(int value) throws IllegalArgumentException {
      if (next > capacity) 
         throw new IllegalArgumentException("Exceeded heap capacity");
      heap[next] = value;
      next++;
      if (!isEmpty()) heapifyUp(next-1);
   }

   public int remove() throws IllegalArgumentException {
      return remove(1);
   }

   public static void main(String[] args){
      Heap heap = new Heap(100);
      System.out.println("Capacity = " + heap.getCapacity());
      System.out.println("Size = " + heap.getSize());

      Integer[] A = {5, 3, 11, 1, 4, -1, -10, 20, 30, 25};
      for (Integer a : A){
         heap.add(a);
      }

      assert(heap.getSize() == A.length);
      System.out.println("Heap size = " + heap.getSize() + ", A size = " + A.length);

      while (!heap.isEmpty()){
         System.out.println("Minimum = " + heap.remove());
      } 
   }

}
