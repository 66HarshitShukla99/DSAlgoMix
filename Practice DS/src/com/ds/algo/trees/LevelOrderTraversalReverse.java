package com.ds.algo.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.ds.algo.BinaryTreeNode;
import com.ds.algo.CreateBinaryTree;

public class LevelOrderTraversalReverse {

	public static void main(String[] args) {

		BinaryTreeNode root = CreateBinaryTree.createTree();
		
		levelOrderTraversalReverse(root);
	}

	private static boolean levelOrderTraversalReverse(BinaryTreeNode root) {

		if(root==null) return false;
		
		Stack<BinaryTreeNode> stack = new Stack<>();
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		while(root!=null) {
			if(root.left==null && root.right==null) break;
			if(root.left!=null) {
				stack.push(root.left);
				root=root.left;
				}
			else if(root.left==null) {
				stack.push(root.right);
				root=root.right;
			}
			
		}
		return false;
		
		
		
		
		
	}

}
