package com.ds.algo;

public class LowestCommonAncestor {

	public static void main(String[] args) {
		
		BinaryTreeNode root=new BinaryTreeNode();
		root.data=1;
		BinaryTreeNode b1=new BinaryTreeNode();
		b1.data=2;
		root.left=b1;
		BinaryTreeNode b4= new BinaryTreeNode();
		b4.data=5;
		b1.left=b4;
		BinaryTreeNode b2=new BinaryTreeNode();
		b2.data=3;
		root.right=b2;
		BinaryTreeNode b3=new BinaryTreeNode();
		b3.data=4;
		b2.left=b3;
		BinaryTreeNode b5= new BinaryTreeNode();
		b5.data=6;
		b2.right=b5;
		
		//int ret=findLowestCommonAncestor(5,3,root);
		BinaryTreeNode ret=findLowestCommonAncestor2(5,2,root);
		System.out.println(ret.data);

	}

	public static BinaryTreeNode findLowestCommonAncestor2(int n1, int n2, BinaryTreeNode root) {
		
		if(root==null) return null;
		
		if(root.data==n1 || root.data==n2) return root;
		
		BinaryTreeNode left_node=findLowestCommonAncestor2(n1, n2, root.left);
		BinaryTreeNode right_node=findLowestCommonAncestor2(n1, n2, root.right);
		
		if(left_node!=null && right_node!=null) return root;
		return left_node!=null?left_node:right_node;
		
	}

	public static int findLowestCommonAncestor(int i, int j, BinaryTreeNode node) {
		boolean bL= search(node.left,i,j);
		boolean bR= search(node.right,i,j);
		if(bL && bR) return node.data;
		else if(bL) return findLowestCommonAncestor(i, j, node.left);
		else return findLowestCommonAncestor(i, j, node.right);
		
	}
	//inorder traversal of tree
	
	private static boolean search(BinaryTreeNode node, int i, int j) {
		if(node!=null) {
			if(node.data==i || node.data==j) return true;
			else return search(node.left,i,j) || search(node.right,i,j);
		}
		return false;
			
		
	}

}
