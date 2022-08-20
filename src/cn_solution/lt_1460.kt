package cn_solution

fun canBeEqual(target: IntArray, arr: IntArray): Boolean {
    val count = IntArray(1001)
    target.forEach { count[it]++ }
    arr.forEach { count[it]-- }
    return count.all { it == 0 }
}