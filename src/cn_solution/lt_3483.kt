package cn_solution

fun totalNumbers_combinatorics(digits: IntArray): Int {
    val cnt = IntArray(10)
    var types = 0
    var positive = 0
    var singlePositive = 0
    for (d in digits)
        if (++cnt[d] == 1) {
            types++
            if (d != 0) {
                positive++
                singlePositive++
            }
        } else if (d != 0 && cnt[d] == 2)
            singlePositive--
    return (0..9 step 2).sumOf { i ->
        if (cnt[i] == 0)
            return@sumOf 0
        var t = types
        var p = positive
        var s = singlePositive
        if (cnt[i] == 1) {
            t--
            if (i != 0) {
                p--
                s--
            }
        } else if (i != 0 && cnt[i] == 2)
            s++
        t * p - s
    }
}

fun totalNumbers_enumeration(digits: IntArray): Int {
    val set = HashSet<Int>()
    for (i in digits.indices)
        if (digits[i] != 0)
            for (j in digits.indices)
                if (j != i)
                    for (k in digits.indices)
                        if (k != i && k != j && digits[k] % 2 == 0)
                            set += 100 * digits[i] + 10 * digits[j] + digits[k]
    return set.size
}