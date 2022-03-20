package cn_solution

fun addStrings(num1: String, num2: String): String {
    val res = StringBuilder()
    var c = 0
    var i = num1.length
    var j = num2.length
    fun String.value(i: Int) = if (i < 0) 0 else this[i] - '0'
    while (i > 0 || j > 0 || c > 0) {
        val temp = num1.value(--i) + num2.value(--j) + c
        res.append('0' + temp % 10)
        c = temp / 10
    }
    return res.reverse().toString()
}