import java.util.*;

public class Quick {
  public static void sort (Comparable[] a) {
    //Collections.shuffle(a);
    sort(a, 0, a.length-1);
  }
  private static void sort(Comparable[] a, int lo, int hi) {
    if (hi <= lo) return;
    int j = partition(a,lo,hi);
    sort (a, lo, j-1); // Sort the left half of a[]
    sort (a, j+1, hi); // Sort the right half of a[]
  }

  private static int partition (Comparable[] a, int lo, int hi) {
    // Partition into a[lo...i-1], a[i], a[i+1..hi]
    int i = lo, j = hi+1; // left and right scan indices
    Comparable v = a[lo]; // partitioning item
    while (true) {
      while (less(a[++i], v)) if (i == hi) break;
      while (less(v, a[--j])) if (j == lo) break;
      if (i >= j) break;
      exch(a,i,j);
    }
    exch(a, lo, j);
    return j;
  }

  private static boolean less (Comparable v, Comparable w) {
    return v.compareTo(w) < 0;
  }

  private static void exch (Comparable[] a, int i, int j) {
    Comparable t = a[i]; a[i] = a[j]; a[j] = t;
  }

  private static void show(Comparable[] a) {
    for (int i = 0; i < a.length; i++)
      System.out.print(a[i] + " ");
    System.out.println();
  }

  public static void main(String[] args) {
    Integer[] a = new Integer[10];
    Random rand = new Random();
    rand.setSeed(System.currentTimeMillis());
    for (Integer i = 0; i < a.length; i++) {
      a[i] = rand.nextInt(100);
    }
    show(a);
    sort(a);
    show(a);
  }
}
