class DepthSum {

   // helper method to check if character is a '{', '}', or ','
   // if returns true if, otherwise false
   private static boolean isBreak(String A, int i){
      char a = A.charAt(i);
      if (a == '{') return true;
      if (a == '}') return true;
      if (a == ',') return true;
      return false;
   }

   // public method to calculated depth sum of a string
   public static int depthSum(String A){
      if (A == null) return 0;

      int depth = 0;
      int sum = 0;

      int i = 0;
      int length = A.length();
      while(i < length){
         // get the current character
         char ai = A.charAt(i);
         if (ai == '{') {
            depth++;
         }
         else if (ai == '}'){
            depth--;
         }
         else if (ai == ','){
            // do nothing
         }
         // what's left are characters, so convert the substring to a number
         else{
            int j = 0;
            // locate the end of the numeric string
            for (j = i; j < length && !isBreak(A, j); j++);
            // get the number
            int number = Integer.valueOf(A.substring(i,j));
            // adjust the index to the position prior to the break
            i = j-1;
            // add the number to our sum
            sum += depth*number;
         }
         // move the index to the next character
         i++;
      }
      // return the sum
      return sum;
   }

   public static void main(String[] args){
      String A1 = "{{1,1},2,{1,1}}";
      String A2 = "{1,{4,{6}}}";
      String A3 = null;
      String A4 = "";
      String[] As = {A1, A2, A3, A4};

      for (String A : As){
         int dsum = depthSum(A);
         System.out.println("A = " + A + " = " + dsum);
      }

   }
}
