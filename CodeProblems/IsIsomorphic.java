// Leetcode problem IsIsomorphic strings -
//
// Given two strings s and t, determine if they are isomorphic. Two strings 
// are isomorphic if the characters in s can be replaced to get t.
//
// All occurrences of a character must be replaced with another character 
// while preserving the order of characters. No two characters may map to 
// the same character but a character may map to itself.
//
// -jrg
class IsIsomorphic {

   // public method to check two strings
   public static boolean isIsomorphic(String A, String B){
      if (A == null || B == null) return false;

      int aLen = A.length();
      int bLen = B.length();
      if (aLen != bLen) return false;

      // char array for translating characters
      char[] translate = new char[256];
      // boolean array for testing if already used
      boolean[] set = new boolean[256];

      for (int i = 0; i < aLen; i++){
         char t = B.charAt(i);
         int ti = A.charAt(i);
         int si = t;
         if (translate[ti] == 0 && !set[si]){
            translate[ti] = t;
            set[si] = true;
         }
         else if (translate[ti] == 0 && set[si])
            return false;
         else if (translate[ti] != t)
            return false;
      }
      return true;
   }

   // private class for testing
   private static class StringTuple {
      private final String A;
      private final String B;
      private StringTuple(String A, String B){
         this.A = A;
         this.B = B;
      }
   }

   // main entry point for tests
   public static void main(String[] args){
      // tests
      StringTuple test1 = new StringTuple("egg", "add");
      StringTuple test2 = new StringTuple("paper", "title");
      StringTuple test3 = new StringTuple("this", "that");
      StringTuple test4 = new StringTuple(null, null);
      StringTuple test5 = new StringTuple(null, "");
      StringTuple test6 = new StringTuple("", null);
      StringTuple test7 = new StringTuple("", "");

      // test group
      StringTuple[] tests = {test1, test2, test3, test4, test5, test6, test7};
      for (StringTuple test : tests){
         String A = test.A;
         String B = test.B;
         boolean isIsomorphic = isIsomorphic(A, B);
         System.out.println("A = \"" + A + "\", B = \"" + B 
            + "\", Isomorphic  = " + isIsomorphic);
      }
   }
}
