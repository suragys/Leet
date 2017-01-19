/*
Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.

Note:
The given integer is guaranteed to fit within the range of a 32-bit signed integer.
You could assume no leading zero bit in the integer’s binary representation.
Example 1:
Input: 5
Output: 2
Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
Example 2:
Input: 1
Output: 0
Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
*/

public class Solution {
    public int findComplement(int num) {
        // int comp = 0;
        // int i = 0;
        // while(num != 0){
        //     int bit = num & 1;
        //     num = num >>> 1;
        //     if(bit == 0){
        //         comp = comp | (1 << i);
        //     }
        //     i++;
        // }
        // return comp;
        
        // return ~num & ((Integer.highestOneBit(num) << 1) - 1);
        
        int mask = num;
    mask |= mask >> 1;
    mask |= mask >> 2;
    mask |= mask >> 4;
    mask |= mask >> 8;
    mask |= mask >> 16;
    return num ^ mask;
    }
}
