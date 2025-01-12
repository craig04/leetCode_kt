package cn_solution

fun largestVariance(s: String): Int {
    return ('a'..'z').maxOf { a ->
        ('a'..'z').maxOf loop@{ b ->
            if (a == b)
                return@loop 0
            var x = 0
            var y = Int.MIN_VALUE
            s.maxOf { c ->
                if (c == a) {
                    x = maxOf(x, 0) + 1
                    y++
                } else if (c == b) {
                    x = maxOf(x, 0) - 1
                    y = x
                }
                y
            }
        }
    }
}