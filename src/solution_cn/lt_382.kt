package solution_cn

import base.ListNode
import kotlin.random.Random

/**
 * Reservoir Sampling
 * Initial:  O(1)
 * Sampling: O(n)
 * Space:    O(1)
 */
class Solution_382_1(val head: ListNode?) {

    private val random = Random(System.currentTimeMillis())

    fun getRandom(): Int {
        var temp = head
        var i = 0
        var result = 0
        while (temp != null) {
            if (random.nextInt(++i) == 0)
                result = temp.`val`
            temp = temp.next
        }
        return result
    }
}

/**
 * Common solution
 * Initial:  O(n)
 * Sampling: O(1)
 * Space:    O(n)
 */
class Solution_382_2(head: ListNode?) {

    private val node = ArrayList<Int>()
    private val random = Random(System.currentTimeMillis())

    init {
        var temp = head
        while (temp != null) {
            node.add(temp.`val`)
            temp = temp.next
        }
    }

    fun getRandom(): Int {
        return node[random.nextInt(node.size)]
    }
}
