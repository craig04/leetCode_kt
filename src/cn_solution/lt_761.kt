package cn_solution

fun makeLargestSpecial(s: String): String {
    val subs = ArrayList<String>()
    var diff = 0
    var l = 0
    for (r in s.indices) {
        if (s[r] == '1')
            ++diff
        else if (--diff == 0) {
            subs.add("1${makeLargestSpecial(s.substring(l + 1, r))}0")
            l = r + 1
        }
    }
    subs.sortDescending()
    return subs.joinToString("")
}