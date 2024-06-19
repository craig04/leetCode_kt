package cn_solution

fun countDistinctIntegers(nums: IntArray): Int {
    val set = HashSet<Int>()
    for (num in nums) {
        set.add(num)
        var tmp = num
        var rev = 0
        while (tmp != 0) {
            rev = rev * 10 + tmp % 10
            tmp /= 10
        }
        set.add(rev)
    }
    return set.size
}