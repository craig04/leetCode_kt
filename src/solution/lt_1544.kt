package solution

fun makeGood(s: String): String {
    return buildString {
        s.forEach { c ->
            if (lastOrNull()?.let { c.toLowerCase() == it.toLowerCase() && c != it } == true) {
                setLength(length - 1)
            } else {
                append(c)
            }
        }
    }
}