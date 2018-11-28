class GetOtherProducts {

   public static int[] getOtherProducts(int[] A){
      if (A == null || A.length == 0) return null;

      int length = A.length;
      int[] results = new int[length];

      results[length-1] = 1;
      for (int i = length -1; i > 0; i--){
         results[i-1] = results[i] * A[i];
      }

      int leftProduct = 1;
      for (int i = 0; i < length; i++){
         results[i] = leftProduct * results[i];
         leftProduct *= A[i];
      }

      return results;
   }

   public static void print(int[] A){
      if (A == null){
         System.out.println("null");
         return;
      }
      System.out.print("[");
      for (int i = 0; i < A.length; i++){
         System.out.print(A[i]);
         if (i+1<A.length)
            System.out.print(", ");
      }
      System.out.println("]");
   }

   public static void main(String[] args){
      int[] A1 = {1, 2, 0, -1, 3, 0, 3};
      int[] A2 = {1, 2, 0, 2};
      int[] A3 = {1, 1, 1, 1};
      int[] A4 = {1, 2, 3, 1, 2, 3};

      int[][] As = {A1, A2, A3, A4};
      
      for (int[] A : As){
         int[] result = getOtherProducts(A);
         System.out.print("A = ");
         print(A);
         System.out.print("R = ");
         print(result);
         System.out.println();
      }
   }
}
