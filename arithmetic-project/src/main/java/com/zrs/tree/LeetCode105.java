package com.zrs.tree;

import java.util.HashMap;
import java.util.Map;

public class LeetCode105 {


    public static void main(String[] args) {
        int[] arr = {1,3,7,9,5,4,8};
        int[] brr = {3,7,1,5,9,4,8};
        t(arr,brr);
    }

    static Map<Integer,Integer> map = new HashMap<>();
    public static void t(int[] arr,int[] brr){
        for (int i = 0; i < brr.length; i++) {
            map.put(brr[i],i);
        }

        TreeNode<Integer> t = t(arr, 0, arr.length - 1, brr, 0, brr.length - 1);
        TreeNode.printPro(t);
    }

    public static TreeNode<Integer> t(int[] arr, int s_a, int e_a, int[] brr, int s_b, int e_b){
        if(s_a >e_a){
            return null;
        }
        TreeNode<Integer> node = new TreeNode<>(arr[s_a]);
        Integer index = map.get(arr[s_a]);
        node.left = t(arr,s_a+1,s_a + index - s_b,brr,s_b,index -1);
        node.right = t(arr,index- s_b + s_a+1,e_a,brr,index+1,e_b);
        return node;
    }
}
