import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// Wrapper class for the InsertIntervals LeetCode problem. It also includes 
// tests -jrg
//
class InsertInterval {

   private static boolean contains(Interval i, int element){
      return (element >= i.start && element <= i.end);
   }

   private static int binarySearch(List<Interval> list, int element){
      int a = 0;
      int b = list.size()-1;
      while (a < b){
         int m = (b+a)/2;
         Interval i = list.get(m);
         if (contains(i, element)){
            a = m;
            b = m;
         }
         else if (element < i.start)
            b = m - 1;
         else
            a = m + 1;
      }
      return a;
   }

   public static List<Interval> insertInterval(List<Interval> intervals, Interval newInterval){
      List<Interval> merged = new ArrayList<Interval>();
      if (intervals == null && newInterval == null) return merged;
      if (intervals == null){
         merged.add(newInterval);
         return merged;
      }

      int size = intervals.size();

      int start = newInterval.start;
      int end = newInterval.end;

      int si = binarySearch(intervals, start);
      int ei = binarySearch(intervals, end);

      int i;
      for (i = 0; i < si && i < size; i++)
         merged.add(intervals.get(i));

      Interval ks = intervals.get(si);
      if (start > ks.end)             // start follows
         merged.add(ks);
      else if (contains(ks, start))   // contains start
         start = ks.start;
                                      // start is prior
      
      if (end < ks.start){            // end is prior
         merged.add(newInterval);
         merged.add(ks);
      }
      else if (contains(ks, end)){    // contains end
         end = ks.end;
         merged.add(new Interval(start,end));
      }
      else{                           // next interval
         Interval ke = intervals.get(ei); 
         if (end < ke.start){         // end is prior
            merged.add(new Interval(start,end));
            merged.add(ke);
         }
         else if (contains(ke, end)){ // contains end
            merged.add(new Interval(start, ke.end));
         }
         else{                        // end follows
            merged.add(new Interval(start, end));
         }
      }

      for (i = ei+1; i < size; i++)
         merged.add(intervals.get(i));


      return merged;
   }

   // method to create a list of test intervals
   public static List<Interval> createList(){
      List<Interval> I = new ArrayList<Interval>();
      I.add(new Interval(1,3));
      I.add(new Interval(13,14));
      I.add(new Interval(15,23));
      I.add(new Interval(7,9));
      I.add(new Interval(25, 43));

      Collections.sort(I, new Comparator<Interval>(){
         @Override
         public int compare(Interval lhs, Interval rhs){
            if (lhs.start == rhs.start) return 0;
            return (lhs.start < rhs.start) ? -1 : 1;
         }
      });

      return Collections.unmodifiableList(I);
   }

   public static <T> void print(List<T> list){
      System.out.print("[");
      for (int i = 0; i < list.size(); i++){
         if (i+1<list.size())
            System.out.print(list.get(i) + ", ");
         else
            System.out.print(list.get(i));
      }
      System.out.println("]");
   }

   public static <T> void print(T t){
      System.out.println(t);
   }

   public static void main(String[] args){
      List<Interval> merged;
      List<Interval> intervals = createList();
      Interval[] Is = {new Interval(16, 23), new Interval(0,24), new Interval(0,0), 
                       new Interval(44,44), new Interval(4,24), new Interval(3,25), 
                       new Interval(0,44)};

      for (Interval i : Is){
         System.out.println("Using the following intervals,...");
         System.out.print("intervals   = ");
         print(intervals);
         System.out.print("newInterval = ");
         print(i);
         merged = insertInterval(intervals, i);
         System.out.print("merged      = ");
         print(merged);
         System.out.println();
      }

      System.out.println("Passing null for both params,...");
      merged = insertInterval(null, null);
      print(merged);

      System.out.println("Passing null for intervals,...");
      merged = insertInterval(null, new Interval());
      print(merged);
   }
}
