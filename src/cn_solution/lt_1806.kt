package cn_solution

// TODO 搞懂解法
fun reinitializePermutation(n: Int): Int {
    if (n == 2)
        return 1
    var step = 1
    var mod = 2
    while (mod != 1) {
        mod = (mod * 2) % (n - 1)
        step++
    }
    return step
}
