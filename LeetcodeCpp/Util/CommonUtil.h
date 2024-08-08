//
// Created by SpreadZhao on 2024/8/4.
//

#ifndef LEETCODECPP_COMMONUTIL_H
#define LEETCODECPP_COMMONUTIL_H

#include "../common.h"

class CommonUtil {
public:
    class DFSResponse {
    public:
        int islandNum = 0;
    };
    static bool isEven(int n);
    static DFSResponse dfs(int n, const vector<vector<int>>& edges);
};



#endif //LEETCODECPP_COMMONUTIL_H
