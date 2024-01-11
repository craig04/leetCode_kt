package cn_solution

class FreqStack() {

    private val stack = arrayListOf(ArrayList<Int>())
    private val freq = HashMap<Int, Int>()

    fun push(`val`: Int) {
        val f = (freq.remove(`val`) ?: 0) + 1
        freq[`val`] = f
        if (stack.size <= f)
            stack.add(ArrayList())
        stack[f].add(`val`)
    }

    fun pop(): Int {
        val list = stack.last()
        val `val` = list.removeLast()
        if (list.isEmpty())
            stack.removeLast()
        freq[`val`] = freq[`val`]!! - 1
        return `val`
    }
}