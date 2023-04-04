package questions

/**
 * Link: [Optimal Partition of String](https://leetcode.com/problems/optimal-partition-of-string/)
 */
class OptimalPartitionOfString {

//    inner class TrieNode{
//        private val children: HashMap<Char, TrieNode> = HashMap()
//        private var isTerminal = false
//        fun addNode(ch: Char){
//            val curr = this
//            while(!curr.children.containsKey(ch)){
//
//            }
//        }
//    }

    fun partitionString(s: String): Int {
        val sub = ArrayList<HashMap<Char, Int>>()
        for(ch in s){
            var needNew = true
            for(per_map in sub){
                if(!per_map.containsKey(ch)){
                    needNew = false
                    per_map[ch] = 0
                }
            }
            if(needNew){
                sub.add(HashMap())
                sub.last()[ch] = 0
            }
        }
        return sub.size
    }

    fun partitionString2(s: String): Int {
        val lastSeen = IntArray(26)
        lastSeen.fill(-1)
        var count = 1; var substringStart = 0
        for(i in s.indices){
            if(lastSeen[s[i] - 'a'] >= substringStart){
                count++
                substringStart = i
            }
            lastSeen[s[i] - 'a'] = i
        }
        return count
    }

    fun partitionString3(s: String): Int {
        var count = 1; var merge = 0
        for(ch in s){
            val index = ch - 'a'
            if((merge and (1 shl index)) != 0){
                count++
                merge = 0
            }
            merge = merge or (1 shl index)
        }
        return count
    }

    private fun listContain(sub: List<Map<Char, Int>>, ch: Char): Int {
        for(i in sub.indices){
            if(sub[i].containsKey(ch)) return i
        }
        return -1
    }
}