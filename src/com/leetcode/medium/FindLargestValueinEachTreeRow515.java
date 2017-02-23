package com.leetcode.medium;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by surag on 2/16/17.
 */
public class FindLargestValueinEachTreeRow515 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> largestValues(TreeNode root) {
        if (root == null) return new ArrayList<Integer>();

        return leveOrderTraversalSoution(root);

    }

    public List<Integer> leveOrderTraversalSoution(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        TreeNode r = null;
        q.offer(root);
        while (!q.isEmpty()) {
            int qs = q.size();
            int max = Integer.MIN_VALUE;
            // TreeSet<Integer> ts = new TreeSet<Integer>();
            // using tree set slows the running time.
            for (int i = 0; i < qs; i++) {
                TreeNode t = q.poll();
                // ts.add(t.val);
                if (max < t.val) max = t.val;
                if (t.left != null) q.offer(t.left);
                if (t.right != null) q.offer(t.right);
            }
            res.add(max);
        }
        return res;
    }
}
