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
    int carry = 0;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode resultF;
        resultF = result;
        if (l1 != null && l2 != null) {
            int temp = handleCarry(l1.val + l2.val);
            result.val = temp;
            l1 = l1.next;
            l2 = l2.next;

            while (l1 != null) {
                if (l2 != null) {
                    temp = handleCarry(l1.val + l2.val + carry);
                    result.next = new ListNode(temp);
                    l1 = l1.next;
                    l2 = l2.next;
                    result = result.next;
                } else {
                    break;
                }
            }
        }
        if (l1 == null && l2 == null) {
            if (carry != 0) {
                result.next = new ListNode(carry);
            }
        } else {
            if (l1 != null && l2 == null) {
                result.next = l1;
            } else if (l1 == null && l2 != null) {
                result.next = l2;
            }
            result = result.next;
            int temp;
            while (true) {
                temp = handleCarry(result.val + carry);
                result.val = temp;
                if (result.next == null) {
                    if (carry != 0) {
                        result.next = new ListNode(carry);
                    }
                    break;
                }
                result = result.next;
            }
        }
        return resultF;
    }

    public int handleCarry(int temp) {
        int res;
        if (temp > 9) {
            res = temp % 10;
            carry = (temp / 10);
        } else {
            carry = 0;
            res = temp;
        }
        return res;
    }
}