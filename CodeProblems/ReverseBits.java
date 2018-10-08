class ReverseBits {

   private static int reverseBits(int n){
      int m = 0;

      int testBit = 0x01;
      int setBit = 0x80000000;

      while (testBit != 0){
         if ((n & testBit) != 0)
            m |= setBit;
         testBit = testBit<<1;
         setBit = 0x7fffffff & (setBit>>1);
      }
      return m;
   }

   public static void main(String[] args){
      int n = 43261596;
      int m = 964176192;
      int r = reverseBits(n);
      System.out.println("n = " + n + ", m = " + m + ", r = " + r);
   }
}
