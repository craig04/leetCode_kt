package cn_solution

fun reversePairs(nums: IntArray): Int {
    val set = nums.mapTo(java.util.TreeSet()) { it + 0L }
    val map = HashMap<Long, Int>()
    set.forEachIndexed { i, num -> map[num] = i + 1 }
    val a = IntArray(set.size + 1)
    fun query(x: Int): Int {
        var res = 0
        var t = x
        while (t > 0) {
            res += a[t]
            t = t and (t - 1)
        }
        return res
    }

    fun update(x: Int) {
        var t = x
        while (t < a.size) {
            a[t]++
            t += t and -t
        }
    }

    var ans = 0
    nums.forEachIndexed { i, num ->
        val x = map.getOrDefault(set.floor(num * 2L) ?: Long.MIN_VALUE, 0)
        ans += i - query(x)
        update(map[num + 0L] ?: 0)
    }
    return ans
}