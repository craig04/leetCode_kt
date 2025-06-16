package cn_solution

private fun countPairs(deliciousness: IntArray): Int {
    val max = 1 shl 20
    val pow = IntArray(22) { 1 shl it }
    val cnt = IntArray(max + 1)
    var ans = 0
    for (del in deliciousness) {
        for (p in pow) {
            when {
                p < del -> continue
                p > del + max -> break
                else -> ans = (ans + cnt[p - del]) % 1000000007
            }
        }
        cnt[del]++
    }
    return ans
}