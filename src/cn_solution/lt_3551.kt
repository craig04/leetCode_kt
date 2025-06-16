package cn_solution

private fun minSwaps(nums: IntArray): Int {
    val n = nums.size
    val sums = IntArray(n) {
        var num = nums[it]
        var sum = 0
        while (num > 0) {
            sum += num % 10
            num /= 10
        }
        sum
    }
    val sort = Array(n) { it }
    sort.sortWith(compareBy({ sums[it] }, { nums[it] }))
    val vis = BooleanArray(n)
    var cycle = 0
    for (i in 0 until n) {
        if (vis[i])
            continue
        cycle++
        var j = i
        do {
            vis[j] = true
            j = sort[j]
        } while (j != i)
    }
    return n - cycle
}