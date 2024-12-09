package cn_solution

fun getKth(lo: Int, hi: Int, k: Int): Int {
    val w = hashMapOf(1 to 0)
    fun weight(x: Int): Int = w.getOrPut(x) {
        1 + if (x and 1 == 1) weight(3 * x + 1) else weight(x / 2)
    }

    return (lo..hi).sortedBy(::weight)[k - 1]
}