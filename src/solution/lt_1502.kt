package solution

fun canMakeArithmeticProgression(arr: IntArray): Boolean {
    arr.sort()
    val diff = arr[1] - arr[0]
    return (2 until arr.size).none { arr[it] - arr[it - 1] != diff }
}