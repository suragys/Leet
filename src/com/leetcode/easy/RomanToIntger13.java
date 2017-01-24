package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by surag on 1/23/17.
 */
public class RomanToIntger13 {

    private static int i = 0;

    public static void main(String[] args) {
        System.out.println(new RomanToIntger13().romanToInt("III"));
        System.out.println(new RomanToIntger13().romanToInt("IV"));
        System.out.println(new RomanToIntger13().romanToInt("VIII"));
        System.out.println(new RomanToIntger13().romanToInt("XCIX"));
        System.out.println(new RomanToIntger13().romanToInt("MMMCMXCIX"));

    }
    public class Node {
        char key;
        int val;
        List<Node> childNodes;

        public Node(char key, int val) {
            this.key = key;
            this.val = val;
            childNodes = new ArrayList<>();
        }
    }

    public int romanToInt(String s) {
        //return romanToIntBig(s);

        return romanToIntMath(s);
    }

    public int romanToIntMath(String s){
        int res = 0;

        for(int i = 0; i < s.length(); i++){
            //s = s.toUpperCase();

            char x = s.charAt(i);
            // System.out.println(x);
            if(x == 'I') res += 1;
            if(x == 'V') res += 5;
            if(x == 'X') res += 10;
            if(x == 'L') res += 50;
            if(x == 'C') res += 100;
            if(x == 'D') res += 500;
            if(x == 'M') res += 1000;

        }

        if(s.indexOf("IV") != -1) res -= 2;
        if(s.indexOf("IX") != -1) res -= 2;
        if(s.indexOf("XL") != -1) res -= 20;
        if(s.indexOf("XC") != -1) res -= 20;
        if(s.indexOf("CD") != -1) res -= 200;
        if(s.indexOf("CM") != -1) res -= 200;

        return res;



    }

    public int romanToIntBig(String s) {

        // create tree for units, tens, hundreds and thousanuds representation
        Node one = new Node('I', 1);
        Node two = new Node('I', 1);
        Node three = new Node('I', 1);
        Node four = new Node('I', -1);
        Node five = new Node('V', 5);
        Node six = new Node('V', 5);
        Node seven = new Node('V', 5);
        Node eight = new Node('V', 5);
        Node nine = new Node('I', -1);

        three.childNodes.add(eight);
        two.childNodes.add(three);
        two.childNodes.add(seven);
        one.childNodes.add(two);
        one.childNodes.add(six);

        five.childNodes.add(four);


        Node ten = new Node('X', 10);
        Node twenty = new Node('X', 10);
        Node thirty = new Node('X', 10);
        Node forty = new Node('X', -10);
        Node fifty = new Node('L', 50);
        Node sixty = new Node('L', 50);
        Node seventy = new Node('L', 50);
        Node eighty = new Node('L', 50);
        Node ninety = new Node('X', -10);

        thirty.childNodes.add(eighty);
        twenty.childNodes.add(thirty);
        twenty.childNodes.add(seventy);
        ten.childNodes.add(twenty);
        ten.childNodes.add(sixty);
        ten.childNodes.add(nine);

        fifty.childNodes.add(forty);


        Node oneH = new Node('C', 100);
        Node twoH = new Node('C', 100);
        Node threeH = new Node('C', 100);
        Node fourH = new Node('C', -100);
        Node fiveH = new Node('D', 500);
        Node sixH = new Node('D', 500);
        Node sevenH = new Node('D', 500);
        Node eightH = new Node('D', 500);
        Node nineH = new Node('C', -100);

        threeH.childNodes.add(eightH);
        twoH.childNodes.add(threeH);
        twoH.childNodes.add(sevenH);
        oneH.childNodes.add(twoH);
        oneH.childNodes.add(sixH);
        oneH.childNodes.add(ninety);

        fiveH.childNodes.add(fourH);


        Node oneT = new Node('M', 1000);
        Node twoT = new Node('M', 1000);
        Node threeT = new Node('M', 1000);


        twoT.childNodes.add(threeT);
        oneT.childNodes.add(twoT);
        oneT.childNodes.add(nineH);

        i = s.length() - 1;
        int n = 0;

        while(i >=0){
            if(s.charAt(i) == one.key){
                n += findVal(one, s);
            } else if(s.charAt(i) == five.key){
                n += findVal(five, s);
            } else if(s.charAt(i) == ten.key){
                n += findVal(ten, s);
            } else if(s.charAt(i) == fifty.key){
                n += findVal(fifty, s);
            } else if(s.charAt(i) == oneH.key){
                n += findVal(oneH, s);
            } else if(s.charAt(i) == fiveH.key){
                n += findVal(fiveH, s);
            }else if(s.charAt(i) == oneT.key){
                n += findVal(oneT, s);
            }
            i--;
        }

        return n;



    }

    private Node hasString(List<Node> childNodes, char c) {
        for(Node n : childNodes) {
            if(n.key == c) return n;
        }
        return null;
    }

    private int findVal(Node temp,String s){
        int n = 0;
        n += temp.val;

        while(i - 1 >= Integer.valueOf(0) && (temp = hasString(temp.childNodes, s.charAt(i-1))) != null ) {
            n += temp.val;
            i--;
        }
        return n;
    }
}
