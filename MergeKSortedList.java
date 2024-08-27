/*
    L.C: 23. Merge k Sorted Lists

    Approach: Min heap and list traversal

    Working:

        Declare a Priority queue of type ListNode - provise the required comperator
        declare a dummy node //for the result
        declare curr - dummy //for traversal

        iterate through the lists array ad add the head to the PQ

        loop when pq IS NOT EMPTY

            min = PQ.poll() ->ListNode
            set curr next to min
            move curr pointet to next

            if min.next NOT NULL
                add it to the PQ  //in this way the whole list will be traversed

        return dummy.next


    Time Complexity: O(nk log k)
        k - number of list/elements in the heap
        n - number of elements in each linked list

    Space Complexity: O(k) //heap size -
 */


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class MergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {

        if(lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)-> a.val - b.val);
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        for(ListNode node: lists) { //O(k)
            if(node != null) {
                pq.add(node);  // O(log k)
            }
        }

        while(!pq.isEmpty()) {

            ListNode min = pq.poll(); //O(log k)
            curr.next = min;
            curr = curr.next;

            if(min.next != null) {
                pq.add(min.next); //O(log k)
            }
        }
        return dummy.next;
    }
}
