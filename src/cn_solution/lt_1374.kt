package cn_solution

fun generateTheString(n: Int): String {
    return buildString {
        repeat(n) { append('a') }
        if (n % 2 == 0) set(lastIndex, 'b')
    }
}
