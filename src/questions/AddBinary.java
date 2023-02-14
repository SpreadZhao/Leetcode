package questions;

/**
 * Link: <a href="https://leetcode.com/problems/add-binary/">Add Binary</a>
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1;
        int carry = 0;
        StringBuilder res = new StringBuilder();
        while(i >= 0 || j >= 0){
            int x, y;
            x = i < 0 ? 0 : a.charAt(i) - '0';
            y = j < 0 ? 0 : b.charAt(j) - '0';
            int num = (x + y + carry) % 2;
            if((x + y + carry) / 2 >= 1){
                carry = 1;
            }else{
                carry = 0;
            }
            res.insert(0, num);
            i--;j--;
        }
        if(carry == 1) res.insert(0, 1);
        return res.toString();
    }
}
