package cn_offer

fun minNumber(nums: IntArray): String {
    return nums.map { it.toString() }
        .sortedWith(object : Comparator<String> {
            override fun compare(l: String, r: String): Int {
                for (i in 0 until l.length + r.length) {
                    val a = if (i >= l.length) r[i - l.length] else l[i]
                    val b = if (i >= r.length) l[i - r.length] else r[i]
                    if (a != b)
                        return a - b
                }
                return 0
            }
        }).joinToString("")
}