#include <ext/pb_ds/assoc_container.hpp>

using namespace std;
using namespace __gnu_pbds;
using tree_set = tree<int, null_type, std::less<>, rb_tree_tag, tree_order_statistics_node_update>;

class Solution {
public:
    vector<int> kthSmallest(vector<int> &par, vector<int> &vals, vector<vector<int>> &queries) {
        auto n = par.size();
        vector<vector<int>> g(n);
        for (auto i = 1; i < n; i++)
            g[par[i]].emplace_back(i);

        vector<vector<pair<int, int>>> q(n);
        for (auto i = 0; i < queries.size(); i++) {
            auto &v = queries[i];
            q[v[0]].emplace_back(v[1], i);
        }

        vector<int> ans(queries.size());
        auto dfs = [&](this auto &&dfs, int u, int x) -> tree_set * {
            auto y = x ^ vals[u];
            auto res = new tree_set();
            res->insert(y);
            for (auto v: g[u]) {
                auto sub = dfs(v, y);
                if (sub->size() > res->size())
                    swap(res, sub);
                for (auto it = sub->begin(); it != sub->end(); ++it)
                    res->insert(*it);
                delete sub;
            }
            for (auto [k, i]: q[u]) {
                auto it = res->find_by_order(k - 1);
                ans[i] = it == res->end() ? -1 : *it;
            }
            return res;
        };
        delete dfs(0, 0);
        return ans;
    }
};