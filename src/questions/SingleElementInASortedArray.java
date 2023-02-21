package questions;

/**
 * Link: <a href="https://leetcode.com/problems/single-element-in-a-sorted-array/">Single Element In A Sorted Array</a>
 * <p>
 * Question: Why sorted?
 * <p>
 * Better Solution: <a href="https://leetcode.com/problems/single-element-in-a-sorted-array/solutions/3212178/day-52-binary-search-easiest-beginner-friendly-sol/">Day 52 || Binary Search || Easiest Beginner Friendly Sol</a>
 */
public class SingleElementInASortedArray {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length == 1) return nums[0];
        int i = 0;
        while(i < nums.length){
            if(i == nums.length - 1) return nums[i];
            if(nums[i] == nums[i + 1]) i += 2;
            else return nums[i];
        }
        return -1;
    }
}
