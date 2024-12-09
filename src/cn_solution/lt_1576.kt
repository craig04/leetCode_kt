package cn_solution

fun modifyString(s: String): String {
    val a = s.toCharArray()
    for (i in a.indices)
        if (a[i] == '?') {
            a[i] = 'a'
            while (i != 0 && a[i] == a[i - 1] || i != a.lastIndex && a[i] == a[i + 1])
                a[i]++
        }
    return String(a)
}