package cn_solution

class StockSpanner() {

    private val stack = arrayListOf(Pair(Int.MAX_VALUE, 0))
    private var index = 0

    fun next(price: Int): Int {
        while (price >= stack.last().first) {
            stack.removeAt(stack.lastIndex)
        }
        return (++index - stack.last().second).apply {
            stack.add(Pair(price, index))
        }
    }
}