package cn_solution

fun threeSumMulti(arr: IntArray, target: Int): Int {
    val max = minOf(arr.max(), target)
    val pre = IntArray(max + 1)
    val suf = IntArray(max + 1)
    val a = ArrayList<Int>()
    for (x in arr)
        if (x <= max) {
            suf[x]++
            a += x
        }
    var ans = 0L
    for (x in a) {
        suf[x]--
        val l = maxOf(0, target - x - max)
        val r = minOf(max, target - x)
        for (i in l..r)
            ans += pre[i] * suf[target - x - i]
        pre[x]++
    }
    return ans.mod(1000000007)
}