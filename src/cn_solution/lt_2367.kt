package cn_solution

fun arithmeticTriplets(nums: IntArray, diff: Int): Int {
    val a = BooleanArray(201)
    fun check(x: Int) = x >= 0 && a[x]
    var ans = 0
    for (num in nums) {
        if (check(num - diff) && check(num - diff * 2))
            ans++
        a[num] = true
    }
    return ans
}
