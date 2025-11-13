package solution

fun makeGood(s: String): String {
    return buildString {
        s.forEach { c ->
            if (lastOrNull()?.let { c.lowercaseChar() == it.lowercaseChar() && c != it } == true) {
                setLength(length - 1)
            } else {
                append(c)
            }
        }
    }
}