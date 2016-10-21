package com.leetcode.easy;

public class PowerOfTwo231 {
    public boolean isPowerOfTwo(int n) {
        //return divideByTwo(n);
        //return checkAll(n);
        // return checkNextPower(n);
        // return linearSearch(n);
        //return binarySearch(n);
        //return countOnes(n);
        //return shiftRight(n);
        //return decrementAndCompare(n);
        return complementAndCompare(n);
        //return bitCount(n);
    }
    
    public static boolean bitCount(int x){
        int c = Integer.bitCount(x);
        System.out.println(c);
        return c ==1 && x > 0;
        
    }
    public static boolean complementAndCompare(int x){
        return ((x != 0) && ((x & (~x + 1)) == x) && x > 0);
    }
    
    // does not work for negative number
    public static boolean decrementAndCompare(int n){
        return (n != 0 && (n & n-1) == 0 );
    }
    public static boolean shiftRight(int n) {
        while((n & 1) == 0 && n > 1){
            n = n >> 1;
        }
        return n == 1;
    }
    
    public static boolean countOnes(int n) {
        int numOnes = 0;
        
        while(n > 0 && numOnes < 2){
            if((n & 1) == 1){
                numOnes ++;
            }
            n = n >> 1;
        }
        return numOnes == 1;
    }
    
    // have to spend time on understanding this
    public static boolean binarySearch(int x) {
        int[] powersOfTwo = {1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,
                            65536,131072,262144,524288,1048576,2097152,4194304,8388608,
                            16777216,33554432,67108864,134217728,268435456,536870912,
                            1073741824}; 
        int interval = 16;
        int exponent = interval; /* Start out at midpoint */ 
        boolean isAPowerOfTwo = false;
        switch (x) {
            case 0:
	            isAPowerOfTwo = false;
                break;
            case 1: /* Special case makes binary search easier */
	            isAPowerOfTwo = true;
	            break;
            default:
                while (x != powersOfTwo[exponent] && interval > 1) {
                    if (x < powersOfTwo[exponent])
                        exponent -= interval/2;
                    else
                        exponent += interval/2;
                        interval /= 2;
               }
        isAPowerOfTwo = (x == powersOfTwo[exponent]);
        }
    return (isAPowerOfTwo);
    }
    
    public static boolean linearSearch(int n) {
        int[] powersOfTwo = { 1, 2, 4, 8, 16, 32, 64, 128, 256, 512,1024,2048,4096, 8192, 16384, 32768, 65536, 131072, 262144, 524288, 1048576, 2097152, 4194304, 8388608,16777216, 33554432, 67108864, 134217728, 268435456, 536870912, 1073741824};
        for(int i =0; i < powersOfTwo.length; i++){
            if(powersOfTwo[i] == n) return true;
        }
        return false;
    }
    
    public static boolean divideByTwo(int n){
        while(n % 2 == 0 && n > 0){
            n = n/2;
        }
        return n ==1;
    }
     public static boolean checkAll(int x){
         return (x == 1 || x == 2 || x == 4 || x == 8 || x == 16 || x == 32 ||
            x == 64 || x == 128 || x == 256 || x == 512 || x == 1024 ||
            x == 2048 || x == 4096 || x == 8192 || x == 16384 ||
            x == 32768 || x == 65536 || x == 131072 || x == 262144 ||
            x == 524288 || x == 1048576 || x == 2097152 ||
            x == 4194304 || x == 8388608 || x == 16777216 ||
            x == 33554432 || x == 67108864 || x == 134217728 ||
            x == 268435456 || x == 536870912 || x == 1073741824);
     }
     
     public static boolean checkNextPower(int n) {
         int powerOfTwo = 1;
         int max = (int)Math.pow(2,30);
         //while(n > powerOfTwo && powerofTwo < 2147483648){
         while(n > powerOfTwo && powerOfTwo < max){
             powerOfTwo *= 2;
         }
         return powerOfTwo == n;
     }
    
}
