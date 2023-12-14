package cn_solution

fun longestPrefix(s: String): String {
    val base = 31L
    var time = 1L
    val module = 1000000007L
    var prefix = 0L
    var suffix = 0L
    var i = 0
    var j = s.lastIndex
    var end = 0
    while (j > 0) {
        prefix = ((s[i++] - 'a') + prefix * base) % module
        suffix = ((s[j--] - 'a') * time + suffix) % module
        time = (time * base) % module
        if (prefix == suffix)
            end = i
    }
    return s.substring(0, end)
}