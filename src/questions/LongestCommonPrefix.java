package questions;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder builder = new StringBuilder();
        int j = 0;
        while (j != strs[0].length()) {
            char base = strs[0].charAt(j);
            for (int i = 1; i < strs.length; i++) {
                if (j == strs[i].length() || strs[i].charAt(j) != base) {
                    return builder.toString();
                }
            }
            j++;
            builder.append(base);
        }
        return builder.toString();
    }
}
