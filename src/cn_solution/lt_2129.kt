package cn_solution

fun capitalizeTitle(title: String): String {
    val n = title.length
    val ca = title.toCharArray()
    ca.forEachIndexed { i, c ->
        if (c == ' ')
            return@forEachIndexed
        ca[i] = if (i != 0 && ca[i - 1] != ' ' || i > n - 3 || ca[i + 1] == ' ' || ca[i + 2] == ' ')
            c.lowercaseChar()
        else
            c.uppercaseChar()
    }
    return String(ca)
}