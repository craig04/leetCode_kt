package solution

fun smallerNumbersThanCurrent(nums: IntArray): IntArray {
    val result = HashMap<Int, Int>()
    nums.sorted().forEachIndexed { index, i ->
        result.getOrPut(i) { index }
    }
    return IntArray(nums.size) { result[nums[it]]!! }
}