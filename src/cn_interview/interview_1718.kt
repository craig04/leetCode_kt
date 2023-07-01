package cn_interview

fun shortestSeq(big: IntArray, small: IntArray): IntArray {
    val map = HashMap<Int, Int>()
    small.forEach { map[it] = (map[it] ?: 0) + 1 }
    var count = map.size
    var l = 0
    var left = 0
    var right = Int.MAX_VALUE
    for (r in big.indices) {
        var cnt = (map[big[r]] ?: 0) - 1
        map[big[r]] = cnt
        if (cnt == 0) {
            count--
        }
        while (count == 0) {
            cnt = map[big[l]] ?: 0
            if (cnt >= 0)
                break
            map[big[l++]] = cnt + 1
        }
        if (count == 0 && r - l < right - left) {
            left = l
            right = r
        }
    }
    return if (right == Int.MAX_VALUE) IntArray(0) else intArrayOf(left, right)
}