#include "Solution.h"

string Solution::addBinary(string a, string b) {
    int i = a.size() - 1;
    int j = b.size() - 1;
    int carry = 0;
    vector<int> res;
    while (i >= 0 || j >= 0) {
        int x = 0, y = 0;
        if (i >= 0) {
            x = a[i] - '0';
        }
        if (j >= 0) {
            y = b[j] - '0';
        }
        cout << "x: " << x << endl;
        cout << "y: " << y << endl;
        int num = (x + y + carry) % 2;
        if (x + y + carry > 1) {
            carry = 1;
        } else {
            carry = 0;
        }
        res.insert(res.begin(), num);
        i--;
        j--;
    }
    if (carry == 1) {
        res.insert(res.begin(), 1);
    }
    stringstream ss;
    for (int i = 0; i < res.size(); i++) {
        ss << res[i];
    }
    return ss.str();
}