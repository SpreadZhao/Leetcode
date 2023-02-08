package questions;

/**
 * Link: <a href="https://leetcode.com/problems/reverse-integer/">Reverse Integer</a>
 */
public class ReverseInteger {
    public int reverse(int x) {
        String xstr = String.valueOf(Math.abs(x));
        //System.out.println(xstr);
        int i = 0, j = xstr.length() - 1;
        char[] xchs = new char[xstr.length()];
        while(i <= j){
            xchs[i] = xstr.charAt(j);
            xchs[j] = xstr.charAt(i);
            i++;
            j--;
        }
        int res;
        try{
            res = Integer.parseInt(String.valueOf(xchs));
        }catch (NumberFormatException e){
            res = 0;
        }
        if(x < 0) res = -res;
        return res;
    }
}
