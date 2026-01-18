package cn_solution

fun maxXor(nums: IntArray, k: Int): Int {
    class Node {
        val next = Array<Node?>(2) { null }
        var leaf = 0
    }

    val root = Node()
    val maxBits = 14
    fun insert(x: Int) {
        var node = root
        for (i in maxBits downTo 0) {
            val bit = x shr i and 1
            val next = node.next[bit] ?: Node()
            node.next[bit] = next
            node = next
            node.leaf++
        }
    }

    fun remove(x: Int) {
        var node = root
        for (i in maxBits downTo 0) {
            val bit = x shr i and 1
            val next = node.next[bit] ?: break
            node = next
            node.leaf--
        }
    }

    fun query(x: Int): Int {
        var node = root
        var res = 0
        for (i in maxBits downTo 0) {
            var bit = x shr i and 1
            if ((node.next[bit xor 1]?.leaf ?: 0) != 0) {
                res = 1 shl i or res
                bit = 1 xor bit
            }
            node = node.next[bit] ?: break
        }
        return res
    }

    val min = ArrayDeque<Int>()
    val max = ArrayDeque<Int>()
    val pre = IntArray(nums.size + 1)
    var i = 0
    var ans = 0
    for (j in nums.indices) {
        insert(pre[j])
        while (min.isNotEmpty() && nums[j] <= nums[min.last()])
            min.removeLast()
        min.addLast(j)
        while (max.isNotEmpty() && nums[j] >= nums[max.last()])
            max.removeLast()
        max.addLast(j)

        while (nums[max.first()] - nums[min.first()] > k) {
            if (i == min.first())
                min.removeFirst()
            if (i == max.first())
                max.removeFirst()
            remove(pre[i++])
        }
        pre[j + 1] = pre[j] xor nums[j]
        ans = maxOf(ans, query(pre[j + 1]))
    }
    return ans
}