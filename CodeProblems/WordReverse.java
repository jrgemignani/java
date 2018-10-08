// LeetCode problem to reverse the words in a string, but not the
// actual word. O(n) time and space 
//

import java.lang.StringBuilder;

class WordReverse {

   public static String wordReverse(String A){
      if (A == null) return null;

      String[] words = A.split("[ ]{1,}");
      StringBuilder string = new StringBuilder();
      int start = words.length-1;
      for (int i = start; i >= 0; i--){
         if (words[i].equals("")) continue;
         if (i != start)
            string.append(" ");
         string.append(words[i]);
      }
      return string.toString();
   }

   // main entry point of class is set up to test wordReverse
   public static void main(String[] args){
      String A1 = "  this  is a test of    word reverse     ";
      String A2 = "";
      String A3 = null;
      String A4 = " reverse word of test a is this ";
      String[] As = {A1, A2, A3, A4};

      for (String A : As){
         String B = wordReverse(A);
         System.out.println("[" + A + "] -> [" + B + "]");
      }
   }
}
