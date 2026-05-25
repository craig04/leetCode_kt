package cn_solution

fun largestInteger(num: Int): Int {
    val d = Array(2) { ArrayList<Int>() }
    var x = num
    do {
        val t = x % 10
        d[t and 1].add(t)
        x /= 10
    } while (x != 0)
    d[0].sortDescending()
    d[1].sortDescending()
    x = num
    var ans = 0
    var pow = 1
    do {
        var t = x % 10
        t = d[t and 1].removeLast()
        ans += pow * t
        pow *= 10
        x /= 10
    } while (x != 0)
    return ans
}