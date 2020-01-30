package solution

fun minRemoveToMakeValid(s: String): String {
    var count = 0
    val right = hashSetOf<Int>()
    left@ for (i in s.indices) {
        val c = s[i]
        when {
            c == '(' -> count++
            c != ')' -> continue@left
            count == 0 -> right.add(i)
            else -> count--
        }
    }
    count = 0
    val left = hashSetOf<Int>()
    right@ for (i in s.length - 1 downTo 0) {
        val c = s[i]
        when {
            i in right -> continue@right
            c == ')' -> count++
            c != '(' -> continue@right
            count == 0 -> left.add(i)
            else -> count--
        }
    }
    return s.filterIndexed { index, _ ->
        !left.contains(index) && !right.contains(index)
    }
}