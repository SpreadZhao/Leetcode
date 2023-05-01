package exercise

class ShortestPath {
    fun shortestPath(edges: Array<IntArray>, N: Int, M: Int): IntArray {
        val res = IntArray(N) {Int.MAX_VALUE}
        res[1] = 0
        for (i in 1 until N) {
            var find = false
            for (j in 1 .. M) {
                if (res[])
            }
            if (find) break
        }
        return res
    }
}