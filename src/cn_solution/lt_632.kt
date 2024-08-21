package cn_solution

fun smallestRange(nums: List<List<Int>>): IntArray {
    val list = nums.indices.fold(ArrayList<IntArray>()) { res, i ->
        nums[i].mapTo(res) { intArrayOf(it, i) }
    }
    list.sortBy { it[0] }
    var low = 0
    var high = Int.MAX_VALUE
    var cnt = 0
    val freq = IntArray(nums.size)
    var i = 0
    for (j in list.indices) {
        if (++freq[list[j][1]] == 1)
            cnt++
        if (cnt != nums.size)
            continue
        while (freq[list[i][1]] > 1)
            freq[list[i++][1]]--
        if (list[j][0] - list[i][0] < high - low) {
            low = list[i][0]
            high = list[j][0]
        }
    }
    return intArrayOf(low, high)
}