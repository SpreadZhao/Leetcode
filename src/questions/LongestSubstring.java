package questions;

import javax.xml.stream.events.Characters;
import java.util.*;

/**
 * Link: <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/description/">Longest Substring Without Repeated Characters</a>
 */
public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if(s.equals("")) return 0;
        Set<Character> chs = new HashSet<>();
        List<Integer> lens = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(!chs.contains(ch)){
                chs.add(ch);
            }else{
                lens.add(chs.size());
                i -= chs.size();
                chs.clear();
            }
        }
        if(lens.isEmpty() || !chs.isEmpty()){ // Any else branch in for loop is not executed
            lens.add(chs.size());
        }
        Collections.sort(lens);
        return lens.get(lens.size() - 1);
    }
}
