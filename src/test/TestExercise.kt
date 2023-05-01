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
        println(MaxSum().maxSum(arr))
    }

    fun fractionalKS() {
        val arr = arrayOf(
            KnapSack.ItemValue(60, 10),
            KnapSack.ItemValue(100, 20),
            KnapSack.ItemValue(120, 30)
        )
        val capacity = 50
        println(KnapSack().getMaxValue(arr, capacity))
    }

    fun zeroOneKS() {
        val profit = intArrayOf(60, 1000, 120)
        val weight = intArrayOf(30, 30, 30)
        val w = 50
        println(KnapSack().zeroOneKnap3(w, weight, profit, profit.size))
    }

    fun schedule() {
        val time = intArrayOf(15, 8, 3, 10)
        println(Schedule().minAverageCompletion(time))
    }

    fun shortest() {
        val I = Int.MAX_VALUE
        val edges = arrayOf(
                intArrayOf(0, -1, 3, I, I),
                intArrayOf(I, 0, 3, 2, 2),
                intArrayOf(I, I, 0, I, I),
                intArrayOf(I, 1, 5, 0, I),
                intArrayOf(I, I, I, -3, 0)
        )
        ShortestPath().shortestPath(edges).forEach { num -> print("$num ") }
        println()
    }
}