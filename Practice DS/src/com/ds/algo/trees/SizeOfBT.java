package com.ds.algo.trees;

import java.util.LinkedList;
import java.util.Queue;

import com.ds.algo.BinaryTreeNode;

public class SizeOfBT {

	public static void main(String[] args) {

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
		BinaryTreeNode b6= new BinaryTreeNode();
		b6.data=7;
		b1.right=b6;
		
		System.out.println(findSizeOfBTRecursive(root));
		System.out.println(findSizeOfBTLevelOrderTraversal(root));
	}

	private static int findSizeOfBTLevelOrderTraversal(BinaryTreeNode root) {
		Queue<BinaryTreeNode> q= new LinkedList<>();
		
		if(root==null) return 0;
		q.add(root);
		int count=q.size();
		while(true) {
			int loop=q.size();
			while(loop > 0) {
				BinaryTreeNode node= q.poll();
				if(node.left!=null) q.add(node.left);
				if(node.right!=null) q.add(node.right);
				loop--;
			}
			count+=q.size();
			if(q.isEmpty()) break;
			
		}
		return count;
		
	}

	private static int findSizeOfBTRecursive(BinaryTreeNode root) {
		if(root==null) return 0;
		int left=0;
		int right=0;
		
		if(root.left!=null) left= findSizeOfBTRecursive(root.left);
		if(root.right!=null) right=findSizeOfBTRecursive(root.right);
		return left+right+1;
		
	}

}
