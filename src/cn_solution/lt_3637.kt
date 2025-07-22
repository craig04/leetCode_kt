package cn_solution

fun isTrionic(nums: IntArray): Boolean {
    val n = nums.size
    var i = 0
    fun jump(expect: Int): Boolean {
        var j = i + 1
        while (j != n && nums[j - 1].compareTo(nums[j]) == expect)
            j++
        val len = j - i
        i = j - 1
        return len >= 2
    }
    return jump(-1) && jump(1) && jump(-1) && i == n - 1
}