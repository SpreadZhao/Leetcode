package questions;

/**
 * Link: <a href="https://leetcode.com/problems/longest-palindromic-substring/">Longest Palindromic Substring</a>
 * <p>
 * My record is so poor!!!
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        String res = s.substring(0, 1);
        for(int i = 0; i < s.length(); i++){
            for(int len = 1 ; len <= s.length() - i; len++){
                if(s.charAt(i) == s.charAt(i + len - 1)){ // Time cost , speed up a lot!!!
                    if(len > res.length()){
                        if (isPalindromic(s, i, i + len)) {
                            res = s.substring(i, i + len);
                        }
                    }
                }
            }
        }
        return res;
    }

    public boolean isPalindromic(String s, int start, int end){
        String sub = s.substring(start, end);
        StringBuilder pal = new StringBuilder();
        for(int i = end - 1; i >= start; i--){
            pal.append(s.charAt(i));
        }
        return sub.equals(pal.toString());
    }
}
