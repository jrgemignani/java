// LeetCode problem to merge two sorted arrays, in place. Given that one array
// has enough space to contain both arrays.
// Time complexity O(m + n)
// Space complexity constant.
//
// -jrg
//
class MergeTwoArrays {

   // public static method to merge two sorted arrays. one array is guaranteed
   // to contain enough space for the result. the method will determine which
   // array this is and adjust accordingly.
   public static void mergeTwoArrays(int[] nums1, int m, int[] nums2, int n){
      if (nums1 == null || nums2 == null || m <= 0 || n <= 0) return;

      // find out which array is bigger
      boolean test = (m < nums1.length);
      // set up variables based on test
      int[] target = (test) ? nums1 : nums2;     // target array
      int[] other = (test) ? nums2 : nums1;      // array to be merged
      int ti = (test) ? m-1 : n-1;               // target index
      int oi = (test) ? n-1 : m-1;               // other index
      int dest = target.length-1;                // target destination 

      // loop through going from the back to the front of the arrays
      // filling in the back to the front
      while (ti >= 0 || oi >= 0){
         if (ti >= 0 && oi >= 0){
            if (target[ti] >= other[oi])
               target[dest--] = target[ti--];
            else
               target[dest--] = other[oi--];
         }
         else if (ti >= 0) 
            ti--;
         else 
            target[dest--] = other[oi--];
      }
   }

   // helper method to print an array of integers
   private static void print(int[] A){
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

   // main entry point and tests
   public static void main(String[] arg){
      // tests
      int[][] T1 = {{1, 3, 5, 7, 0, 0, 0}, {0, 1, 2}, {4, 3}};
      int[][] T2 = {{0, 1, 2}, {1, 3, 5, 7, 0, 0, 0}, {3, 4}};
      int[][] T3 = {{1, 2, 3, 4, 5, 6, 0, 0, 0, 0}, {7, 8, 9, 10}, {6, 4}};

      // tests to verify guard cases
      int[][] T4 = {{0, 1, 2}, {1, 3, 5, 7, 0, 0, 0}, {0, 4}};
      int[][] T5 = {{0, 1, 2}, {1, 3, 5, 7, 0, 0, 0}, {3, 0}};
      int[][] T6 = {null, {1, 3, 5, 7, 0, 0, 0}, {3, 4}};
      int[][] T7 = {{0, 1, 2}, null, {3, 4}};

      int[][][] Ts = {T1, T2, T3, T4, T5, T6, T7};

      // loop to run tests
      for (int[][] T : Ts){
         int[] nums1 = T[0];
         int[] nums2 = T[1];
         int m = T[2][0];
         int n = T[2][1];

         System.out.print("nums1 = ");
         print(nums1);
         System.out.print("nums2 = ");
         print(nums2);

         mergeTwoArrays(nums1, m, nums2, n);
         if (nums1 == null || nums2 == null){
            System.out.println();
            continue;
         }

         if (nums1.length > nums2.length){
            System.out.print("nums1 = ");
            print(nums1);
         }
         else {
            System.out.print("nums2 = ");
            print(nums2);
         }
         System.out.println();
      }
   }
}
