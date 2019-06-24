package com.ds.algo;

public class MinimumPathBetweenTwoNodes {

	public static void main(String[] args) {

		BinaryTreeNode root = createTree();
		
		System.out.println(minimumPathBetweenTwoNodes(root));
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

	private static int minimumPathBetweenTwoNodes(BinaryTreeNode root) {
		
		int count=0;
		int n1=2; int n2=4;
		BinaryTreeNode lca=LowestCommonAncestor.findLowestCommonAncestor2(n1, n2, root);
		
		count=findMinNodes(lca,root,n1,n2);
		
		return count;
	}

	private static int findMinNodes(BinaryTreeNode node,BinaryTreeNode root, int n1, int n2) {
		
		BinaryTreeNode node1=new BinaryTreeNode();
		node1.data=n1;
		
		BinaryTreeNode node2=new BinaryTreeNode();
		node2.data=n2;
		
		int c2=findLevel(node1,root,0);
		
		int c3=findLevel(node2,root,0);
		
		return c2+c3;
	}

	private static int findLevel(BinaryTreeNode node,BinaryTreeNode root, int level) {
		if(root==null) return -1;
		if(root.data==node.data) return level;
		int left=findLevel(node, root.left,level+1);
		
		if(left==-1)
			left=findLevel(node, root.right, level+1);
		return left;
	}

}
