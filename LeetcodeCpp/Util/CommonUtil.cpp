//
// Created by SpreadZhao on 2024/8/4.
//
#include "CommonUtil.h"

bool CommonUtil::isEven(int n) { return n % 2 == 0; }

map<int, vector<int>> buildMapForEdges(const vector<vector<int>> &edges) {
    map<int, vector<int>> m;
    for (auto &edge : edges) {
        int a = edge[0];
        int b = edge[1];
        if (!m.count(a)) {
            m[a] = vector<int>{};
        }
        if (!m.count(b)) {
            m[b] = vector<int>{};
        }
        m[a].emplace_back(b);
        m[b].emplace_back(a);
    }
    return m;
}

void dfsCore(int start, const map<int, vector<int>>& edgesMap, bool visited[]) {
    if (visited[start]) {
        return;
    }
    visited[start] = true;
    if (!edgesMap.count(start)) {
        return;
    }
    for (const auto neighbor : edgesMap.at(start)) {
        if (!visited[neighbor]) {
            dfsCore(neighbor, edgesMap, visited);
        }
    }
}

CommonUtil::DFSResponse CommonUtil::dfs(const int n, const vector<vector<int>>& edges) {
    DFSResponse response;
    bool visited[n];
    fill_n(visited, n, false);
    const auto map = buildMapForEdges(edges);
    // dfs from 0 to n-1
    for (int i = 0; i < n; i++) {
        if (!visited[i]) {
            response.islandNum++;
            dfsCore(i, map, visited);
        }
    }
    return response;
}


