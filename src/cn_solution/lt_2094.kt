package cn_solution

fun findEvenNumbers(digits: IntArray): IntArray {
    val cnt = IntArray(10)
    for (d in digits)
        cnt[d]++
    return (100..999 step 2).filter {
        var res = true
        var t = it
        while (t != 0) {
            res = res and (--cnt[t % 10] >= 0)
            t /= 10
        }
        t = it
        while (t != 0) {
            cnt[t % 10]++
            t /= 10
        }
        res
    }.toIntArray()
}