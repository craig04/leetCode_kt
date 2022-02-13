package cn_interview

fun isUnique(astr: String): Boolean {
    return HashSet<Char>().run { astr.all { add(it) } }
}