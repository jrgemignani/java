class BinarySearch {

   private static <T extends Comparable<T>> boolean binarySearchR(T[] A, int a, int b, T value){
      if (A == null || b < a) return false;
      if (a == b) return (A[a].compareTo(value) == 0);

      boolean exists = false;
      int mid = (b + a)/2;
      int compare = A[mid].compareTo(value);
      if (compare == 0) exists = true;
      if (compare > 0) exists = binarySearchR(A, a, mid-1, value);
      if (compare < 0) exists = binarySearchR(A, mid+1, b, value);

      return exists;
   }

   private static <T extends Comparable<T>> boolean binarySearchI(T[] A, T value){
      if (A == null) return false;
      int a = 0;
      int b = A.length-1;
      while (b > a){
         int mid = (b+a)/2;
         int compare = A[mid].compareTo(value);
         if (compare == 0) return true;
         if (compare > 0) b = mid -1;
         if (compare < 0) a = mid +1;
      }
      if (b < a) return false;
      return (A[a] == value);
   }

   public static <T extends Comparable<T>> boolean binarySearchR(T[] A, T value){
      return (A != null) ? binarySearchR(A, 0, A.length-1, value) : false;
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

   private static <T extends Comparable<T>> void test(T[] A, T[] V){
      System.out.print("A = ");
      print(A);

      System.out.print("V = ");
      print(V);

      if (V == null) return;

      for (T v : V){
         boolean resultI = binarySearchI(A, v);
         boolean resultR = binarySearchR(A, v);
         assert(resultI == resultR);
         System.out.println("Contains " + v + " ? " + resultI + ":" + resultR);
      }
      System.out.println();
   }

   public static void main(String[] args){
      Integer[] A1 = {0, 1, 3, 5, 7, 9, 11, 13, 14, 17, 21, 25, 30, 32};
      Integer[] V1 = {0, 11, 32, -100, 333, 12, 2, 7, 21};
      test(null, V1);
      test(A1, null);
      test(null, null);
      test(A1, V1);

      Character[] A2 = {'b', 'd', 'g', 't', 'y'};
      Character[] V2 = {'a', 'z', 'b', 'y', 'd', 's'};
      test(null, V2);
      test(A2, null);
      test(null, null);
      test(A2, V2);
   }
}
