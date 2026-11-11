package cn_solution

class ProductOfNumbers() {

    private val pre = arrayListOf(1)

    fun add(num: Int) {
        if (num == 0) {
            pre.clear()
            pre += 1
        } else {
            pre += pre.last() * num
        }
    }

    fun getProduct(k: Int): Int {
        if (k >= pre.size)
            return 0
        return pre.last() / pre[pre.lastIndex - k]
    }
}