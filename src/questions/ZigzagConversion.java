package questions;

/**
 * Link: <a href="https://leetcode.com/problems/zigzag-conversion/">Zigzag Conversion</a>
 */
public class ZigzagConversion {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        StringBuilder bu = new StringBuilder();
        for(int i = 0; i < numRows; i++){
            boolean isSlant = false;
            boolean repeat = false;
            int j = i;
            int span;
            while(checkBoundary(s, j)){
                if(!repeat) bu.append(s.charAt(j));
                if(isSlant){
                    span = calSpan(i + 1);
                    repeat = span == 0;
                    j += span;
                    isSlant = false;
                }else{
                    span = calSpan(numRows - i);
                    repeat = span == 0;
                    j += span;
                    isSlant = true;
                }
            }
        }
        return bu.toString();
    }

    public int calSpan(int row){
        return 2 * row - 2;
    }

    public boolean checkBoundary(String s, int index){
        return index >= 0 && index < s.length();
    }
}
