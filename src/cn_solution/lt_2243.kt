package cn_solution

fun digitSum(s: String, k: Int): String {
    var x = s
    while (x.length > k) {
        val sb = StringBuilder()
        for (i in x.indices.step(k)) {
            var sum = 0
            for (j in i until minOf(i + k, x.length))
                sum += x[j] - '0'
            sb.append(sum)
        }
        x = sb.toString()
    }
    return x
}