#include "common.h"
class UnionFind {
public:
    vector<int> parent;
    UnionFind(int n);
    void unionSet(int index1, int index2);
    int find(int index); 
};

