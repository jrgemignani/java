import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;

class WordBreak {

   public static void print(boolean[] a){
      System.out.print("[");
      for (int i = 0; i < a.length; i++){
         if (i+1 < a.length)
            System.out.print(a[i] + ", ");
         else
            System.out.println(a[i] + "]");
      }
   }

   public static boolean wordBreak(String s, List<String> wordDict){
      int len = s.length();
      boolean[] OPT = new boolean[len+1];
      //Set<String> dict = new HashSet<String>();
 
      //for (String word : wordDict)
      //   dict.add(word);

      for (int i = 1; i<=len; i++){
         if (wordDict.contains(s.substring(0, i)))
            OPT[i] = true;
         if (OPT[i]){
            for (int j = i+1; j<=len; j++){
               if (wordDict.contains(s.substring(i, j)))
                  OPT[j] = true;
            }
         }
      }
      print(OPT);
      return OPT[len];
   }

   public static void main(String[] args){
      List<String> dict = new ArrayList<String>();
      dict.add("apple");
      dict.add("pen");
      dict.add("pena");
      dict.add("dog");
      
      System.out.println(wordBreak("applepenaapple", dict));
      System.out.println(wordBreak("applepenapple", dict));
   }
}
