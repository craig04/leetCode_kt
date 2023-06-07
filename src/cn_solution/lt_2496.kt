package cn_solution

fun maximumValue(strs: Array<String>): Int {
    return strs.fold(0) { result, s ->
        var num = 0
        for (c in s) {
            if (!c.isDigit())
                return@fold maxOf(result, s.length)
            num = c - '0' + num * 10
        }
        maxOf(result, num)
    }
}