package com.leetcode.easy;

import java.util.ArrayList;

/**
 * Created by surag on 1/25/17.
 * <p>
 * For a web developer, it is very important to know how to design a web page's size. So, given a specific rectangular web page’s area, your job by now is to design a rectangular web page, whose length L and width W satisfy the following requirements:
 * <p>
 * 1. The area of the rectangular web page you designed must equal to the given target area.
 * <p>
 * 2. The width W should not be larger than the length L, which means L >= W.
 * <p>
 * 3. The difference between length L and width W should be as small as possible.
 * You need to output the length L and the width W of the web page you designed in sequence.
 * Example:
 * Input: 4
 * Output: [2, 2]
 * Explanation: The target area is 4, and all the possible ways to construct it are [1,4], [2,2], [4,1].
 * But according to requirement 2, [1,4] is illegal; according to requirement 3,  [4,1] is not optimal compared to [2,2]. So the length L is 2, and the width W is 2.
 * Note:
 * The given area won't exceed 10,000,000 and is a positive integer
 * The web page's width and length you designed must be positive integers.
 */
public class ConstructTheRectangle492 {

    // TODO add test cases.
    
    public int[] constructRectangle(int area) {

        // return bruteForce(area);
        // return reverseBrute(area);
        // return factorApproach(area);
        return squareRootApproach(area);

    }

    public int[] squareRootApproach(int a) {
        int w = (int) Math.sqrt(a);
        while(a%w != 0) w--;
        return new int[]{a/w, w};
    }

    public int[] reverseBrute(int a) {
        int l = 1;
        int w = a;

        while(l < w) {
            l++;
            if(a%l == 0){
                w = a/l;
            }
        }

        l = Math.max(l,w);
        w = Math.min(l,w);
        int[] n = {l,w};
        return n;
    }

    public int[] factorApproach(int area) {
        ArrayList<Integer> f = new ArrayList<Integer>();
        f.add(1);
        int a = area;
        int i = 2;
        while(a > 1){
            if(a%i == 0){
                f.add(i);
                a /= i;
            } else {
                i++;
            }
        }
        System.out.println(f.toString());
        // TODO need to complete the implementation by generating all possible combinations and then find the best w and l.
        return null;

    }

    public int[] bruteForce(int area) {
        int[] n = {area,1}; // l,w
        int l = area;
        int w = 1;

        while(l >= w){
            while(area >= l * w){
                if(l * w == area){
                    n[0] = l;
                    n[1] = w;
                }
                w++;
            }
            l--;
        }
        return n;
    }
}
