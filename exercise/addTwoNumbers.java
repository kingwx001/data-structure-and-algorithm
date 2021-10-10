package exercise;

import java.util.HashMap;

public class addTwoNumbers {
	public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { 
			this.val = val; 
		}
		ListNode(int val, ListNode next) {
			this.val = val; 
			this.next = next; 
		}
	}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		new HashMap<Integer,Integer>();
		int carry = 0,num = 0;
		ListNode dummyHead = new ListNode();
		ListNode cur = dummyHead;
		while(l1 != null || l2 != null)
		{
			int l1Val = l1 == null ? 0 : l1.val;
			int l2Val = l2 == null ? 0 : l2.val;
			num = (l1Val + l2Val + carry) % 10;
			carry = (l1Val + l2Val + carry) / 10;
			cur.next = new ListNode(num,null);
			cur = cur.next;
		}
		if(carry == 1) {
			cur.next = new ListNode(1,null);
		}
		return dummyHead.next;
    }
}
