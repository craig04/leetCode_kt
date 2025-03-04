package cn_solution

private fun majorityElement(nums: IntArray): List<Int> {
    var (a, b, x, y) = intArrayOf(Int.MIN_VALUE, Int.MIN_VALUE, 0, 0)
    for (num in nums) {
        if (num == a)
            x++
        else if (num == b)
            y++
        else if (x == 0) {
            a = num
            x++
        } else if (y == 0) {
            b = num
            y++
        } else {
            x--
            y--
        }
    }
    x = 0
    y = 0
    for (num in nums) {
        when (num) {
            a -> x++
            b -> y++
        }
    }
    val ans = ArrayList<Int>()
    if (x > nums.size / 3)
        ans.add(a)
    if (y > nums.size / 3)
        ans.add(b)
    return ans
}