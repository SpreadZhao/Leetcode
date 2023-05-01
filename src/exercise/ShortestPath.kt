package exercise

class ShortestPath {

    inner class Edge(val start: Int, val end: Int, val weight: Int)

    fun shortestPath(link: Array<IntArray>): IntArray {
        val edges = generateEdges(link)
        val res = IntArray(link.size) { Int.MAX_VALUE }
        res[0] = 0
        for (i in 1 until link.size) {
            var changed = false
            for (j in edges.indices) {
                if (res[edges[j].start] == Int.MAX_VALUE) continue
                if (res[edges[j].end] > res[edges[j].start] + edges[j].weight) {
                    res[edges[j].end] = res[edges[j].start] + edges[j].weight
                    changed = true
                }
            }
            if (!changed) return res
        }
        for (i in edges.indices) {
            if (res[edges[i].end] > res[edges[i].start] + edges[i].weight && res[edges[i].start] != Int.MAX_VALUE) {
                println("Negative ring")
            }
        }
        return res
    }

    private fun generateEdges(link: Array<IntArray>): ArrayList<Edge> {
        val edges = ArrayList<Edge>()
        for (i in link.indices) {
            for (j in link.indices) {
                if (link[i][j] != Int.MAX_VALUE) {
                    edges.add(Edge(i, j, link[i][j]))
                }
            }
        }
        return edges
    }
}