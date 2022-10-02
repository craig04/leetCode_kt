package cn_solution

fun reformatNumber(number: String): String {
    return buildString {
        var count = 0
        for (c in number) {
            if (c.isDigit()) {
                append(c)
                if (++count == 3) {
                    count = 0
                    append('-')
                }
            }
        }
        if (count == 0 && isNotEmpty()) {
            setLength(length - 1)
        } else if (count == 1 && length > 1) {
            val p = lastIndex - 1
            val temp = get(p)
            set(p, get(p - 1))
            set(p - 1, temp)
        }
    }
}
