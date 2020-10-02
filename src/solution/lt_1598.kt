package solution

fun minOperations(logs: Array<String>): Int {
    return logs.fold(0) { depth, log ->
        when (log) {
            "./" -> depth
            "../" -> maxOf(depth - 1, 0)
            else -> depth + 1
        }
    }
}