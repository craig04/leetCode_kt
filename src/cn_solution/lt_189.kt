package cn_solution

fun rotate(nums: IntArray, k: Int): Unit {
    fun IntArray.rev(from: Int, to: Int = size) {
        var l = from
        var r = to - 1
        while (l < r) {
            val value = this[l]
            this[l++] = this[r]
            this[r--] = value
        }
    }

    val t = k % nums.size
    nums.rev(0, nums.size - t)
    nums.rev(nums.size - t)
    nums.rev(0)
}