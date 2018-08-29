class BinarySearch {

   private static boolean binarySearch(int[] A, int a, int b, int value){
      if (a == b) 
         return (A[a] == value);

      boolean exists = false;
      int mid = a + (b - a)/2;

      if (A[mid] == value) 
         exists = true;
      else if (a == mid) 
         exists = false;
      else if (A[mid] > value) 
         exists = binarySearch(A, a, mid-1, value);
      else if (A[mid] < value) 
         exists = binarySearch(A, mid+1, b, value);

      return exists;
   }

   public static boolean contains(int[] A, int value){
      return binarySearch(A, 0, A.length-1, value);
   }

   public static void print(int[] A){
      System.out.print("[");
      for (int i = 0; i < A.length; i++){
         if (i+1 < A.length)
            System.out.print(A[i] + ", ");
         else
            System.out.println(A[i] + "]");
      }
   }

   public static void main(String[] args){
      int[] A = {0, 1, 3, 5, 7, 9, 11, 13, 14, 17, 21, 25, 30, 32};
      int[] V = {0, 11, 32, -100, 333, 12, 2};

      System.out.print("A = ");
      print(A);

      System.out.print("V = ");
      print(V);

      for (int v : V){
         boolean exist = contains(A, v);
         System.out.println("Contains " + v + " ? " + exist);
      }
   }
}
