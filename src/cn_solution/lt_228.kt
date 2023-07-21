package cn_solution

fun summaryRanges(nums: IntArray): List<String> {
    val result = ArrayList<String>()
    var i = 0
    while (i != nums.size) {
        var j = i + 1
        while (j != nums.size && nums[j] == nums[j - 1] + 1)
            j++
        result.add(
            if (j == i + 1)
                "${nums[i]}"
            else
                "${nums[i]}->${nums[j - 1]}"
        )
        i = j
    }
    return result
}