// LeetCode problem for the kth largest element in an unsorted array.
// O(n^2) time. 
//
// This is the generic update and is a work in progress.
// -jrg

class KthLargestElement<T extends Comparable<T>> {

   // helper function to print out a T[]
   private void print(T[] t){
      int len = t.length;
      System.out.print("[");
      for(int i = 0; i < len; i++){
         if (i+1 < len)
            System.out.print(t[i] + ", ");
         else
            System.out.println(t[i] + "]");
      }
   }

   // helper function to swap two elements
   private void swap(T[] t, int a, int b){
      if (t == null) return;
      if (a == b) return;

      T temp = t[a];
      t[a] = t[b];
      t[b] = temp;
   }
 
   // throws NullPointerException for null nums passed
   // throws IllegalArgumentException for an invalid k value
   public T findKthLargestElement(T[] nums, int k) throws NullPointerException,
      IllegalArgumentException {

      if (nums == null) 
         throw new NullPointerException("null argument passed for array");
      if (k <= 0 || k > nums.length) 
         throw new IllegalArgumentException("invalid k value passed");

      int len = nums.length;
      for(int i = 0; i < k; i++){
         for(int j = 0; j < len-1-i; j++){
            if (nums[j].compareTo(nums[j+1]) > 0)
               swap(nums, j, j+1);
         }
      }
      return nums[len-k];
   }

   // throws NullPointerException for null test array passed
   private void test(T[] t) throws NullPointerException {
      if (t == null)
         throw new NullPointerException("test was passed a null");

      print(t);
      for (int k = 1; k <= t.length; k++){
         T kth = findKthLargestElement(t, k);
         System.out.println("Kth (" + k + ") largest = " + kth);
      }
      print(t);
      System.out.println();
   }

   public static void main(String[] args) throws NullPointerException, IllegalArgumentException {
      // kth for an Integer
      KthLargestElement<Integer> kleInteger = new KthLargestElement<Integer>();
      Integer[] A = {2, 1, 3, 4, 0, -1, 6, 2};
      kleInteger.test(A);

      // kth for a Character
      KthLargestElement<Character> kleCharacter = new KthLargestElement<Character>();
      Character[] B = {'2', '1', '3', '4', '0', '1', '6', '2'};
      kleCharacter.test(B);

      // kth for a String
      KthLargestElement<String> kleString = new KthLargestElement<String>();
      String[] C = {"2", "1", "3", "4", "0", "1", "6", "2"};
      kleString.test(C);
      String[] D = {"a", "aa", "bbb", "c", "bb", "e", "eee", "ccc", "b"};
      kleString.test(D);
      String[] E = {"aaad", "aaac", "aaab", "abcd", "abbb", "aabb", "aaaa"};
      kleString.test(E);

   }
}
