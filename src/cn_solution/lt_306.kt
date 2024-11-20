package cn_solution

fun isAdditiveNumber(num: String): Boolean {
    val len = (num.length - 1) / 2
    for (i in 1..len) {
        if (num[0] == '0' && i != 1)
            break
        val x = num.substring(0, i)
        for (j in 1..len) {
            if (num[i] == '0' && j != 1)
                break
            val y = num.substring(i, i + j)
            var a = x.toLong()
            var b = y.toLong()
            var k = i + j
            while (k < num.length) {
                val c = a + b
                val z = c.toString()
                if (!num.startsWith(z, k))
                    break
                a = b
                b = c
                k += z.length
            }
            if (k == num.length)
                return true
        }
    }
    return false
}