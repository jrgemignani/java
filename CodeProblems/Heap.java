import java.util.NoSuchElementException;

class Heap<T extends Comparable<T>> {

   public static enum Type {MINIMUM, MAXIMUM};

   private final T[] heap;
   private final int capacity;
   private final Type type;
   private int next = 1;

   @SuppressWarnings("unchecked")
   public Heap(int capacity, Type type) throws IllegalArgumentException {
      if (capacity < 2)
         throw new IllegalArgumentException("Minimum heap capacity must be > 1");
      this.capacity = capacity;
      this.type = type;
      heap = (T[]) new Comparable[capacity+1];
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
      
      boolean result = false;
      if (type == Type.MINIMUM)
         result = (heap[p].compareTo(heap[c]) < 0);
      if (type == Type.MAXIMUM)
         result = (heap[p].compareTo(heap[c]) > 0);
      return result;
   }

   private T remove(int i) throws IllegalArgumentException, NoSuchElementException {
      if (isEmpty())
         throw new IllegalArgumentException("Empty heap");
      if (i >= next)
         throw new NoSuchElementException("Invalid element");

      T value = heap[i];
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

         T temp = heap[i];
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
         T temp = heap[parent(i)];
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

   public void add(T value) throws IllegalArgumentException {
      if (next > capacity) 
         throw new IllegalArgumentException("Exceeded heap capacity");
      heap[next] = value;
      next++;
      if (!isEmpty()) heapifyUp(next-1);
   }

   public T remove() throws IllegalArgumentException {
      return remove(1);
   }

   public static <T> void print(T[] A){
      if (A == null){
         System.out.println("null");
         return;
      }

      System.out.print("[");
      int len = A.length;
      for (int i = 0; i < len; i++){
         if (i+1 < len)
            System.out.print(A[i] + ", ");
         else
            System.out.println(A[i] + "] length = " + len);
      }
   }

   public static <T extends Comparable<T>> void test(Heap<T> heap, T[] A){
      System.out.println("Capacity = " + heap.getCapacity());
      System.out.println("Size = " + heap.getSize());
      System.out.print("A = ");
      print(A);

      for (T a : A){
         heap.add(a);
      }

      assert(heap.getSize() == A.length);
      System.out.println("Heap size = " + heap.getSize() + ", A size = " + A.length);

      while (!heap.isEmpty()){
         System.out.println("Minimum = " + heap.remove());
      }
      System.out.println();
   }

   public static void main(String[] args){
      int n = 100;
      //Heap.Type t = Heap.Type.MINIMUM;
      Heap.Type t = Heap.Type.MAXIMUM;

      Heap<Integer> heapI = new Heap<Integer>(n, t);
      Integer[] A1 = {5, 3, 11, 1, 4, -1, -10, 20, 30, 25};
      test(heapI, A1);

      Heap<Character> heapC = new Heap<Character>(n, t);
      Character[] A2 = {'a', 'A', 'Z', 'q', 'b', 'Y', 'm', 'B'};
      test(heapC, A2);

      Heap<String> heapS = new Heap<String>(n, t);
      String[] A3 = {"zz", "a", "aaa", "ddddd", "d", "ccc", "Cc", "CC"};
      test(heapS, A3);
   }
}
