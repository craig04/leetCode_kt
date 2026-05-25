package cn_solution

fun createGrid(m: Int, n: Int): Array<String> {
    return Array(m) { i ->
        String(CharArray(n) { j ->
            if (i == 0 || j == n - 1) '.' else '#'
        })
    }
}