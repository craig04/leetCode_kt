package cn_solution

fun finalValueAfterOperations(operations: Array<String>): Int {
    return operations.fold(0) { x, s ->
        if (s[1] == '-') x - 1 else x + 1
    }
}
