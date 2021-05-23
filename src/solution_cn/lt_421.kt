package solution_cn

fun findMaximumXOR(nums: IntArray): Int {

    class Helper {
        val next = Array<Helper?>(2) { null }
    }

    val root = Helper()
    val high = Integer.highestOneBit(nums.reduce { acc, i -> acc or i })
    fun add(n: Int) {
        var node = root
        var temp = high
        do {
            val idx = if (n and temp != 0) 1 else 0
            val next = node.next[idx] ?: Helper()
            node.next[idx] = next
            node = next
            temp = temp.shr(1)
        } while (temp != 0)
    }

    fun find(n: Int): Int {
        var node = root
        var temp = high
        var result = 0
        do {
            var idx = if (n and temp != 0) 0 else 1
            if (node.next[idx] == null) {
                idx = idx xor 1
            } else {
                result = result xor temp
            }
            node = node.next[idx]!!
            temp = temp.shr(1)
        } while (temp != 0)
        return result
    }
    return nums.fold(0) { acc, i ->
        add(i)
        maxOf(acc, find(i))
    }
}