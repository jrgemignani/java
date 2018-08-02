// LeetCode problem for the kth largest element in an unsorted array.
// O(n^2) time
// -jrg

//import java.lang.NullPointerException;
//import java.lang.IllegalArgumentException;

class KthLargestElement {

   // helper function to print out an int[]
   private static void print(int[] A){
      int len = A.length;
      System.out.print("[");
      for(int i = 0; i < len; i++){
         if (i+1 < len)
            System.out.print(A[i] + ", ");
         else
            System.out.println(A[i] + "]");
      }
   }

   // helper function to swap two elements
   private static void swap(int[] A, int a, int b){
      if (A == null) return;
      if (a == b) return;

      int temp = A[a];
      A[a] = A[b];
      A[b] = temp;
    }
 
   // throws NullPointerException for null nums passed
   // throws IllegalArgumentException for an invalid k value
   public static int findKthLargest(int[] nums, int k) throws NullPointerException,
      IllegalArgumentException {

      if (nums == null) 
         throw new NullPointerException("null argument passed for array");
      if (k <= 0 || k > nums.length) 
         throw new IllegalArgumentException("invalid k value passed");

      int len = nums.length;
      for(int i = 0; i < k; i++){
         for(int j = 0; j < len-1-i; j++){
            if (nums[j] > nums[j+1])
               swap(nums, j, j+1);
         }
      }
      return nums[len-k];
   }

   public static void main(String[] args) throws NullPointerException, 
      IllegalArgumentException {

      int[] A = {2,1};
      int k = 2;
      print(A);
      System.out.println("Kth largest = " + findKthLargest(A, k));
      print(A);
   }
}
