package questions;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Link: <a href="https://leetcode.com/problems/palindrome-number/">Palindrome Number</a>
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int i = 0, j = s.length() - 1;
        while(i < j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    // Follow up: Could you solve it without converting the integer to a string?
    public boolean isPalindrome2(int x) {
        if(x < 0) return false;
        List<Integer> nums = new LinkedList<>(); // ArrayList is a little bit faster
        while(x > 0){
            nums.add(x % 10);
            x /= 10;
        }
        int i = 0, j = nums.size() - 1;
        while(i < j){
            if(!Objects.equals(nums.get(i), nums.get(j))) return false;
            i++;
            j--;
        }
        return true;
    }


}




