package cn_solution

fun findLatestTime(s: String): String {
    val t = s.toCharArray()
    if (t[0] == '?')
        t[0] = if (t[1] == '?' || t[1] <= '1') '1' else '0'
    if (t[1] == '?')
        t[1] = if (t[0] == '1') '1' else '9'
    if (t[3] == '?')
        t[3] = '5'
    if (t[4] == '?')
        t[4] = '9'
    return String(t)
}