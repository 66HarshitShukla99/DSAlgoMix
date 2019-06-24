package com.ds.algo;

import java.util.LinkedList;
import java.util.Queue;

public class LevelWithMaxNodesInBTree {

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
		
		int l=findLevelWithMaxNodesInTree(root);
		System.out.println(l);
	}

	private static int findLevelWithMaxNodesInTree(BinaryTreeNode node) {

		if(node==null) return 0;
		if(node.left==null && node.right==null) return 1;
		
		Queue<BinaryTreeNode> queue= new LinkedList<>();
		
		queue.add(node);
		int level=0;
		int max=Integer.MIN_VALUE;
		int level_no = 0;
		
		while(true) {
			int nodeCount=queue.size();
			if(nodeCount==0) break;
			if(nodeCount > max) {
				max=nodeCount;
				level_no=level;
			}
			while(nodeCount > 0 ) {
				BinaryTreeNode binaryTreeNode = queue.peek();
				queue.poll();
				if(binaryTreeNode.left!=null)
					queue.add(binaryTreeNode.left);
				if(binaryTreeNode.right!=null) 
					queue.add(binaryTreeNode.right);
				nodeCount--;
			}
			level++;
		}
		return level_no;
	}

}
