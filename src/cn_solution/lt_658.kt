package cn_solution

fun findClosestElements(arr: IntArray, k: Int, x: Int): List<Int> {
    var l = 0
    var r = arr.size
    while (l != r) {
        val m = (l + r) / 2
        when {
            x >= arr[m] -> l = m + 1
            x < arr[m] -> r = m
        }
    }
    var left = l - 1
    var right = r
    while (right - left - 1 != k) {
        when {
            right == arr.size -> left--
            left == -1 -> right++
            x - arr[left] <= arr[right] - x -> left--
            else -> right++
        }
    }
    return arr.asList().subList(left + 1, right)
}