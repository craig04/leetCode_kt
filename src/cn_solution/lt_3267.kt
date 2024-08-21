package cn_solution

fun countPairs(nums: IntArray): Int {
    val s = Array(nums.size) {
        var num = nums[it]
        CharArray(7) {
            val digit = '0' + num % 10
            num /= 10
            digit
        }
    }
    var ans = 0
    val pos = IntArray(4)
    val x = CharArray(4)
    val y = CharArray(4)
    for (i in nums.indices)
        loop@ for (j in i + 1 until nums.size) {
            val a = s[i]
            val b = s[j]
            var size = 0
            for (k in a.indices)
                if (a[k] != b[k]) {
                    if (size == 4)
                        continue@loop
                    x[size] = a[k]
                    y[size] = b[k]
                    pos[size++] = k
                }
            if (size != 0) {
                x.sort(toIndex = size)
                y.sort(toIndex = size)
            }
            for (k in 0 until size)
                if (x[k] != y[k])
                    continue@loop
            if (size <= 3) {
                ans++
                continue@loop
            }
            for (t in 1..3) {
                if (a[pos[0]] == b[pos[t]] && a[pos[t]] == b[pos[0]]) {
                    ans++
                    continue@loop
                }
            }
        }
    return ans
}