package cn_solution

fun maximumTime(time: String): String {
    val c = time.toCharArray()
    if (c[0] == '?')
        c[0] = if (c[1] == '?' || c[1] < '4') '2' else '1'
    if (c[1] == '?')
        c[1] = if (c[0] == '2') '3' else '9'
    if (c[3] == '?')
        c[3] = '5'
    if (c[4] == '?')
        c[4] = '9'
    return String(c)
}