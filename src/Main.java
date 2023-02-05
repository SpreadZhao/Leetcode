import test.Test;

public class Main {
    public static void main(String[] args) {
//        Test.romanInteger("MCMXCIV");
//        Test.longestCommonPrefix();
        long stime = System.currentTimeMillis();
//        Test.sum();
//        Test.addTwoNumbers();
//        Test.longestSubstring();
        Test.longestPalindromicSubstring();
        long etime = System.currentTimeMillis();






        System.out.println("time: " + (etime - stime));
    }
}