// Code problem: Find the max subsequence product
// Time complexity O(N)
// Space complexity O(1) 
// -jrg
//
class MaxProduct {

   // public method to find the max subsequence product. throws exception for
   // null or empty arrays
   public static int maxProduct(int[] A) throws IllegalArgumentException {
      if (A == null) 
         throw new IllegalArgumentException("maxProduct: Passed array is null");
      if (A.length == 0)
         throw new IllegalArgumentException("maxProduct: Passed array is empty");

      if (A.length == 1) return A[0];

      int length = A.length;
      int negCount = 0;
      int negMax = 0;
      int posMax = A[0];
      int product = 0;

      for (int i = 0; i < length; i++){
         int value = A[i];
         if (posMax < value) posMax = value;
         if (value == 0) continue;
         if (value < 0){
            if (negMax == 0 || negMax < value) negMax = value;
            negCount++;
         }
         product = (product == 0) ? value : product*value;
      }

      if (product >= 0) return product;
      if (negCount == 1 && posMax == 0) return posMax;

      return product/negMax;
   }

   // private helper method to print the array, formatted
   private static void print(int[] A){
      if (A == null){
         System.out.print("null");
         return;
      }
      System.out.print("[");
      for (int i = 0; i < A.length; i++){
         if (i+1<A.length)
            System.out.print(A[i] + ", ");
         else
            System.out.print(A[i]);
      }
      System.out.print("]");
   }

   // main entry point and tests
   public static void main(String[] args){
      int[] A1 = {};
      int[] A2 = null;
      int[] A3 = {-1,0};
      int[] A4 = {-1,0,1};
      int[] A5 = {-1,-1,-1,0};
      int[] A6 = {-1,4,-1,3,-2};
      int[] A7 = {-1,-1,4,3,-2};
      int[] A8 = {-4,-3,-2};
      int[] A9 = {-2,0,0,0};
      int[][] As = {A1, A2, A3, A4, A5, A6, A7, A8, A9};

      for (int[] A : As){
         System.out.print("A = ");
         print(A);
         // try/catch for the maxProduct call
         try {
            int max = maxProduct(A);
            System.out.println(", max product = " + max);
         }
         catch (IllegalArgumentException e){
            System.out.println(", Invalid argument passed, " + e);
         } 
      }
   }
}
