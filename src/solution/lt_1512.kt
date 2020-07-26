package solution

fun numIdenticalPairs(nums: IntArray): Int {
    var result = 0
    val count = hashMapOf<Int, Int>()
    nums.forEach {
        val cnt = count.getOrDefault(it, 0)
        result += cnt
        count[it] = cnt + 1
    }
    return result
}