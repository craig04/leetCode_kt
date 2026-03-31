package cn_solution

fun pivotArray(nums: IntArray, pivot: Int): IntArray {
    val n = nums.size
    val ans = IntArray(n)
    var l = 0
    var r = n
    for (num in nums)
        if (num < pivot)
            ans[l++] = num
        else if (num > pivot)
            ans[--r] = num
    ans.reverse(r, n)
    ans.fill(pivot, l, r)
    return ans
}