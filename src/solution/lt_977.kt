package solution

fun sortedSquares(A: IntArray): IntArray {

    var right = A.indexOfFirst { it > 0 }.let { if (it == -1) A.size else it }
    var left = right - 1
    val result = ArrayList<Int>()
    while (left != -1 || right != A.size) {
        result.add(
            if (left == -1 || (right != A.size && -A[left] >= A[right]))
                A[right++].pow() else A[left--].pow()
        )
    }
    return result.toIntArray()
}

private fun Int.pow() = this * this