/* Program to return Kth largest number from a stream of numbers. 

 * IDEA: Keep track of the largest K elements seen till now. If we maintain these numbers in a min-heap,
 * its root will give us the Kth max of the stream by default.

*/


import java.util.PriorityQueue;

public class KthLargestGenerator {
    private PriorityQueue<Integer> pq = new PriorityQueue<>();
    int k;

    KthLargestGenerator(int k) {
        this.k = k;
    }

    public int add(int value) {
        if (pq.size() < k - 1) { pq.offer(value); return -1; }
        else if (pq.size() == k - 1) {
            pq.offer(value);
            return pq.peek();
        } else {
            if (value <= pq.peek()) {
                return pq.peek();
            } else {
                pq.poll();
                pq.offer(value);
                return pq.peek();
            }
        }
    }

    public static void main(String[] args) {
        KthLargestGenerator k = new KthLargestGenerator(5);
        System.out.println(k.add(1));
        System.out.println(k.add(2));
        System.out.println(k.add(3));
        System.out.println(k.add(4));
        System.out.println(k.add(5));
        System.out.println(k.add(5));
        System.out.println(k.add(4));
        System.out.println(k.add(6));
        System.out.println(k.add(7));
        System.out.println(k.add(8));
        System.out.println(k.add(9));
        System.out.println(k.add(10));
    }
}