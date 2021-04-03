package solution_cn

fun clumsy(N: Int): Int {
    return when {
        N == 1 -> 1
        N == 2 -> 2
        N == 3 -> 6
        N == 4 -> 7
        N % 4 == 0 -> N + 1
        N % 4 == 3 -> N - 1
        else -> N + 2
    }
}