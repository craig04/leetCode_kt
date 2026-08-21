package cn_solution

fun reinitializePermutation(n: Int): Int {
    if (n == 2)
        return 1
    var mod = 2
    var ans = 1
    while (mod != 1) {
        mod = mod * 2 % (n - 1)
        ans++
    }
    return ans
}