package cn_solution

fun totalNumbers(digits: IntArray): Int {
    val set = HashSet<Int>()
    for (i in digits.indices)
        if (digits[i] != 0)
            for (j in digits.indices)
                if (j != i)
                    for (k in digits.indices)
                        if (k != i && k != j && digits[k] % 2 == 0)
                            set.add(100 * digits[i] + 10 * digits[j] + digits[k])
    return set.size
}