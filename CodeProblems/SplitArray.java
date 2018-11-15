// Code problem: Split an array into two halves of equal sum - if
// possible.
//
// Time complexity O(N), Space complexity O(1)
//
class SplitArray {

   // private helper method to print a subset of an array
   private static <T> void print(T[] t, int a, int b){
      System.out.print("[");
      for (int i = a; t != null && i<t.length && i<=b; i++){
         if (i<b && i+1<t.length)
            System.out.print(t[i] + ", ");
         else
            System.out.print(t[i]);
      }
      System.out.println("]");
   }

   // private helper method to print a whole array
   private static <T> void print(T[] t){
      if (t == null){
         System.out.println("null");
      }
      else{
         print(t, 0, t.length);
      }
   }

   // private helper method to return the index (inclusive) of the 
   // last element in the first half of the array - creating two
   // halves of equal sum. it will return -1 if it is not possible 
   // to split the array.
   private static int splitArray(Integer[] A){
      if (A == null || A.length == 1) return -1;
      int len = A.length;
      int lhsum = 0;
      int rhsum = 0;
      for (int i = 0; i < len; i++)
         rhsum += A[i];
      for (int i = 0; i < len; i++){
         lhsum += A[i];
         rhsum -= A[i];
         if (lhsum == rhsum)
            return i;
      }
      return -1;
   }

   // public method to print the two halves of the input array, 
   // provided the input array can be split into two halves 
   // based on sum. 
   public static void printSplit(Integer[] A){
      int split = splitArray(A);

      System.out.print("For input array A = ");
      print(A);

      if (split != -1){
         System.out.print("   First half  = ");
         print(A, 0, split);
         System.out.print("   Second half = ");
         print(A, split+1, A.length-1);
      }
      else{
         System.out.println("   Not possible");
      }
   }

   // main entry point and tests
   public static void main(String[] args){
      Integer[] A1 = {1, 1, 1, 1};
      Integer[] A2 = {1, 1, 1};
      Integer[] A3 = {1, 2, 3, 3, 2, 1};
      Integer[] A4 = null;
      Integer[] A5 = {};
      Integer[] A6 = {1, 3, 4, 5, 11, 2};
      Integer[] A7 = {0};
      Integer[] A8 = {0, 0, 0};

      Integer[][] As = {A1, A2, A3, A4, A5, A6, A7, A8};

      for (Integer[] A : As){
         printSplit(A);
         System.out.println();
      }
   }
}
