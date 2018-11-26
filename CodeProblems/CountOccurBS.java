// Code problem: count the number of occurences in a sorted array 
// using Binary Search - as opposed to a linear search. Done 
// iteratively.
//
// Time complexity O(logn)
// Space complexity O(1) 
// -jrg
//
class CountOccurBS {

   // public static method to count the number of occurrences
   public static int countOccur(int[] A, int value){
      // if null or empty, return 0
      if (A == null || A.length == 0) return 0;

      // init the left and right indices of the array
      int left = 0;
      int right = A.length-1;

      // find the value
      while (left <= right){
         int mid = (left + right)/2;
         if (A[mid] > value)
            right = mid - 1;
         else if (A[mid] < value)
            left = mid + 1;
         else
            break; // found it
      }
      // if we didn't find it, return 0
      if (left > right) return 0;

      // save the middle position
      int middle = (left + right)/2;

      // set j to be the middle
      int j = middle;
      // use binary search to find the left end of the value
      while (left < j){
         int mid = (left + j)/2;
         if (A[mid] > value)
            j = mid+1;
         else if (A[mid] < value) 
            left = mid+1;
         else 
            j = mid;
      }

      // reset j to the middle position
      j = middle;
      // use binary search to find the right end of the value
      while(j <= right){
         int mid = (j + right)/2;
         if (A[mid] > value)
            right = mid -1;
         else if (A[mid] < value)
            j = mid +1;
         else 
            j = mid +1;
      }

      // return the difference in the indices + 1
      return right-left+1;
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
      int[][] T1 = {{}, {0}};
      int[][] T2 = {null, {0}};
      int[][] T3 = {{0}, {-1, 1, 0}};
      int[][] T4 = {{0, 1}, {-1, 0, 1, 2}};
      int[][] T5 = {{0, 1, 2, 2, 2, 3, 4, 5, 6, 7, 9, 11, 12}, {-1, 13, 7, 2}};
      int[][] T6 = {{-11, -5, -5, 0, 1, 1, 7, 8, 8, 8, 9, 11, 11, 13, 14}, {-20, 20, 0, 1, 8, 13}};
      int[][][] TESTS = {T1, T2, T3, T4, T5, T6};

      for (int[][] test : TESTS){
         int[] A = test[0];
         int[] values = test[1];
         System.out.print("A      = "); print(A); System.out.println();
         System.out.print("values = "); print(values); System.out.println();
         for(int value : values){
            int count = countOccur(A, value);
            System.out.println(" value = " + value + ", count = " + count);
         }
         System.out.println();
      }
   }
}
