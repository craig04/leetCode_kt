package cn_solution

fun reorderedPowerOf2(n: Int): Boolean {
    fun Int.sortedHash(): Int {
        val list = ArrayList<Int>()
        var temp = this
        do {
            list.add(temp % 10)
            temp /= 10
        } while (temp != 0)
        return list.apply { sort() }.hashCode()
    }

    val set = (0..30).mapTo(HashSet()) { 1.shl(it).sortedHash() }
    return n.sortedHash() in set
}