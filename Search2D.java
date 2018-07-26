// LeetCode problem to search a sorted 2D array
// O(m+n) time
// -jrg

class Search2D {

   public static boolean searchMatrix(int[][] matrix, int k){
      if (matrix == null) return false;
      if (matrix.length == 0) return false;
      int m = 0;
      int n = matrix[0].length -1;
      int mLen = matrix.length;

      while(m < mLen && n >= 0){
         if (matrix[m][n] < k) m++;
         else if (matrix[m][n] > k) n--;
         else return true;
      }
      return false;
   }

   public static void main(String[] args){
      int[][] A = {{1,   4,  7, 11, 15},
                   {2,   5,  8, 12, 19},
                   {3,   6,  9, 16, 22},
                   {10, 13, 14, 17, 24},
                   {18, 21, 23, 26, 30}};

      int k = 5;
      boolean found = searchMatrix(A, k);
      System.out.println("searchMatrix(" + k + ") = " + found);

      k = 20;
      found = searchMatrix(A, k);
      System.out.println("searchMatrix(" + k + ") = " + found);

      k = 3;
      found = searchMatrix(A, k);
      System.out.println("searchMatrix(" + k + ") = " + found);

   }
}
