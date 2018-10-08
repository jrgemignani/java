class MaximalSquare {

   private static int min(int a, int b, int c){
      int min = (a < b) ? a : b;
      min = (min < c) ? min : c;
      return min;
   }

   public static int maximalSquare(char[][] matrix){
      if (matrix == null) return 0;
      if (matrix.length == 0) return 0;

      int rows = matrix.length;
      int cols = matrix[0].length;
      int max = 0;
      int[][] opt = new int[rows][cols];

      for (int r = 0; r < rows; r++){
         for (int c = 0; c < cols; c++){
            if (r == 0 || c == 0)
               opt[r][c] = matrix[r][c] - '0';
            else if (matrix[r][c] == '0')
               opt[r][c] = 0;
            else
               opt[r][c] = 1 + min(opt[r-1][c], opt[r-1][c-1], opt[r][c-1]);
            max = (max < opt[r][c]) ? opt[r][c] : max;
         }
      }
      return max*max;
   }

   public static void main(String[] args){
   }
}
