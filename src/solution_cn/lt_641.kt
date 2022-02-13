package solution_cn

class MyCircularDeque(val k: Int) {

    private val nums = IntArray(k + 1)
    private var f = 0
    private var r = 0

    fun insertFront(value: Int): Boolean {
        if (isFull()) {
            return false
        }
        f = (f + k) % (k + 1)
        nums[f] = value
        return true
    }

    fun insertLast(value: Int): Boolean {
        if (isFull()) {
            return false
        }
        nums[r] = value
        r = (r + 1) % (k + 1)
        return true
    }

    fun deleteFront(): Boolean {
        if (isEmpty()) {
            return false
        }
        f = (f + 1) % (k + 1)
        return true
    }

    fun deleteLast(): Boolean {
        if (isEmpty()) {
            return false
        }
        r = (r + k) % (k + 1)
        return true
    }

    fun getFront(): Int {
        return if (isEmpty()) -1 else nums[f]
    }

    fun getRear(): Int {
        return if (isEmpty()) -1 else nums[(r + k) % (k + 1)]
    }

    fun isEmpty(): Boolean {
        return f == r
    }

    fun isFull(): Boolean {
        return r + 1 == f || r - k == f
    }
}