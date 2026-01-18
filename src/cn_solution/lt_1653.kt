package cn_solution

fun minimumDeletions(s: String): Int {
    var del = s.count { it == 'a' }
    return s.fold(del) { ans, c ->
        del += 2 * (c - 'a') - 1
        minOf(ans, del)
    }
}