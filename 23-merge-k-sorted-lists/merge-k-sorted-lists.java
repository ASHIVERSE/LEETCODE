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
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        
        
        
        // Min heap
        PriorityQueue<ListNode> pq =
                new PriorityQueue<>((a, b) -> a.val - b.val);

        // Put all list heads into heap
        for (ListNode node : lists) {

            if (node != null) {
                pq.add(node);
            }
        }

        // Dummy node
        ListNode dummy = new ListNode(0);

        // Tail pointer
        ListNode tail = dummy;

        // Process heap
        while (!pq.isEmpty()) {

            // Get smallest node
            ListNode smallest = pq.poll();

            // Attach it
            tail.next = smallest;

            // Move tail
            tail = tail.next;

            // Insert next node
            if (smallest.next != null) {

                pq.add(smallest.next);
            }
        }

        return dummy.next;
    
    }
}