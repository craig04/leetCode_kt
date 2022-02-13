package cn_solution

fun maximizeXor(nums: IntArray, queries: Array<IntArray>): IntArray {

    class Node {
        var least = Int.MAX_VALUE
        val child = Array<Node?>(2) { null }
        fun updateLeast(m: Int) {
            least = least.coerceAtMost(m)
        }
    }

    val root = Node()
    val high = Integer.highestOneBit(maxOf(
            nums.fold(0) { acc, i -> maxOf(acc, i) },
            queries.fold(0) { acc, q -> maxOf(acc, q[0]) }))
    nums.forEach {
        var temp = high
        var node = root
        node.updateLeast(it)
        while (temp != 0) {
            val c = if (it and temp == 0) 0 else 1
            val next = node.child[c] ?: Node()
            node.child[c] = next
            temp = temp shr 1
            node = next
            node.updateLeast(it)
        }
    }
    return IntArray(queries.size) {
        val x = queries[it][0]
        val m = queries[it][1]
        if (root.least > m) {
            return@IntArray -1
        }
        var node = root
        var temp = high
        var result = 0
        while (temp != 0) {
            var c = if (temp and x != 0) 0 else 1
            if (node.child[c]?.run { least <= m } == true) {
                result = result or temp
            } else {
                c = c xor 1
            }
            node = node.child[c] ?: return@IntArray -1
            temp = temp shr 1
        }
        result
    }
}