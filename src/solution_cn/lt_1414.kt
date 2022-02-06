package solution_cn

fun findMinFibonacciNumbers(k: Int): Int {
    val fibs = arrayListOf(1)
    var a = 1
    var b = 1
    while (k - b >= a) {
        val c = a + b
        a = b
        b = c
        fibs.add(c)
    }
    var result = 0
    var remain = k
    for (i in fibs.indices.reversed()) {
        if (remain >= fibs[i]) {
            remain -= fibs[i]
            result++
        }
        if (remain == 0) break
    }
    return result
}