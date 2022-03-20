package cn_solution

fun reverseOnlyLetters(s: String): String {
    val ca = s.toCharArray()
    var i = ca.lastIndex
    return buildString {
        for (j in ca.indices) {
            if (!Character.isLetter(ca[j])) {
                append(ca[j])
                continue
            }
            i = (i downTo 0).first { Character.isLetter(ca[i]) }
            append(ca[i--])
        }
    }
}