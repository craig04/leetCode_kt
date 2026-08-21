package cn_solution

fun findDisappearedNumbers(nums: IntArray, lower: Int, upper: Int): List<List<Int>> {
    val a = nums.filterTo(ArrayList()) { it in lower..upper }
    a += lower - 1
    a += upper + 1
    a.sort()
    val ans = ArrayList<List<Int>>()
    for (i in 1 until a.size)
        if (a[i] - a[i - 1] > 1)
            ans += listOf(a[i - 1] + 1, a[i] - 1)
    return ans
}