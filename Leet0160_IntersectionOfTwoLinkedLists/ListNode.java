package Leet0160_IntersectionOfTwoLinkedLists;

/**
 * Definition for singly-linked list node.
 * This class represents a node in a singly linked list.
 * Each node contains a value and a reference to the next node in the list.
 */
public class ListNode {
    // The value stored in this node
    int val;

    // Reference to the next node in the linked list
    // If this is null, it means this node is the end of the list
    // Unless there's a cycle
    ListNode next;

    /**
     * Constructor to create a new ListNode with a specified value.
     * The next pointer is initialized to null.
     *
     * @param x The value to be stored in this node
     */
    public ListNode(int x) {
        val = x;
        next = null;
    }

    /**
     * Constructor to create a new ListNode with a specified value
     * and a reference to the next node.
     *
     * @param x    The value to be stored in this node
     * @param next The next node in the linked list
     */
    public ListNode(int x, ListNode next) {
        val = x;
        this.next = next;
    }

    /**
     * Returns a string representation of this node's value.
     *
     * @return String representation of the node's value
     */
    @Override
    public String toString() {
        return String.valueOf(val);
    }
}