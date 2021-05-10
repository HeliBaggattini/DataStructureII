package InsertionTest;

import java.util.*;

class TestSearchPerformance {
    // runs many searches and prints the total time for each case

    public static void main(String[] args) {
        int n = 1000000;
        int trials = 10000;

        // fill ordered array with 'n' integers
        ArrayList<Integer> sorted = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            sorted.add(i);
        }

        // copy integers to second array and scramble
        ArrayList<Integer> array = new ArrayList<Integer>(sorted);
        Collections.shuffle(array);

        //hash
        HashSet<Integer> hash  = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            hash.add(i);
        }
        
        //tree set
        TreeSet<Integer> tree  = new TreeSet<Integer>();
        for (int i = 0; i < n; i++) {
            tree.add(i);
        }
        
        System.out.println("data size : " + n);
        System.out.println("searches  : " + trials + "\n");

        // sequential search
        Random r = new Random(1);
        long start = System.currentTimeMillis();
        for (int t = 0; t < trials; t++) {
            array.contains(r.nextInt(n));
        }
        long stop = System.currentTimeMillis();
        System.out.println("sequential: " + (stop - start) / 1000.0 + " s");

        // binary search
        r = new Random(1);
        start = System.currentTimeMillis();
        for (int t = 0; t < trials; t++) {
            Collections.binarySearch(sorted, r.nextInt(n));
        }
        
        stop = System.currentTimeMillis();
        System.out.println("binary    : " + (stop - start) / 1000.0 + " s");
        
        // hash search
        r = new Random(1);
        start = System.currentTimeMillis();
        for (int t = 0; t < trials; t++) {
            hash.contains(r.nextInt(n));
        }
        stop = System.currentTimeMillis();
        System.out.println("hash      : " + (stop - start) / 1000.0 + " s");
    
        // tree search
        r = new Random(1);
        start = System.currentTimeMillis();
        for (int t = 0; t < trials; t++) {
            tree.contains(r.nextInt(n));
        }
        stop = System.currentTimeMillis();
        System.out.println("tree      : " + (stop - start) / 1000.0 + " s");
    
          
    }
   
}
