package solution_cn

class MinStack() {

    private val all = ArrayList<Int>()
    private val min = ArrayList<Int>()

    fun push(x: Int) {
        all.add(x)
        if (min.isEmpty() || x <= min.last()) {
            min.add(x)
        }
    }

    fun pop() {
        val x = all.removeAt(all.lastIndex)
        if (x == min.last()) {
            min.removeAt(min.lastIndex)
        }
    }

    fun top(): Int {
        return all.last()
    }

    fun min(): Int {
        return min.last()
    }
}