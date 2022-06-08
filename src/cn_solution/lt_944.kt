package cn_solution

fun minDeletionSize(strs: Array<String>): Int {
    return strs.first().indices.count { j ->
        (1 until strs.size).any { i ->
            strs[i][j] < strs[i - 1][j]
        }
    }
}