package cn_interview

class StackOfPlates(private val cap: Int) {

    private val data = ArrayList<ArrayList<Int>>()

    fun push(`val`: Int) {
        if (cap == 0)
            return
        var last = data.lastOrNull()
        if (last == null || last.size == cap) {
            last = ArrayList()
            data.add(last)
        }
        last.add(`val`)
    }

    fun pop(): Int {
        return popAt(data.lastIndex)
    }

    fun popAt(index: Int): Int {
        if (cap == 0 || index !in data.indices)
            return -1
        val list = data[index]
        val result = list.removeAt(list.lastIndex)
        if (list.isEmpty()) {
            data.removeAt(index)
        }
        return result
    }
}