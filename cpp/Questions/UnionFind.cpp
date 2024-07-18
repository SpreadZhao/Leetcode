#include "UnionFind.h"

UnionFind::UnionFind(int n) {
    parent.resize(n);
    for (int i = 0; i < n; i++) {
        parent[i] = i;
    }
}

void UnionFind::unionSet(int index1, int index2) {
    parent[find(index2)] = find(index1);
}

int UnionFind::find(int index) {
    if (parent[index] != index) {
        parent[index] = find(parent[index]);
    }
    return parent[index];
}