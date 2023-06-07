package cn_solution

fun maxSumDivThree(nums: IntArray): Int {
    var cur = IntArray(3) { Int.MIN_VALUE }
    var next = IntArray(3)
    cur[0] = 0
    for (n in nums) {
        cur.copyInto(next)
        val r = n % 3
        for (i in 0 until 3) {
            next[(i + r) % 3] = maxOf(next[(i + r) % 3], cur[i] + n)
        }
        val tmp = cur
        cur = next
        next = tmp
    }
    return cur[0]
}