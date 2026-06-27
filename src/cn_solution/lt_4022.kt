package cn_solution

fun kthDigit(k: Long): Int {
    var t = k - 1
    var len = 1
    var cnt = 9L
    while (t >= len * cnt) {
        t -= len * cnt
        len++
        cnt *= 10
    }
    var x = t / len + cnt / 9
    if (x / 10 % 2 != 0L)
        x += 9 - x % 10 * 2
    repeat(len - 1 - t.mod(len)) { x /= 10 }
    return x.mod(10)
}