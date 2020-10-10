import java.util.PriorityQueue;

public class KthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> n1 - n2);
        for (int n : nums) {
            pq.add(n);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.poll();
    }

    public static void main(String[] args) {
	// write your code herr
    }
}

class Test {
    public static void main(String[] args) {
        KthLargest findK = new KthLargest();
        int[] array = new int[]{3, 2, 1, 2, 5, 6, 4};
        int k = 6;
        int ans = findK.findKthLargest(array, k);
        System.out.println(ans);
        array = new int[]{1};
        k = 1;
        ans = findK.findKthLargest(array, k);
        System.out.println(ans);
    }
}
