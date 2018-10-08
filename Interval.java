// Class Interval is a given for some LeetCode problems. This is my take on
// it - jrg
//

class Interval {
   public final int start;
   public final int end;

   public Interval(){
      this(0, 0);
   }

   public Interval(int start, int end){
      this.start = start;
      this.end = end;
   }
}
