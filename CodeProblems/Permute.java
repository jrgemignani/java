import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

// Wrapper class for a Facebook problem that uses a permutation method.
// This is a iterative permutation.
class Permute {
 
   // method to support the permutation function by providing "near"
   // characters to the specified char. It is not meant to be all 
   // inclusive.
   public static String getNear(char c){
      switch (c) {
         case 'a':
            return "a, s, q, z";
         case 'b':
            return "b, v, g";
         case 'c':
            return "c, x, v";
         case 'd':
            return "d, s, f, e";
         case 'e':
            return "e, r, w";
         case 'f':
            return "f, r, g, v";
      }

      return null;
   }
 
   // method to generate a list of strings that are all permutations of
   // a string based on "near" characters to each character. It is iterative
   // and uses prefixes and suffixes. If a null or empty string is passed,
   // it will return an empty list of strings.
   public static List<String> generatePossibilities(String S){
      List<String> prefixes = new ArrayList<String>();
      if (S == null || S.length() == 0) return prefixes;

      List<String> partials = new ArrayList<String>();

      prefixes.add("");
      for (int index = 0; index < S.length(); index++){ 
         String near = getNear(S.charAt(index));
         for (String suffix : near.split(", ")){
            for (String prefix : prefixes){
               partials.add(prefix + suffix);
            }
         }
         prefixes.clear();
         List<String> temp = prefixes;
         prefixes = partials;
         partials = temp;
      }
      return prefixes;
   }

   public static void main(String[] args){
      //String S = "abcdef";
      String S = "abcd";
      List<String> possibilities = generatePossibilities(S);

      Collections.sort(possibilities);

      for (String s : possibilities)
         System.out.println(s);     
   }
}
