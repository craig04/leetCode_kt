package solution

fun canBeEqual(target: IntArray, arr: IntArray): Boolean {
    val count = IntArray(1001)
    target.forEach { count[it]++ }
    return arr.all { --count[it] >= 0 }
}