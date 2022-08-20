package cn_solution

fun solveEquation(equation: String): String {
    val eq = equation.indexOf('=')
    val op = charArrayOf('+', '-')
    fun parse(str: String): IntArray {
        val result = IntArray(2)
        var index = 0
        do {
            var next = str.indexOfAny(op, index + 1)
            if (next == -1)
                next = str.length
            val isX = if (str[next - 1] == 'x') 1 else 0
            val split = next - isX
            val temp = when (index) {
                split -> 1
                split - 1 -> when (str[index]) {
                    '+' -> 1
                    '-' -> -1
                    else -> str[index] - '0'
                }
                else -> str.substring(index, split).toInt()
            }
            result[isX] += temp
            index = next
        } while (index != str.length)
        return result
    }

    val left = parse(equation.substring(0, eq))
    val right = parse(equation.substring(eq + 1))
    left[0] -= right[0]
    left[1] -= right[1]
    return when {
        left[1] != 0 -> "x=${-left[0] / left[1]}"
        left[0] == 0 -> "Infinite solutions"
        else -> "No solution"
    }
}