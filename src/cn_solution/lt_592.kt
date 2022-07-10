package cn_solution

fun fractionAddition(expression: String): String {
    fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
    fun lcm(a: Int, b: Int): Int = a * b / gcd(a, b)
    val ca = expression.toCharArray()
    val len = expression.length
    var i = 0
    var resNum = 0
    var resDen = 1
    while (i != len) {
        var a = 1
        var num = 0
        var den = 0
        val c = ca[i]
        if (c == '+' || c == '-') {
            a = if (c == '+') 1 else -1
            i++
        }
        while (ca[i] != '/')
            num = num * 10 + (ca[i++] - '0')
        i++
        while (i != len && ca[i] != '-' && ca[i] != '+')
            den = den * 10 + (ca[i++] - '0')
        var temp = lcm(den, resDen)
        resNum = temp / resDen * resNum + temp / den * num * a
        resDen = temp
        if (resNum == 0) {
            resDen = 1
        } else {
            temp = gcd(Math.abs(resNum), resDen)
            resNum /= temp
            resDen /= temp
        }
    }
    return "$resNum/$resDen"
}