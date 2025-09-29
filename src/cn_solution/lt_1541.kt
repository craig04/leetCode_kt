package cn_solution

private fun minInsertions(s: String): Int {
    var insertions = 0
    var left = 0
    for (c in s) {
        if (c == '(') {
            if (left % 2 == 1) {
                left--
                insertions++
            }
            left += 2
        } else {
            if (left == 0) {
                left += 2
                insertions++
            }
            left--
        }
    }
    return insertions + left
}