#include "Questions/questions.hpp"

void lengthOfLongestSubstring();

int main() {
    lengthOfLongestSubstring();
    return 0;
}

void lengthOfLongestSubstring() {
    LongestSubString lss;
    cout << "lss: " << lss.lengthOfLongestSubstring("abcabcbb") << endl;
}