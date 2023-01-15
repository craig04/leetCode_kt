import java.util.*
import kotlin.collections.ArrayDeque

class MKAverage(val m: Int, val k: Int) {

    class MultiSet {

        var size = 0
        var sum = 0L
        val map = TreeMap<Int, Int>()

        fun first() = map.firstKey()
        fun last() = map.lastKey()
        fun removeFirst() = first().also { remove(it) }
        fun removeLast() = last().also { remove(it) }

        fun add(num: Int) {
            map[num] = (map[num] ?: 0) + 1
            size++
            sum += num
        }

        fun remove(num: Int): Boolean {
            val count = map[num] ?: return false
            size--
            sum -= num
            if (count == 1) map.remove(num)
            else map[num] = count - 1
            return true
        }
    }

    val max = MultiSet()
    val min = MultiSet()
    val mid = MultiSet()
    val list = ArrayDeque<Int>()

    fun addElement(num: Int) {
        list.addLast(num)
        if (list.size < m) {
            mid.add(num)
            return
        }
        if (list.size == m) {
            mid.add(num)
            while (min.size < k)
                min.add(mid.removeFirst())
            while (max.size < k)
                max.add(mid.removeLast())
            return
        }
        val unused = list.removeFirst()
        if (max.remove(unused)) {
            max.add(mid.removeLast())
        } else if (min.remove(unused)) {
            min.add(mid.removeFirst())
        } else {
            mid.remove(unused)
        }
        if (num >= max.first()) {
            max.add(num)
            mid.add(max.removeFirst())
        } else if (num <= min.last()) {
            min.add(num)
            mid.add(min.removeLast())
        } else {
            mid.add(num)
        }
    }

    fun calculateMKAverage(): Int {
        return if (list.size >= m) (mid.sum / mid.size).toInt() else -1
    }
}