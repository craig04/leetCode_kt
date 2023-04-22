package cn_solution

import kotlin.math.abs

fun compareVersion(version1: String, version2: String): Int {
    fun String.version() = split('.').toMutableList()
    val v1 = version1.version()
    val v2 = version2.version()
    val shorter = if (v1.size < v2.size) v1 else v2
    repeat(abs(v2.size - v1.size)) { shorter.add("0") }
    for (i in v1.indices) {
        val c = v1[i].toInt().compareTo(v2[i].toInt())
        if (c != 0) {
            return c
        }
    }
    return 0
}