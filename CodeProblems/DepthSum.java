// Solution to the code problem of calculating the Depth Sum given a string
//
// For example: "{1,{4,{6}}}" 
//
// Each open paren is a new depth (goes down one level)
// Each closed paren closes that depth (goes back up one level). 
// A comma separates a list of numbers.
//
// So, for {1,{4,{6}}} the answer would be 27
//
// The time complexity is O(N) and the space complexity is O(1)
// -jrg
//
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

   // main entry point with tests
   public static void main(String[] args){
      // Some test cases
      String A1 = "{{1,1},2,{1,1}}";
      String A2 = "{1,{4,{6}}}";
      String A3 = null;
      String A4 = "";

      // group them all together
      String[] As = {A1, A2, A3, A4};

      // iterate through the tests, outputing the results
      for (String A : As){
         int dsum = depthSum(A);
         System.out.println("A = " + A + " = " + dsum);
      }
   }
}
