package cn_solution

fun validUtf8(data: IntArray): Boolean {
    val map = hashMapOf(7 to 1, 5 to 2, 4 to 3, 3 to 4)
    var i = 0
    while (i < data.size) {
        val zero = (7 downTo 0).firstOrNull { data[i].and(1.shl(it)) == 0 }
        val j = i + (map[zero] ?: return false)
        if (j > data.size || (i + 1 until j).any { data[it].and(0xc0) != 0x80 }) return false
        i = j
    }
    return i == data.size
}