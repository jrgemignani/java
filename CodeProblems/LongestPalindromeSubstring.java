// Leetcode, finds the longest palindrome that is a substring.
// Dynamic Programming solution, O(n^2) time and space complexity.
// -jrg

class LongestPalindromeSubstring {

   private static String longestPalindromeSubstring(String A){
      if (A == null) return null;
      if (A.length() == 0) return "";

      int len = A.length();
      int[][] OPT = new int[len][len];
      int max = 1;
      int imax = 0;
      int jmax = 0;

      for (int i = 0; i < len; i++)
         OPT[i][i] = 1;

      for (int j = 0; j < len; j++){
         for (int i = j-1; i >= 0; i--){
            if (A.charAt(i) == A.charAt(j)){
               if (j-1 < i+1)
                  OPT[j][i] = 2;
               if (OPT[j-1][i+1] != 0)
                  OPT[j][i] = OPT[j-1][i+1] +2;
               if (OPT[j][i] > max){
                  max = OPT[j][i];
                  imax = i;
                  jmax = j;
               }
            }
         }
      }
      return A.substring(imax, jmax+1);
   }

   public static void main(String[] args){
      String A1 = "abbdbafffdddfffaaajjj";
      String A2 = "abbaba";
      String A3 = "a";
      String A4 = "";
      String A5 = "aa";
      String[] As = {A1, A2, A3, A4, A5};
      
      for (String A : As){
         String B = longestPalindromeSubstring(A);
         System.out.println("A = " + A + ", B = " + B);
      }
   }
}
