package com.leetcode.easy;

public class SingleNumber {
    public int singleNumber(int[] nums) {
    // brute force - time:O(n^2) ; space = O(1)
//   if(nums.length >2){
//       for(int i = 0; i < nums.length; i++){
//           int j = 0;
//           while (j < nums.length){
//               if(nums[i] == nums[j] && i !=j){
//                   break;
//               }
//               j++;
//           }
//           if(j == nums.length){
//             return nums[i];
//           }
//       }
//   }
//   return nums[0];
// }

// Hash map - time:O(n) ; space = O(n)

// Map<Integer, Integer> map = new HashMap<Integer,Integer> (); 
//         if(nums.length > 2){
//             for(int i=0; i < nums.length; i++){
//                 if(map.get(nums[i]) == null){
//                     map.put(nums[i],1);
//                 } else {
//                     map.remove(nums[i]);
//                     //int c = map.get(nums[i])+1;
//                     //map.put(nums[i], c);
//                 }
//             }
//             for(Integer i: map.keySet()){
//                 return i;
//             }
//         }
//         return nums[0];
        // bit manipulation time:O(n) ; space = O(1)
        int res = nums[0];
        for(int i = 1; i < nums.length; i++){
            res = res ^ nums[i];
        }
        return res;
    }
}
