package cn_solution

fun guess(n: Int): Int = TODO()

fun guessNumber(n: Int): Int {
    var left = 1
    var right = n
    while (left < right) {
        val mid = left + ((right - left) shr 1)
        when (guess(mid)) {
            1 -> left = mid + 1
            -1 -> right = mid - 1
            else -> return mid
        }
    }
    return left
}