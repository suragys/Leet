package com.leetcode.easy;

/**
 * Created by aijaz on 1/24/17.
 */
public class TargetSum494 {
    public static void main(String[] args) {
//        int[] n = {1,1,1,1,1};
//        int S = 3;
//        int[] n = {1,2,1,3,2};
//        int S = 7;
        int[] n = {1};
        int S = 1;
        System.out.println(new TargetSum494().findTargetSumWays(n,S));
    }
    public class Node {
        int v;
        Node r;
        Node l;
        public Node(int val) {
            v = val;
        }
    }
    public int findTargetSumWays(int[] nums, int S) {
        Node root = new Node(0);
        int res = buildTree(root,nums,0,S);

       // printele(root);
        return  res;


    }


    public int buildTree(Node root, int[] a, int i, int S) {
//        if (root == null) return 0;
        int c = 0;
        if(i < a.length) {
            root.l = new Node(root.v - a[i]);
            root.r = new Node(root.v + a[i]);
            i++;
            c  = buildTree(root.l, a, i, S);
            c += buildTree(root.r, a, i, S);
        } else{
            if(root.v ==  S){
                c++;
            }
        }
        return c;
    }
}
