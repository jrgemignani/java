// LeetCode problem Climbing Stairs.
// Dynamic Programming solution O(n) time O(1) space.
// Recursive naive solution O(2^n) included for comparison.
// -jrg

class ClimbingStairs {

   public static long climbStairsR(int n){
      // base cases
      if (n == 0) return 0;
      if (n == 1) return 1;
      if (n == 2) return 2;
      return climbStairsR(n-1) + climbStairsR(n-2);
   }

   public static long climbStairs(int n){
      // base cases
      long b1 = 1;
      long b2 = 2;
      long bi = 0;
      if (n == 0) return 0;
      if (n == 1) return b1;
      if (n == 2) return b2;
      for(int i = 3; i <= n; i++){
         bi = b1 + b2;
         b1 = b2;
         b2 = bi;
      }
      return bi;
   }

   public static void main(String[] args){
      int k = 15;

      System.out.println("Iterative -");
      for(int n = 0; n <= k; n++){
         long ways = climbStairs(n);
         System.out.println("For " + n + " stairs, there are " + ways + " ways.");
      }
      System.out.println();

      System.out.println("Recursive -");
      for(int n = 0; n <= k; n++){
         long ways = climbStairsR(n);
         System.out.println("For " + n + " stairs, there are " + ways + " ways.");
      }
      System.out.println();

      int n = 50;
      System.out.print("Iterative: For " + n + " stairs, there are ");
      long ways = climbStairs(n);
      System.out.println(ways + " ways.");
      System.out.println();

      System.out.print("Recursive: For " + n + " stairs, there are ");
      ways = climbStairsR(n);
      System.out.println(ways + " ways.");
   }
}
