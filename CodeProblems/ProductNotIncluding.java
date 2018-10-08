// Leetcode problem to return an int array containing the products 
// of all entries in the array except the entry at that index.
// O(n) time and space
// -jrg

class ProductNotIncluding {

   private static int[] getProducts(int[] A){
      int len = A.length;
      int[] result = new int[len];
      int prev = 1;
      for (int i = 0; i < len; i++){
         result[i] = prev;
         prev *= A[i];
      }
      prev = 1;
      for (int i = len-1; i >= 0; i--){
         result[i] *= prev;
         prev *= A[i];
      }
      return result;
   }

   private static void print(int[] A){
      int len = A.length;
      System.out.print("[");
      for (int i = 0; i < len; i++){
         if (i+1 < len)
            System.out.print(A[i] + ", ");
         else
            System.out.println(A[i] + "]");
      }
   }

   public static void main(String[] args){
      int[] A1 = {1, 7, 3, 4};
      int[] A2 = {1, 2, 3, 4};
      int[] A3 = {1, 2, 3, 4, -1};
      int[] A4 = {1, 2, 3, 4, -1, -1};
      int[] A5 = {1, 2, 3, 0, -1, 4, -1};
      int[] A6 = {1, 2, 3, 0, -1, 4};

      int[][] As = {A1, A2, A3, A4, A5, A6};

      for (int[] A : As){
         int[] result = getProducts(A);
         print(A);
         print(result);
         System.out.println();
      }
   }
}
