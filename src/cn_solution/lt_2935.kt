package cn_solution

class Solution_2935 {

    companion object {
        const val HIGHEST_BIT = 19
    }

    fun maximumStrongPairXor(nums: IntArray): Int {
        class Node {
            val next = Array<Node?>(2) { null }
            var cnt = 0
        }

        val root = Node()
        fun insert(n: Int) {
            var node = root
            for (i in HIGHEST_BIT downTo 0) {
                val b = n shr i and 1
                val next = node.next[b] ?: Node()
                node.next[b] = next
                node = next
                node.cnt++
            }
        }

        fun delete(n: Int) {
            var node = root
            for (i in HIGHEST_BIT downTo 0) {
                node = node.next[n shr i and 1]!!
                node.cnt--
            }
        }

        fun find(n: Int): Int {
            var result = 0
            var node = root
            for (i in HIGHEST_BIT downTo 0) {
                var b = n shr i and 1
                if (node.next[b xor 1]?.run { cnt > 0 } == true) {
                    b = b xor 1
                    result = 1 shl i or result
                }
                node = node.next[b]!!
            }
            return result
        }
        nums.sort()
        var i = 0
        return nums.indices.maxOf { j ->
            insert(nums[j])
            while (nums[j] > nums[i] shl 1)
                delete(nums[i++])
            find(nums[j])
        }
    }
}