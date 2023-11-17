package cn_solution

fun canMakeArithmeticProgression(arr: IntArray): Boolean {
    arr.sort()
    val d = arr[1] - arr[0]
    return (2 until arr.size).all { arr[it] - arr[it - 1] == d }
}