package cn_solution

fun minimumAbsDifference(arr: IntArray): List<List<Int>> {
    arr.sort()
    val diff = (1 until arr.size).fold(Int.MAX_VALUE) { diff, i ->
        minOf(diff, arr[i] - arr[i - 1])
    }
    return (1 until arr.size)
        .filter { arr[it] - arr[it - 1] == diff }
        .map { listOf(arr[it - 1], arr[it]) }
}