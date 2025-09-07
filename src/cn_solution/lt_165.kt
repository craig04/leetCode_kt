package cn_solution

fun compareVersion(version1: String, version2: String): Int {
    fun String.version() = split('.').map { it.toInt() }
    val v1 = version1.version()
    val v2 = version2.version()
    for (i in 0 until maxOf(v1.size, v2.size)) {
        val a1 = v1.getOrElse(i) { 0 }
        val a2 = v2.getOrElse(i) { 0 }
        if (a1 != a2)
            return a1.compareTo(a2)
    }
    return 0
}