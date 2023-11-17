package cn_solution

fun getPermutation(n: Int, k: Int): String {
    val a = CharArray(n)
    fun calc(n: Int, idx: Int) {
        if (n == 1) {
            a[0] = '1'
            return
        }
        val sub = (1 until n).reduce { a, b -> a * b }
        val t = idx / sub
        a[n - 1] = '1' + t
        calc(n - 1, idx - t * sub)
        for (i in 0 until n - 1)
            if (a[i] >= a[n - 1])
                a[i]++
    }
    calc(n, k - 1)
    a.reverse()
    return String(a)
}