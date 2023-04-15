package test

import exercise.*

object TestExercise {
    fun testGraph() {
        val n = 6
        val edges = arrayOf(intArrayOf(1, 1, 0, 0, 0, 1), intArrayOf(1, 1, 1, 0, 1, 0), intArrayOf(0, 1, 1, 1, 0, 0), intArrayOf(0, 0, 1, 1, 1, 0), intArrayOf(0, 1, 0, 1, 1, 0), intArrayOf(1, 0, 0, 0, 0, 1))
        val graph = MatrixGraph(n, GraphType.UDG, edges)
        MatrixGraph.DFS(graph, 0)
    }

    fun matrixChainProduct() {
        val arr = intArrayOf(40, 20, 30, 10, 30)
        println(MatrixChainProduct().minCount(arr, 1, arr.size - 1))
    }

    fun longestCommonSubsequence() {
        val s1 = "AGGTAB"
        val s2 = "GXTXAYB"
        println(LongestCommonSubsequence().longestCommonSubsequence4(s1, s2))
    }

    fun longestCommonSubstring() {
        val x = "abcdxyz"
        val y = "xyzabcd"
        println(LongestCommonSubstring().lcs(x, y, x.length, y.length))
    }

    fun maxSum() {
        val arr = intArrayOf(-2, 11, -4, 13, -5, -2)
        val arr2 = intArrayOf(1)
        println(MaxSum().maxSum(arr2))
    }
}