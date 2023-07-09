package cn_solution

fun removeStars(s: String): String {
    return buildString {
        for (c in s) {
            if (c == '*')
                setLength(length - 1)
            else
                append(c)
        }
    }
}