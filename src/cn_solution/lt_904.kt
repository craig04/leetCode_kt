package cn_solution

fun totalFruit(fruits: IntArray): Int {
    val count = IntArray(fruits.size + 1)
    var cls = 0
    var i = 0
    var result = 0
    for (j in fruits.indices) {
        val fj = fruits[j]
        if (++count[fj] == 1)
            cls++
        while (cls > 2) {
            val fi = fruits[i++]
            if (--count[fi] == 0)
                cls--
        }
        result = maxOf(result, j - i + 1)
    }
    return result
}
