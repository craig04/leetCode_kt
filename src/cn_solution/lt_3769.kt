package cn_solution

fun sortByReflection(nums: IntArray): IntArray {
    val n = nums.size
    val revs = IntArray(n) {
        var num = nums[it]
        var rev = 0
        while (num != 0) {
            rev = rev * 2 + num % 2
            num /= 2
        }
        rev
    }
    val idx = Array(n) { it }
    idx.sortWith(compareBy({ revs[it] }, { nums[it] }))
    return IntArray(n) { nums[idx[it]] }
}