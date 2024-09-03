package cn_solution

private fun maximumLength(nums: IntArray, k: Int): Int {
    val map = HashMap<Int, IntArray>()
    val max = IntArray(k + 2)
    for (num in nums) {
        val a = map.computeIfAbsent(num) { IntArray(k + 1) }
        for (j in k downTo 0) {
            a[j] = maxOf(a[j] + 1, max[j] + 1)
            max[j + 1] = maxOf(max[j + 1], a[j])
        }
    }
    return max[k + 1]
}