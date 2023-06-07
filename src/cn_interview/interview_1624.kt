package cn_interview

fun pairSums(nums: IntArray, target: Int): List<List<Int>> {
    val map = HashMap<Int, Int>()
    val result = ArrayList<List<Int>>()
    for (n in nums) {
        val diff = target - n
        val cnt = map[diff] ?: 0
        if (cnt != 0) {
            result.add(listOf(n, diff))
            if (cnt == 1)
                map.remove(diff)
            else
                map[diff] = cnt - 1
        } else {
            map[n] = (map[n] ?: 0) + 1
        }
    }
    return result
}