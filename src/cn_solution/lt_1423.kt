package cn_solution

private fun maxScore(cardPoints: IntArray, k: Int): Int {
    val left = IntArray(k + 1)
    val right = IntArray(k + 1)
    for (i in 0 until k) {
        left[i + 1] = left[i] + cardPoints[i]
        right[i + 1] = right[i] + cardPoints[cardPoints.lastIndex - i]
    }
    return left.indices.maxOf { left[it] + right[k - it] }
}