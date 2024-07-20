//
// Created by SpreadZhao on 2024/7/21.
//
#include "Solution.h"
#include "../Util/UnionFind.h"

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
