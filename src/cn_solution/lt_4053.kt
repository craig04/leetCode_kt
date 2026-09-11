package cn_solution

class Solution_4053 {

    companion object {
        val p = Array(2) { ArrayList<Int>() }

        init {
            for (i in 1..99999) {
                fun generate(pre: Int, suf: Int): Int {
                    var res = pre
                    var tmp = suf
                    while (tmp != 0) {
                        res = res * 10 + tmp % 10
                        tmp /= 10
                    }
                    return res
                }

                var x = generate(i, i / 10)
                p[x and 1] += x
                if (i <= 9999) {
                    x = generate(i, i)
                    p[x and 1] += x
                }
            }
            p[0] += 2000000002
            p[1] += 1000000001
            p.forEach { it.sort() }
        }
    }

    fun minOperations(nums: IntArray): Long {
        return nums.fold(0L) { ans, x ->
            val a = p[x and 1]
            var i = a.binarySearch(x)
            if (i < 0)
                i = i.inv()
            var s = a[i] - x
            if (i != 0)
                s = minOf(s, x - a[i - 1])
            ans + s / 2
        }
    }
}