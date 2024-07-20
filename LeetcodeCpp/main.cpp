#include <iostream>
#include "Questions/Solution.h"

Solution solution;

void AddBinary() {
    string a = "101";
    string b = "10101";
    string str = solution.addBinary(a, b);
    cout << "str: " << str;
}

void AccountsMerge() {
    vector<vector<string>> vec = {
            {"John", "johnsmith@mail.com", "john_newyork@mail.com"},
            {"John", "johnsmith@mail.com", "john00@mail.com"},
            {"Mary", "mary@mail.com"},
            {"John", "johnnybravo@mail.com"}
    };
    vector<vector<string>> res = solution.accountsMerge(vec);
    for (const auto& row : res) {
        for (int i = 0; i < row.size(); i++) {
            if (i == 0) {
                cout << row[i] << ": ";
            } else {
                cout << row[i] << ", ";
            }
        }
        cout << endl;
    }
}

int main() {
    // AddBinary();
    AccountsMerge();
    return 0;
}