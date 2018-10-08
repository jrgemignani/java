class StrStr {

   private static int strStr(String haystack, String needle){
      if (needle == null) return 0;
      if (haystack == null) return -1;

      int hLen = haystack.length();
      int nLen = needle.length();

      for(int i = 0; i < hLen; i++){
         boolean status = true;
         for (int j = 0; j < nLen; j++){
            if (haystack.charAt(i+j) != needle.charAt(j)){
               status = false;
               break;
            }
         }
         if (status) return i;
      }
      return -1;
   }

   public static void main(String[] args){
      String haystack = "hello";
      String needle = "ll";
      System.out.println(strStr(haystack, needle));
      
      haystack = "aaaaa";
      needle = "bba";
      System.out.println(strStr(haystack, needle));

   }
}
