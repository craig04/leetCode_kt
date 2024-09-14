package cn_solution

fun removeDuplicates(s: String): String {
    val a = ArrayList<Char>()
    for (c in s) {
        if (a.lastOrNull() == c)
            a.removeLast()
        else
            a.add(c)
    }
    return a.joinToString("")
}