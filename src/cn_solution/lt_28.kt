package cn_solution

/**
 * KMP 算法
 */
fun strStr_KMP(haystack: String, needle: String): Int {
    val len = needle.length
    if (haystack.length < len)
        return -1
    val next = IntArray(len)
    var k = 0
    for (i in 1 until len) {
        val c = needle[i]
        while (k != 0 && needle[k] != c)
            k = next[k - 1]
        if (needle[k] == c)
            k++
        next[i] = k
    }
    var j = 0
    haystack.forEachIndexed { i, c ->
        while (j != 0 && c != needle[j])
            j = next[j - 1]
        if (c == needle[j] && ++j == len)
            return i - len + 1
    }
    return -1
}

/**
 * RK 算法
 */
fun strStr_RK(haystack: String, needle: String): Int {
    val len = needle.length
    if (haystack.length < len)
        return -1
    var base = 1
    var hash1 = 0
    var hash2 = 0
    for (i in needle.indices) {
        base *= 31
        hash1 = haystack[i] - 'a' + 31 * hash1
        hash2 = needle[i] - 'a' + 31 * hash2
    }
    if (hash1 == hash2)
        return 0
    for (i in len until haystack.length) {
        hash1 = haystack[i] - 'a' + 31 * hash1 - (haystack[i - len] - 'a') * base
        // 实际上，hash1 == hash2 时，还要再比较一下两串字符是否相等，避免哈希冲突
        // 但是，leetcode 上的样例不用加判断也可以过
        if (hash1 == hash2)
            return i - len + 1
    }
    return -1
}