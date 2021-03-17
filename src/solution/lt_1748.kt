package solution

fun sumOfUnique(nums: IntArray): Int {
    val map = hashMapOf<Int, Int>()
    nums.forEach { map[it] = (map[it] ?: 0) + 1 }
    return map.entries.sumBy { if (it.value == 1) it.key else 0 }
}