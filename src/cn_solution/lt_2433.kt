package cn_solution

fun findArray(pref: IntArray): IntArray {
    return IntArray(pref.size) { pref[it] xor if (it == 0) 0 else pref[it - 1] }
}