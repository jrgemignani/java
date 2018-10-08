import java.util.Map;
import java.util.HashMap;

class MaxPoints {

   private static class Point {
      int x;
      int y;
   }

   private static int getGcd(int a, int b){
      if (a == 0 || b == 0) 
         return 0;

      int c = (a <0) ? a*-1 : a;
      int d = (b <0) ? b*-1 : b;

      while (d > 0){
          int temp = c % d;
          c = d;
          d = temp;
      }
      return c;
   }

   private static String getSlope(Point a, Point b){
      Integer yd = (a.y - b.y);
      Integer xd = (a.x - b.x);

      int gcd = getGcd(yd, xd);
      if (gcd != 0){
         yd /= gcd;
         xd /= gcd;
      }
      
      if (yd < 0 && xd < 0) {
          yd *= -1;
          xd *= -1;
      }
      else if (xd < 0){
          xd *= -1;
          yd *= -1;
      }
      if (yd == 0){
          yd = a.y;
          xd = 0;
      }
      if (xd == 0){
          xd = a.x;
          yd = 0;
      }
      String slope = yd.toString() + "/" + xd.toString();
      return slope;
   }

   public static int maxPoints(Point[] points){
      if (points == null) return 0;
      if (points.length == 1) return 1;

      int max = 0;
      int len = points.length;
      for (int i = 0; i < len; i++){
         Map<String, Integer> map = new HashMap<String, Integer>();
         int self = 1;
         for (int j = 0; j < len; j++){
            if (i == j) continue;
            if (points[i].x == points[j].x && points[i].y == points[j].y){ 
                self++;
                max = (max < self) ? self : max;
                continue;
            }
            String slope = getSlope(points[i], points[j]);
            Integer value = 1 + self;
            if (map.containsKey(slope)){
               value = map.get(slope);
               value++;
            }
            map.put(slope, value);
            max = (max < value) ? value : max;
         }
      }
      return max;
   }

   public static void main(String[] args){

   }
}
