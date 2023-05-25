package exercise

class ShortestPath {

    val threshold = 10e7

    fun floyd(link: Array<IntArray>) {
        for (k in link.indices) {
            for (i in link.indices) {
                for (j in link.indices) {
                    if (link[i][k] == Int.MAX_VALUE || link[k][j] == Int.MAX_VALUE) continue
                    if (link[i][j] > link[i][k] + link[k][j]) {
                        link[i][j] = link[i][k] + link[k][j]
                    }
                }
            }
        }
    }

    inner class Edge(val start: Int, val end: Int, val weight: Int)

    fun shortestPath(link: Array<IntArray>) {
        val edges = generateEdges(link)
        val res = IntArray(link.size) { Int.MAX_VALUE }
        val predecessor = IntArray(link.size) { -1 }
        res[0] = 0 // z is the source
        for (i in 1 until link.size) {
            var changed = false
            for (j in edges.indices) {
                if (res[edges[j].start] == Int.MAX_VALUE) continue
                if (res[edges[j].end] > res[edges[j].start] + edges[j].weight) {
                    res[edges[j].end] = res[edges[j].start] + edges[j].weight
                    predecessor[edges[j].end] = edges[j].start
                    changed = true
                }
            }
            print("res: "); res.forEach { print("${ if (it == Int.MAX_VALUE) "I" else it } ") }
            println()
            print("predecessor: "); predecessor.forEach { print("$it ") }
            println()
            if (!changed) return
        }
        for (i in edges.indices) {
            if (res[edges[i].end] > res[edges[i].start] + edges[i].weight && res[edges[i].start] != Int.MAX_VALUE) {
                println("Negative ring")
            }
        }
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