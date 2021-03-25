package solution_cn

fun isUnique(astr: String): Boolean {
    return HashSet<Char>().run { astr.all { add(it) } }
}