package cn_solution

fun countTriples(n: Int): Int {
    val set = (1..n).mapTo(HashSet()) { it * it }
    var ans = 0
    for (i in 1 until n)
        for (j in 1 until i)
            if (i * i + j * j in set)
                ans++
    return ans * 2
}