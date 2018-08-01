class TrappingRain {

   private static void print(int[] A){
      System.out.print("[");
      for (int i = 0; i < A.length; i++){
         System.out.print(A[i]);
         if (i+1<A.length) System.out.print(", ");
      }
      System.out.println("]");
   }

   public static int trap(int[] height) {
      if (height == null) return 0;
        
      int len = height.length;
      int[] lmax = new int[len];
      for (int i = 0; i < len; i++){
         if (i == 0 || height[i] > lmax[i-1]){
            lmax[i] = height[i];
         }
         else
            lmax[i] = lmax[i-1];
            
      }

      int rmax = 0;
      int rain = 0;
      for (int i = len-1; i >=0; i--){
         rmax = (height[i] > rmax) ? height[i] : rmax;
         int min = (lmax[i] < rmax) ? lmax[i] : rmax;
         rain = rain + min - height[i];
      }

      return rain;
   }

   public static void main(String[] args){
      int[] A ={0,1,0,2,1,0,1,3,2,1,2,1};
      System.out.println(trap(A));
   }
}
