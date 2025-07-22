package cn_solution

fun totalFruit(fruits: IntArray): Int {
    val cnt = IntArray(fruits.size)
    var cls = 0
    var i = 0
    return fruits.indices.maxOf { j ->
        if (++cnt[fruits[j]] == 1)
            ++cls
        while (cls > 2)
            if (--cnt[fruits[i++]] == 0)
                --cls
        j - i + 1
    }
}