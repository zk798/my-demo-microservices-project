package com.zrs.tree;

import lombok.Data;

@Data
public class TreeNode<T> {
    T value;
    TreeNode<T> left;
    TreeNode<T> right;

    public TreeNode(T value){
        this.value =value;
    }

    public static void printPro(TreeNode root){
        if(root == null){
            return;
        }
        System.out.println(root.value);
        if(root.left != null){
            printPro(root.left);
        }
        if(root.right != null){
            printPro(root.right);
        }
    }

    public static void printIn(TreeNode root){
        if(root == null){
            return;
        }
        if(root.left != null){
            printIn(root.left);
        }
        System.out.println(root.value);
        if(root.right != null){
            printIn(root.right);
        }

    }
    public static void printLater(TreeNode root){
        if(root == null){
            return;
        }
        if(root.left != null){
            printLater(root.left);
        }
        if(root.right != null){
            printLater(root.right);
        }
        System.out.println(root.value);
    }

    public static void main(String[] args) {
        TreeNode<String> A = new TreeNode<>("A");
        TreeNode<String> B = new TreeNode<>("B");
        TreeNode<String> C = new TreeNode<>("C");
        TreeNode<String> D = new TreeNode<>("D");
        TreeNode<String> E = new TreeNode<>("E");
        TreeNode<String> F = new TreeNode<>("F");

        A.left=B;
        A.right=C;
        B.left=D;
        B.right=E;
        C.left=F;

        //printPro(A);
//        printIn(A);
        printLater(A);

    }
}
