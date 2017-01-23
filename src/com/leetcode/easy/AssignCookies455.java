package com.leetcode.easy;

/**
 * Created by surag  on 1/22/17.
 * <p>
 * Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at most one cookie. Each child i has a greed factor gi, which is the minimum size of a cookie that the child will be content with; and each cookie j has a size sj. If sj >= gi, we can assign the cookie j to the child i, and the child i will be content. Your goal is to maximize the number of your content children and output the maximum number.
 * <p>
 * Note:
 * You may assume the greed factor is always positive.
 * You cannot assign more than one cookie to one child.
 * <p>
 * Example 1:
 * Input: [1,2,3], [1,1]
 * <p>
 * Output: 1
 * <p>
 * Explanation: You have 3 children and 2 cookies. The greed factors of 3 children are 1, 2, 3.
 * And even though you have 2 cookies, since their size is both 1, you could only make the child whose greed factor is 1 content.
 * You need to output 1.
 * Example 2:
 * Input: [1,2], [1,2,3]
 * <p>
 * Output: 2
 * <p>
 * Explanation: You have 2 children and 3 cookies. The greed factors of 2 children are 1, 2.
 * You have 3 cookies and their sizes are big enough to gratify all of the children,
 * You need to output 2.
 */
public class AssignCookies455 {
    public static void main(String[] args) {

        int[] g = {6, 5, 4, 3, 2, 1}; // greed of children
        int[] s = {1, 1}; // cookie content

        System.out.println(new AssignCookies455().findContentChildren(g, s));

    }

    public int findContentChildren(int[] g, int[] s) {
        if (g == null || g.length == 0 || s == null || s.length == 0) return 0;
        sort(g);
        sort(s);
        // printArray(g);
        // printArray(s);

        int cc = 0;
        int i = 0;
        int j = 0;
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                j++;
                cc++;
            }
            i++;
        }

        return cc;
    }

    public void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "\t");
        }
        System.out.println();
    }

    public void sort(int[] a) {
        qs(a, 0, a.length - 1);
    }

    public void qs(int[] a, int l, int h) {
        if (h > l) {
            int p = partition(a, l, h);
            qs(a, l, p - 1);
            qs(a, p + 1, h);
        }
    }

    public int partition(int[] a, int l, int h) {
        int pivot = a[h];
        int i = l;
        for (int j = l; j < h; j++) {
            if (a[j] >= pivot) {
                // swap a[i] and a[j]
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
            }
        }
        // swap a[i] with a[h](pivot)
        int temp = a[i];
        a[i] = a[h];
        a[h] = temp;
        return i;
    }
}
