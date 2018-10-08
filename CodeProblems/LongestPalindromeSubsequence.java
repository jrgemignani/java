// Solution to finding the longest palidrome that is a subsequence.
// Dynamic solution that uses backtracing to generate one of the longest
// subsequences found.
// Dynamic Programming solution. O(n^2) time and space complexity.
//
// -jrg

class LongestPalindromeSubsequence {

   private static void print(int[][] OPT, String A){
      if (OPT == null) return;
      if (A == null) return;
      if (A.length() != OPT.length || OPT.length != OPT[0].length) return;

      int len = A.length();

      System.out.println();
      System.out.print("  ");
      for (int i = 0; i < len; i++)
         System.out.print(A.charAt(i) + " ");
      System.out.println();
      for (int r = 0; r < len; r++){
         System.out.print(A.charAt(r) + " ");
         for (int c = 0; c < len; c++){
            System.out.print(OPT[r][c] + " ");
         }
         System.out.println();
      }
      System.out.println();
      System.out.println("OPT[len-1][0] = " + OPT[len-1][0]);
   }

   private static String backtrace(int[][] OPT, String A){
      int len = OPT.length;
      int j = len-1;
      int i = 0;
      StringBuilder lhs = new StringBuilder();
      StringBuilder rhs = new StringBuilder();
      while (j >=0 && i < len && OPT[j][i] != 0){
         if (A.charAt(i) != A.charAt(j)){
            if (OPT[j-1][i] > OPT[j][i+1])
               j--;
            else
               i++;
         }
         else{
            lhs.append(A.charAt(i));
            if (OPT[j][i] == OPT[j-1][i+1]+2)
               rhs.append(A.charAt(i));
            j--;
            i++;
         }
      }
      String aLongest = lhs.toString() + rhs.reverse().toString();
      return aLongest;
   }

   private static String longestPalindromeSubsequence(String A){
      if (A == null) return null;

      int len = A.length();
      int[][] OPT = new int[len][len];

      for (int i = 0; i < len; i++)
         OPT[i][i] = 1;

      for (int j = 0; j < len; j++){
         for (int i = j-1; i >= 0; i--){
            if (A.charAt(i) == A.charAt(j)){
               OPT[j][i] = 2 + OPT[j-1][i+1];
            }
            else{
               OPT[j][i] = (OPT[j][i+1] <= OPT[j-1][i]) ? OPT[j-1][i] : OPT[j][i+1];
            }
         }
      }
      String aLongest = backtrace(OPT, A);
      return aLongest;
   }

   public static void main(String[] args){
      String A1 = "abcdasdfghjkldcba";
      String A2 = "abbdba";
      String A3 = "abbcde";
      String B = longestPalindromeSubsequence(A1);
      System.out.println("A = " + A1 + ", B = " + B);
      B = longestPalindromeSubsequence(A2);
      System.out.println("A = " + A2 + ", B = " + B);
      B = longestPalindromeSubsequence(A3);
      System.out.println("A = " + A3 + ", B = " + B);
   }
}
