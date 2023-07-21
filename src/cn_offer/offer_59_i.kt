package cn_offer

import java.util.*
import kotlin.math.sign

/**
 * Solution using priority queue
 */
fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
    val len = nums.size
    val q = PriorityQueue<Int> { l, r -> (nums[r] - nums[l]).sign }
    (0 until k - 1).forEach { q.add(it) }
    return IntArray(len - k + 1) {
        q.add(it + k - 1)
        while (q.peek() < it)
            q.poll()
        nums[q.peek()]
    }
}

/**
 * Solution using monotonic queue
 */
fun maxSlidingWindow_2(nums: IntArray, k: Int): IntArray {
    val len = nums.size
    var front = 0
    var rear = 0
    val q = IntArray(len)
    for (i in 0 until k - 1) {
        while (rear != 0 && nums[i] >= nums[q[rear - 1]])
            rear--
        q[rear++] = i
    }
    return IntArray(len - k + 1) {
        val i = it + k - 1
        while (front != rear && nums[i] >= nums[q[rear - 1]])
            rear--
        q[rear++] = i
        while (front != rear && q[front] < it)
            front++
        nums[q[front]]
    }
}