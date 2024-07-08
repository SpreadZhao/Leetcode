#include "Questions/Solution.h"

void AddBinary() {
    Solution s;
    string a = "101";
    string b = "10101";
    string str = s.addBinary(a, b);
    cout << "str: " << str;
}

int main() {
    AddBinary();
    return 0;
}