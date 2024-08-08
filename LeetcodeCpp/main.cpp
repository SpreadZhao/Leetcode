#include <iostream>
#include "Questions/Solution.h"

Solution solution;

void AddBinary() {
    string a = "101";
    string b = "10101";
    string str = Solution::addBinary(a, b);
    cout << "str: " << str;
}

void AccountsMerge() {
    vector<vector<string>> vec = {
            {"John", "johnsmith@mail.com", "john_newyork@mail.com"},
            {"John", "johnsmith@mail.com", "john00@mail.com"},
            {"Mary", "mary@mail.com"},
            {"John", "johnnybravo@mail.com"}
    };
    vector<vector<string>> res = Solution::accountsMerge(vec);
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

void BoatsToSavePeople() {
    vector<int> people =  {3, 5, 3, 4};
    int limit = 5;
    cout << Solution::numRescueBoats(people, limit);
}

void CanPlaceFlowers() {
    vector<int> flowerbed = {1,0,0,0,1};
    int n = 1;
    cout << Solution::canPlaceFlowers2(flowerbed, n);
}

void MakeConnected() {
    int n = 4;
    vector<vector<int>> connections = {
        {0, 1},
        {0, 2},
        {1, 2}
    };
    cout << Solution::makeConnected(n, connections);
}

int main() {
    // AddBinary();
//    AccountsMerge();
//    BoatsToSavePeople();
    // CanPlaceFlowers();
    MakeConnected();
    return 0;
}