package cn_solution

import java.util.*

fun medianSlidingWindow(nums: IntArray, k: Int): DoubleArray {

    class LazyHeap(comparator: Comparator<Int>) {
        private val q = PriorityQueue<Int>(comparator)
        private val map = HashMap<Int, Int>()
        var size = 0
            private set

        fun poll(): Int {
            applyRemove()
            size--
            return q.poll()
        }

        fun peek(): Int {
            applyRemove()
            return q.peek()
        }

        operator fun plusAssign(x: Int) {
            q += x
            size++
        }

        operator fun minusAssign(x: Int) {
            map.merge(x, 1, Int::plus)
            size--
        }

        private fun applyRemove() {
            while (map.getOrDefault(q.peek(), 0) != 0)
                map.merge(q.poll(), -1, Int::plus)
        }
    }

    val ans = ArrayList<Double>()
    val left = LazyHeap(reverseOrder())
    val right = LazyHeap(naturalOrder())
    for (i in nums.indices) {
        val x = nums[i]
        if (left.size == 0 || x <= left.peek())
            left += x
        else
            right += x
        when (left.size - right.size) {
            2 -> right += left.poll()
            -1 -> left += right.poll()
        }
        if (i < k - 1)
            continue
        var res = left.peek() + 0.0
        if (k % 2 == 0)
            res = (res + right.peek()) / 2
        ans += res
        val y = nums[i - k + 1]
        if (y <= left.peek()) {
            left -= y
            if (left.size < right.size)
                left += right.poll()
        } else {
            right -= y
            if (left.size - right.size == 2)
                right += left.poll()
        }
    }
    return ans.toDoubleArray()
}