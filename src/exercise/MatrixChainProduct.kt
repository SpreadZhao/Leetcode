package exercise

import kotlin.math.min

class MatrixChainProduct {
    fun minCount(p: IntArray, i: Int, j: Int):Int {
        if(i == j) return 0
        var min = Int.MAX_VALUE
        for(k in i until j){
            val count = minCount(p, i, k) + minCount(p, k + 1, j) + p[i - 1] * p[k] * p[j]
            if(count < min) min = count
        }
        return min
    }

    fun minCount2(p: IntArray): Int {
        val i = 1
        val n = p.size
        val j = n - 1
        val dp = Array(n){IntArray(n){-1}}
        return dpCore(p, i, j, dp)
    }

    private fun dpCore(p: IntArray, i: Int, j: Int, dp: Array<IntArray>): Int {
        if(i == j) return 0
        if(dp[i][j] != -1) return dp[i][j]
        dp[i][j] = Int.MAX_VALUE
        for(k in i until j){
            dp[i][j] = min(dp[i][j], dpCore(p, i, k, dp) + dpCore(p, k + 1, j, dp) + p[i - 1] * p[k] * p[j])
        }
        return dp[i][j]
    }
}