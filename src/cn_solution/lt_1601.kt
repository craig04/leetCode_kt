package cn_solution

fun maximumRequests(n: Int, requests: Array<IntArray>): Int {
    var result = 0
    val move = IntArray(n)
    for (mask in 0 until 1.shl(requests.size)) {
        val bits = Integer.bitCount(mask)
        if (bits <= result) {
            continue
        }
        move.fill(0)
        var temp = 0
        var m = mask
        while (m != 0) {
            val t = Integer.numberOfTrailingZeros(m)
            m = m.and(m - 1)
            when (--move[requests[t][0]]) {
                0 -> temp--
                -1 -> temp++
            }
            when (++move[requests[t][1]]) {
                0 -> temp--
                1 -> temp++
            }
        }
        if (temp == 0) {
            result = maxOf(result, Integer.bitCount(mask))
        }
    }
    return result
}