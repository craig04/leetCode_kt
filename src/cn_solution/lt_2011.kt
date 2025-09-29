package cn_solution

fun finalValueAfterOperations(operations: Array<String>): Int {
    return operations.fold(0) { x, s -> x + if (s[1] == '-') -1 else 1 }
}
