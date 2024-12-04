// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    // Constructor to create a new node with a given value
    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    // Constructor to create a new node with a given value and next node
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}


class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        // Base case checks
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Step 1: Calculate the length of the list
        int length = 1;  // The list has at least one node
        ListNode temp = head;

        // Traverse the list to find its length and last node
        while (temp.next != null) {
            temp = temp.next;
            length++;
        }

        // Step 2: Make the list circular by linking the last node to the head
        temp.next = head;

        // Step 3: Calculate the effective number of rotations
        k = k % length;  // If k is greater than length, reduce it
        k = length - k;  // The new tail will be at position length - k - 1

        // Step 4: Traverse to the new tail node
        while (k-- > 0) {
            temp = temp.next;
        }

        // Step 5: Set the new head and break the circular link
        head = temp.next;
        temp.next = null;

        // Return the new head of the rotated list
        return head;
    }
}


public class RotateA_LL {
    public static void main(String[] args) {
        // Create a linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Create an instance of Solution to call rotateRight
        Solution solution = new Solution();

        // Rotate the list by 2 positions
        ListNode newHead = solution.rotateRight(head, 2);

        // Print the rotated list
        ListNode temp = newHead;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }
}