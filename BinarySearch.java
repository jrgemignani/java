class BinarySearch {

   private static <T extends Comparable<T>> boolean binarySearch(T[] A, int a, int b, T value){
      if (a == b) 
         return (A[a].compareTo(value) == 0);
      if (b < a)
         return false;

      boolean exists = false;
      int mid = a + (b - a)/2;

      if (A[mid].compareTo(value) == 0) 
         exists = true;
      else if (A[mid].compareTo(value) > 0) 
         exists = binarySearch(A, a, mid-1, value);
      else 
         exists = binarySearch(A, mid+1, b, value);

      return exists;
   }

   public static <T extends Comparable<T>> boolean contains(T[] A, T value){
      return binarySearch(A, 0, A.length-1, value);
   }

   public static <T> void print(T[] A){
      System.out.print("[");
      for (int i = 0; i < A.length; i++){
         if (i+1 < A.length)
            System.out.print(A[i] + ", ");
         else
            System.out.println(A[i] + "] length = " + A.length);
      }
   }

   private static <T extends Comparable<T>> void test(T[] A, T[] V){
      System.out.print("A = ");
      print(A);

      System.out.print("V = ");
      print(V);

      for (T v : V){
         boolean exist = contains(A, v);
         System.out.println("Contains " + v + " ? " + exist);
      }
      System.out.println();
   }

   public static void main(String[] args){
      Integer[] A1 = {0, 1, 3, 5, 7, 9, 11, 13, 14, 17, 21, 25, 30, 32};
      Integer[] V1 = {0, 11, 32, -100, 333, 12, 2, 7, 21};
      test(A1, V1);

      Character[] A2 = {'b', 'd', 'g', 't', 'y'};
      Character[] V2 = {'a', 'z', 'b', 'y', 'd', 's'};
      test(A2, V2);
   }
}
