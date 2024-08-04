//
// Created by SpreadZhao on 2024/7/21.
//
#include "Solution.h"
#include "../Util/UnionFind.h"
#include "../Util/CommonUtil.h"

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
    for (int re : res) {
        ss << re;
    }
    return ss.str();
}

vector<vector<string>> Solution::accountsMerge(vector<vector<string>>& accounts) {
    map<string, int> emailToIndex;
    map<string, string> emailToName;
    int emailsCount = 0;
    for (auto& account : accounts) {
        string& name = account[0];
        int size = account.size();
        for (int i = 1; i < size; i++) {
            string& email = account[i];
            if (!emailToIndex.count(email)) {
                emailToIndex[email] = emailsCount++;
                emailToName[email] = name;
            }
        }
    }
    UnionFind uf(emailsCount);
    for (auto& account : accounts) {
        string& firstEmail = account[1];
        int firstIndex = emailToIndex[firstEmail];
        int size = account.size();
        for (int i = 2; i < size; i++) {
            string& nextEmail = account[i];
            int nextIndex = emailToIndex[nextEmail];
            uf.unionSet(firstIndex, nextIndex);
        }
    }
    map<int, vector<string>> indexToEmails;
    for (auto& [email, _] : emailToIndex) {
        int index = uf.find(emailToIndex[email]);
        vector<string>& account = indexToEmails[index];
        account.emplace_back(email);
        indexToEmails[index] = account;
    }
    vector<vector<string>> merged;
    for (auto& [_, emails] : indexToEmails) {
        sort(emails.begin(), emails.end());
        string& name = emailToName[emails[0]];
        vector<string> account;
        account.emplace_back(name);
        for (auto& email : emails) {
            account.emplace_back(email);
        }
        merged.emplace_back(account);
    }
    return merged;
}

int Solution::numRescueBoats(vector<int> &people, int limit) {
    int i = 0, j = people.size() - 1;
    std::sort(people.begin(), people.end());
    int numOfBoats = 0;
    while (i <= j) {
        if (i == j) {
            numOfBoats++;
            break;
        }
        int heavy = people.at(j);
        int light = people.at(i);
        if (heavy + light <= limit) {
            i++;
            j--;
        } else {
            j--;
        }
        numOfBoats++;
    }
    return numOfBoats;
}

int findNext1(vector<int> &flowerbed, int start) {
    for (int i = start + 1; i < flowerbed.size(); ++i) {
        int flower = flowerbed.at(i);
        if (flower == 1) {
            return i;
        }
    }
    return -1;
}

bool Solution::canPlaceFlowers(vector<int> &flowerbed, int n) {
    int zeroCount = 0, lastIndexOf1 = 0, indexOf1 = 0, flowerCount = 0;
    // Find first 1
    int first1Index = findNext1(flowerbed, -1);
    if (first1Index >= 0) {
        zeroCount = first1Index;
        if (isEven(zeroCount)) {
            flowerCount += zeroCount / 2;
        } else {
            flowerCount += (zeroCount - 1) / 2;
        }
        indexOf1 = first1Index;
        lastIndexOf1 = first1Index;
        while ((indexOf1 = findNext1(flowerbed, indexOf1)) >= 0) {
            zeroCount = indexOf1 - lastIndexOf1 - 1;
            if (isEven(zeroCount)) {
                flowerCount += zeroCount / 2 - 1;
            } else {
                flowerCount += (zeroCount + 1) / 2 - 1;
            }
            lastIndexOf1 = indexOf1;
        }
        if (lastIndexOf1 < flowerbed.size() - 1) {
            zeroCount = flowerbed.size() - lastIndexOf1 - 1;
            if (isEven(zeroCount)) {
                flowerCount += zeroCount / 2;
            } else {
                flowerCount += (zeroCount - 1) / 2;
            }
        }
    } else {
        zeroCount = flowerbed.size();
        if (isEven(zeroCount)) {
            flowerCount += zeroCount / 2;
        } else {
            flowerCount += (zeroCount + 1) / 2;
        }
    }
    return flowerCount >= n;
}

int findNext12(vector<int> &flowerbed, int start) {
    for (int i = start + 1; i < flowerbed.size(); ++i) {
        int flower = flowerbed.at(i);
        if (flower == 1) {
            return i;
        }
    }
    return flowerbed.size();
}

bool Solution::canPlaceFlowers2(vector<int> &flowerbed, int n) {
    int i = -1, j = -1, flowerCount = 0;
    // https://stackoverflow.com/questions/16250058/why-is-1-a-size-false-even-though-stdvectors-size-is-positive
    while (i == -1 || i < flowerbed.size()) {
        j = findNext12(flowerbed, i);
        int zeroCount = j - i - 1;
        if (i == -1) zeroCount++;
        if (j == flowerbed.size()) zeroCount++;
        flowerCount += zeroCount == 0 ? 0 : (zeroCount + 1) / 2 - 1;
        i = j;
    }
    return flowerCount >= n;
}
