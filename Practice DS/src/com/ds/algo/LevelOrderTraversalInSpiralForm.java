package com.ds.algo;

import java.util.Stack;

public class LevelOrderTraversalInSpiralForm {

	public static void main(String[] args) {

		BinaryTreeNode root =createTree();
		levelOrderTraversalinSpiralForm(root);
	}
	
	static void levelOrderTraversalinSpiralForm(BinaryTreeNode root){
		Stack<BinaryTreeNode> s1 = new Stack<>();
		Stack<BinaryTreeNode> s2 = new Stack<>();
		
		s1.push(root);
		while(s1.size()!=0 || s2.size()!=0) {
			
			while(s1.size() > 0) {
				BinaryTreeNode node= s1.pop();
				System.out.print(node.data);
				
				if(node.left!=null)
					s2.push(node.left);
				if(node.right!=null)
					s2.push(node.right);
			}
			System.out.println();
			while(s2.size() > 0) {
				BinaryTreeNode node= s2.pop();
				System.out.print(node.data);
				
				if(node.right!=null)
					s1.push(node.right);
				if(node.left!=null)
					s1.push(node.left);
			}
			System.out.println();
			
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
