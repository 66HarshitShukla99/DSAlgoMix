package com.ds.algo.trees;

import java.util.LinkedList;
import java.util.Queue;

import com.ds.algo.BinaryTreeNode;
import com.ds.algo.CreateBinaryTree;

public class HeightWithoutRecursion {

	public static void main(String[] args) {

		BinaryTreeNode root = CreateBinaryTree.createTree();
		
		int k=findHeightWithoutRecursion(root);
		System.out.println(k);
	}

	private static int findHeightWithoutRecursion(BinaryTreeNode root) {
		
		int level=0;
		
		if(root==null) return 0;
		Queue<BinaryTreeNode> q = new LinkedList<>();
		q.add(root);
		int nodeCount=q.size();
		
		while(!q.isEmpty()) {
			
			nodeCount=q.size();
						
			while(nodeCount>0) {
				BinaryTreeNode node=q.poll();
			if(node.left!=null) q.add(node.left);
			if(node.right!=null) q.add(node.right);
			
			nodeCount--;
			}
			level++;
		}
		return level;
	}

}
