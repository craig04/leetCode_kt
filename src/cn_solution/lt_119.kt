package cn_solution

fun getRow(rowIndex: Int): List<Int> {
    val result = ArrayList<Int>()
    var num = 1L
    var a = 1
    var b = rowIndex
    for (i in 0..rowIndex) {
        result.add(num.toInt())
        num = num * b-- / a++
    }
    return result
}
