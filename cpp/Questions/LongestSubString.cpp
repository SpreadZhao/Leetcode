#include "LongestSubString.hpp"

LongestSubString::LongestSubString(/* args */)
{
}

LongestSubString::~LongestSubString()
{
}

int LongestSubString::lengthOfLongestSubstring(string s) {
    unordered_map<char, int> sub;
    int i = 0, j = 0, maxLen = 0;
    while (j < s.length()) {
        char ch = s[j];
        if (sub.find(ch) != sub.end()) {
            i = max(i, sub[ch]);
        }
        sub[ch] = j + 1;
        maxLen = max(maxLen, j - i + 1);
        j++;
    }
    return maxLen;
}
