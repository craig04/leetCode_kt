package cn_solution

class FrontMiddleBackQueue() {

    private val left = ArrayDeque<Int>()
    private val right = ArrayDeque<Int>()

    fun pushFront(`val`: Int) {
        shiftRight()
        left.addFirst(`val`)
    }

    fun pushMiddle(`val`: Int) {
        shiftRight()
        left.addLast(`val`)
    }

    fun pushBack(`val`: Int) {
        right.addLast(`val`)
        shiftLeft()
    }

    fun popFront(): Int {
        val result = left.removeFirstOrNull() ?: return -1
        shiftLeft()
        return result
    }

    fun popMiddle(): Int {
        val result = left.removeLastOrNull() ?: return -1
        shiftLeft()
        return result
    }

    fun popBack(): Int {
        shiftRight()
        return right.removeLastOrNull() ?: -1
    }

    private fun shiftLeft() {
        if (left.size < right.size)
            left.addLast(right.removeFirst())
    }

    private fun shiftRight() {
        if (left.size > right.size)
            right.addFirst(left.removeLast())
    }
}