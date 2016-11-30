package org.ldong.java.datastructure.binaryTree;

import java.util.Stack;

public class BinaryTreeStudy {
	class TreeNode{
		Object data;
		TreeNode root;
		TreeNode left;
		TreeNode right;
		
	}
	private int getTotalCountOfTree(TreeNode node){
		
		if(node == null){
			return 0;
		}
		return getTotalCountOfTree(node.left) + getTotalCountOfTree(node.right) +1;
	}
	private int getMaxHeight(TreeNode node){
		if(node == null){
			return 0;
		}
		int leftHeight = getMaxHeight(node.left);
		int rightHeight = getMaxHeight(node.right);
		return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
	}
	
	private int getNumbersOfleafs(TreeNode root){
		if(root == null){
			return 0;
		}
		if(root.left == null && root.right == null){
			return 1;
		}
		int numbersLeft = getNumbersOfleafs(root.left);
		int numebersRight = getNumbersOfleafs(root.right);
		return numbersLeft + numebersRight;
	}
	private TreeNode mirror(TreeNode root){
		if(root == null){
			return null;
		}
		TreeNode leftNode = mirror(root.left);
		TreeNode rightNode = mirror(root.right);
		root.right = leftNode;
		root.left = rightNode;
		return root;
		}
	private void mirror1(TreeNode root){
		if(root == null){
			return;
		}
		Stack nodeStack = new Stack();
		nodeStack.add(root);
		while(!nodeStack.isEmpty()){
			TreeNode curretNode = (TreeNode) nodeStack.pop();
			swap(curretNode.left,curretNode.right);
			
			if(curretNode.left != null) nodeStack.push(curretNode.left);
			if(curretNode.right != null) nodeStack.push(curretNode.right);
		}

	}
	private void swap(TreeNode fristNode,TreeNode secondNode){
		TreeNode temp;
		temp = fristNode;
		fristNode = secondNode;
		secondNode = temp;
	}
}
