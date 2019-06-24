package com.ds.algo;

public class ReverseLinkedList {

	public static void main(String[] args) {
		LinkedListNode l1= new LinkedListNode();
		l1.data=1;
		LinkedListNode l2= new LinkedListNode();
		l2.data=2;
		l1.next=l2;
		LinkedListNode l3= new LinkedListNode();
		l3.data=3;
		l2.next=l3;
		LinkedListNode head=l1;
		head= reverseIteratively(head);
		LinkedListNode next=head.next;
		head.next=null;
		head=reverseRecursively(head,next);
		
		while(head!=null) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(head.data);
			head=head.next;
		}
		//1 -> 2 -> 3
	}
	
	public  static LinkedListNode reverseRecursively(LinkedListNode ptr1,LinkedListNode ptr2) {
		
		if(ptr1==null) return null;
		if(ptr2==null) return ptr1;
		
		LinkedListNode ptr3=ptr2.next;
		ptr2.next=ptr1;
		ptr1=ptr2;
		ptr2=ptr3;
		return reverseRecursively(ptr1, ptr2);
	}

	private static LinkedListNode reverseIteratively(LinkedListNode head) {

		if(head==null) return null;
		LinkedListNode ptr1 = head;
		LinkedListNode ptr2=ptr1.next!=null?ptr1.next:null;
		LinkedListNode ptr3;
		ptr1.next=null;
		while(ptr2!=null) {
			
			ptr3=ptr2.next;
			ptr2.next=ptr1;
			ptr1=ptr2;
			ptr2=ptr3;
		}
		return ptr1;
		
	}
}


