package questions;

import java.util.Arrays;

/**
 * Link: <a href="https://leetcode.com/problems/search-insert-position/">Search Insert Position</a>
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int mid = nums.length / 2;
        if(nums.length == 0) return 0;
        else if(nums[mid] == target) return mid;
//        else if(nums.length == 1 && nums[mid] > target) return 0;
//        else if(nums.length == 1 && nums[mid] < target) return 1;
        else if(nums[mid] > target){
            int[] left = Arrays.copyOfRange(nums, 0, mid);
            mid = searchInsert(left, target);
        }else{
            int[] right = Arrays.copyOfRange(nums, mid + 1, nums.length);
            mid = mid + searchInsert(right, target) + 1;
        }
        return mid;
    }
}
