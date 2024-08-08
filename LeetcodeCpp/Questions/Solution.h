//
// Created by SpreadZhao on 2024/7/21.
//

#ifndef LEETCODECPP_SOLUTION_H
#define LEETCODECPP_SOLUTION_H
#include "../common.h"

class Solution {
public:
    static string addBinary(string a, string b);
    // https://leetcode.cn/problems/accounts-merge/description/
    static vector<vector<string>> accountsMerge(vector<vector<string>>& accounts);
    // https://leetcode.cn/problems/boats-to-save-people/description/
    static int numRescueBoats(vector<int>& people, int limit);
    // https://leetcode.cn/problems/can-place-flowers/description/
    static bool canPlaceFlowers(vector<int> &flowerbed, int n);
    static bool canPlaceFlowers2(vector<int> &flowerbed, int n);
    // https://leetcode.cn/problems/number-of-operations-to-make-network-connected/description/
    static int makeConnected(int n, vector<vector<int>> &connections);
};

#endif //LEETCODECPP_SOLUTION_H
