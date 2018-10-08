// Leetcode problem to find the two integers that sum up to k.
// Per the problem, there will be only one solution and a number
// can only be used once. Wanted are the indicies of the two 
// numbers.
// O(n) time complexity
//

import java.util.Map;
import java.util.HashMap;

public class TwoSum {

   // hashmap to hold the values as we iterate through the array
   private static final Map<Integer, Integer> map = new HashMap<Integer, Integer>();

   // method to return an array of the two indicies representing the two 
   // values that sum to k.
   private static int[] twoSum(int[] A, int k){
      // initialize the result array to 0
      int[] result = {0, 0};
      // iterate through the array
      for(int i = 0; i < A.length; i++){
         // calculate the compliment and check to see if it is in the map
         int compliment = k - A[i];
         if (map.get(compliment) != null){
            result[0] = map.get(compliment);
            result[1] = i;
         }
         // put the value and index into the map
         map.put(A[i], i);
      }
      // return the result
      return result;
   }

   // helper method to print the array of value
   private static void print(int[] A){
      System.out.print("[");
      for (int i = 0; i < A.length; i++){
         if (i+1 < A.length)
            System.out.print(A[i] + ", ");
         else
            System.out.println(A[i] + "]");
      }
   }

   // main method used to test twoSum
   public static void main(String[] args){
      int[] A = {2, 7, 11, 15};
      int k = 9;

      System.out.print("For A = ");
      print(A);

      int[] result = twoSum(A, k);
      System.out.print("For k = " + k + " -> ");
      print(result);

      k = 17;
      result = twoSum(A, k);
      System.out.print("For k = " + k + " -> ");
      print(result);
   }
}
