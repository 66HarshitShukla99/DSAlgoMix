package com.ds.algo;

public class SecondLargestElementInBST {

	public static void main(String[] args) {
		
		BinaryTreeNode node = new BinaryTreeNode();
		node.data=4;
		BinaryTreeNode node1 = new BinaryTreeNode();
		node1.data=1;
		BinaryTreeNode node2= new BinaryTreeNode();
		node2.data=5;
		node.left=node1;
		node.right=node2;
		/*
		 * 		4
		 * 	   / \
		 * 	  1   5
		 */

		int k=findSecondLargest(node);
		System.out.println(k);
		
	}
	

	private static int findSecondLargest(BinaryTreeNode node) {
		Integer count=0;
		int k=findSecondLargestUtil(node,count);
		
		return k;
	}

	private static BinaryTreeNode findSecondLargestUtil(BinaryTreeNode node, Integer count) {
		
		if(node==null) return null;
		if(node.right==null) return node;
		else {
			findSecondLargestUtil(node.right, count);
			count++;
			if(count == 2) return node;
			//findSecondLargestUtil(node.left, count);
		}
	}


	private static BinaryTreeNode createTree() {
		BinaryTreeNode root=new BinaryTreeNode();
		root.data=1;
		BinaryTreeNode b1= new BinaryTreeNode();
		b1.data=2;
		root.left=b1;
		BinaryTreeNode b4= new BinaryTreeNode();
		b4.data=5;
		b1.left=b4;
		BinaryTreeNode b2= new BinaryTreeNode();
		b2.data=3;
		root.right=b2;
		BinaryTreeNode b3= new BinaryTreeNode();
		b3.data=4;
		b2.left=b3;
		BinaryTreeNode b5= new BinaryTreeNode();
		b5.data=6;
		b2.right=b5;
		return root;
	}
}
