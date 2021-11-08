import java.util.List;

/**
 * @author 86171
 */

class ListNode{
    int val;
    ListNode next;
    ListNode(){};
    ListNode(int val){this.val=val;}
    ListNode(int val,ListNode next){this.val=val;this.next=next;}


}
public class addTwoNumbers_02 {
    public static void main(String[] args) {

    ListNode l1 = new ListNode(2);
    l1.next = new ListNode(4);
    l1.next.next = new ListNode(3);

    ListNode l2 = new ListNode(5);
    l2.next = new ListNode(6);
    l2.next.next = new ListNode(4);

    Solution s = new Solution();
    ListNode ans=s.addTwoNumbers(l1,l2);
    System.out.println(ans.next.val);
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;
        int carry = 0;
        int sum = 0;
        while (l1 != null || l2 != null){

            int num1 = l1 != null ? l1.val:0;
            int num2 = l2 != null ? l2.val:0;
            sum = num1 +num2 +carry;
            if (head ==null){
                head = tail = new ListNode(sum%10);
            }else {

                tail.next =  new ListNode(sum%10);
                tail = tail.next;

            }
            carry= sum/10;
            if (l1!= null){
                l1 =l1.next;
            }
            if (l2!= null){
                l2 =l2.next;

            }
        }

        if (carry >0){
            ListNode node = new ListNode(carry);
            tail.next = node;
        }
        return head;
    }
}