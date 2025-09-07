package cn_solution

import java.util.*

fun totalBeauty(nums: IntArray): Int {
    val modulo = 1000000007
    val max = nums.max()
    val groups = Array(max + 1) { ArrayList<Int>() }
    for (num in nums) {
        var i = 1
        while (i * i < num) {
            if (num % i == 0) {
                groups[i].add(num)
                groups[num / i].add(num)
            }
            i++
        }
        if (i * i == num)
            groups[i].add(num)
    }
    var ans = 0
    val a = IntArray(max + 1)
    val seq = IntArray(max + 1)
    for (i in max downTo 1) {
        var cnt = 0
        val set = groups[i].mapTo(TreeSet()) { it }
        val map = set.associateWith { ++cnt }
        a.fill(0, 0, cnt + 1)
        fun update(x: Int, t: Int) {
            var y = x
            while (y <= cnt) {
                a[y] = (a[y] + t) % modulo
                y += y and -y
            }
        }

        fun query(x: Int): Int {
            var y = x
            var ans = 0
            while (y > 0) {
                ans = (ans + a[y]) % modulo
                y = y and y - 1
            }
            return ans
        }
        for (num in groups[i]) {
            val x = map[num] ?: 0
            update(x, 1 + query(x - 1))
        }
        seq[i] = query(cnt)

        for (j in i * 2..max step i)
            seq[i] = (seq[i] - seq[j] + modulo) % modulo
        ans = (ans + 1L * seq[i] * i).mod(modulo)
    }
    return ans
}