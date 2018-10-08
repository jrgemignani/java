// Leetcode problem to generate Hamming weight (the number of 1s in the 
// binary representation of the number.
// -jrg
//

public class HammingWeight {

   // public static method to generate Hamming weight
   public static int hammingWeight(int n){
      int i = 0x01;
      int count = 0;
      while(i != 0){
         if ((n & i) > 0) count++;
         i = i<<1;
      }
      return count;
   }

   public static void main(String[] args){
      int n = 0x0b; //11
      int h = hammingWeight(n);
      assert(h == 3);
      System.out.println("hammingWeight(0x" + 
         Integer.toHexString(n).toUpperCase() + ") = " + h);

      n = 0x80;     //128;
      h = hammingWeight(n);
      assert(h == 1);
      System.out.println("hammingWeight(0x" + 
         Integer.toHexString(n).toUpperCase() + ") = " + h);

      n = 0x1f;     //31;
      h = hammingWeight(n);
      assert(h == 5);
      System.out.println("hammingWeight(0x" + 
         Integer.toHexString(n).toUpperCase() + ") = " + h);
   }
}
