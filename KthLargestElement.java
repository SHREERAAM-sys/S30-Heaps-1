/*

    L.C: 215. Kth Largest Element in an Array

    Approach: MinHeap

    Working:

        Decleare a priority queue //internally min heap implementation
        Declare min -> MAX_VALUE of Integer

        iterate over the array
            add the elements in the array to the queue

            when the size > n-k
                remove the root i.e poll the lement from the queue

                check if the polled value is minimum and assign it to minimum


        return min//which return the kth largest elemtn in the array

    Time Complexity: O(n log n-k)
    Space Complexity: O(n-k)
 */

class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {

        if(nums == null || nums.length == 0) {
            return -1;
        }

        PriorityQueue<Integer> q  = new PriorityQueue<>((a,b) -> b - a);
        int min = Integer.MAX_VALUE;

        int n = nums.length;

        for(int i=0;i<n; i++) {

            q.add(nums[i]);

            if(q.size() > n-k) {

                int val = q.poll();
                //min = Math.min(val, min); - alternative to if condition
                if( val < min ){
                    min = val;

                }
            }
        }

        return min;
    }
}