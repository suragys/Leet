package com.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/*
Write a program to check whether a given number is an ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.

Note that 1 is typically treated as an ugly number.
*/
// Not a efficient solution will give it a one more try sometime later.
public class UglyNumber_1_263 {
    public boolean isUgly(int num) {
        
        boolean isUgly = false;
        switch (num) {
            case 1:
            case 2:
            case 3:
            case 5:
                isUgly = true;
                break;
            default:
                isUgly = checkIfUgly((num));
                break;
        }
        return isUgly;
    }

    public static boolean checkIfUgly(int num){
        if(num <= 0){
            return false;
        }
       Set<Integer> primes = new HashSet<Integer>();
        int n = num;
        while (n%2 == 0)
        {
        // printf("%d ", 2);
        n = n/2;
        }
        for (int i = 3; i <= (int)Math.sqrt(n); i = i+2)
        {
            // While i divides n, print i and divide n
            while (n%i == 0)
            {
                primes.add(i);
                n = n/i;
            }
        }
        if (n > 2){
//            printf ("%d ", n);
            primes.add(n);
        }
        

        // System.out.println(primes.toString());
         
        if(primes.contains(1)){
            // int ind = primes.indexOf(1);
            primes.remove(1);
            
        }
        if(primes.contains(3)){ 
            
            // int ind = primes.indexOf(3);
            primes.remove(3);
            
        }
        if(primes.contains(5)){
            // int ind = primes.indexOf(5);
            primes.remove(5);
            
        }
        
        

            if(num%3==0 || num%5==0 || num%2==0){
                for(int i : primes){
                    if(num%i==0){
                        return false;
                    }
                }
                return true;
            }
            return false;
            
    }
}
