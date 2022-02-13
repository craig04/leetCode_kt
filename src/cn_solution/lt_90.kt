package cn_solution

fun subsetsWithDup(nums: IntArray): List<List<Int>> {
    return ArrayList<List<Int>>().apply {
        subsets(nums.sortedArray(), 0, ArrayList(), this)
    }
}

private fun subsets(nums: IntArray, cur: Int, temp: MutableList<Int>, result: ArrayList<List<Int>>) {
    result.add(ArrayList(temp))
    for (i in cur until nums.size) {
        if (i == cur || nums[i] != nums[i - 1]) {
            temp.add(nums[i])
            subsets(nums, i + 1, temp, result)
            temp.removeAt(temp.lastIndex)
        }
    }
}