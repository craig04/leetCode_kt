package cn_solution

import kotlin.math.pow

fun countDistinct(n: Long): Long {
    val s = n.toString()
    var pow = 9.0.pow(s.length).toLong()
    var ans = (pow - 9) / 8
    for (i in s.indices) {
        if (s[i] == '0')
            break
        pow /= 9
        ans += (s[i] - '1') * pow
        if (i == s.lastIndex)
            ans++
    }
    return ans
}