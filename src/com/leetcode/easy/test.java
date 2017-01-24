package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aijaz on 1/22/17.
 */
public class test {


    public static void main(String[] args) {

        String x = "10";

         x = changeX(x);
        System.out.println(x);

        Integer[] A = new Integer[1];
        A[0] = 10;

        ChangeA(A);

        for(int i = 0; i < A.length; i++){
            System.out.println(A[i]);
        }


        List<Integer> l = new ArrayList<>();
        l.add(1);

        changeL(l);

        for (Integer i :
                l) {
            System.out.println(i);
        }

        int x1 = 11;
        Integer a = new Integer(x1);
        changeInteger(a);
        System.out.println(a);

    }

    private static void changeL(List<Integer> l) {
        l.add(2);
        return;
    }

    private static void ChangeA(Integer[] A) {


        A[0] = 100000;

        for(int i = 0; i < A.length; i++){
            System.out.println(A[i]);
        }

        return;


    }

    private static String changeX(String x) {
        x ="100";
        return x;
    }

    private static void changeInteger(Integer a) {
//        a = 1111;

            a = new Integer(22);

        return  ;
    }
}
