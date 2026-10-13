package cn_solution

fun sumCounts(nums: IntArray): Int {
    val modulo = 1000000007
    val n = nums.size
    val d = LongArray(n + 2)
    val s = LongArray(n + 2)

    fun query(x: Int): Long {
        var res = 0L
        var y = x
        while (y != 0) {
            res += (x + 1) * d[y] - s[y]
            y = y and y - 1
        }
        return res % modulo
    }

    fun update(x: Int, t: Int) {
        var y = x
        while (y <= n) {
            d[y] = (d[y] + t) % modulo
            s[y] = (s[y] + x * t) % modulo
            y += y and -y
        }
    }

    val map = HashMap<Int, Int>()
    var sum = 0L
    var ans = 0L
    for (r in 1..n) {
        val x = nums[r - 1]
        val l = map.put(x, r) ?: 0
        sum += r - l
        if (l + 1 != r)
            sum += 2 * (query(r - 1) - query(l))
        sum %= modulo
        ans += sum
        update(l + 1, 1)
        update(r + 1, -1)
    }
    return ans.mod(modulo)
}