package cn_solution

fun lastVisitedIntegers(nums: IntArray): List<Int> {
    val ans = ArrayList<Int>()
    val seen = ArrayList<Int>()
    var cnt = 0
    for (num in nums) {
        if (num != -1) {
            seen.add(num)
            cnt = 0
        } else if (++cnt <= seen.size)
            ans.add(seen[seen.size - cnt])
        else
            ans.add(-1)
    }
    return ans
}