public class MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq; // heap ordered complete binary tree
    private int N = 0; // pq[1..n] with pq[0] unused

    public MaxPQ (int maxN) { pq = (Key[]) new Comparable[maxN + 1]; }

    public boolean isEmpty() { return N==0; }

    public int size() { return N; }

    public void insert(Key v) {
        pq[++N] = v;
        swim(N);
    }

    public Key delMax() {
        Key max = pq[1]; // Retrieve max key from the top
        exch(1, N--); // Exchange with last item
        pq[N+1] = null; // Avoid loitering
        sink(1); // restore heap property
        return max;
    }

    private void swim(int k) {
        while (k > 1 && less(k/2, k)) {
            exch(k/2, k);
            k = k/2;
        }
    }

    private void sink(int k) {
        while (2*k <= N) {
            int j = 2*k;
            if (j < N && less(j, j+1)) j++;
            if (!less(k,j)) break;
            exch(k, j);
            k = j;
        }
    }

    private static boolean less (int j, int k) { return j < k; }
    private static void exch(int i, int j) { int t = a[i]; a[i] = a[j]; a[j] = t; }
}