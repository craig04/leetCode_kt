package cn_solution

fun titleToNumber(columnTitle: String): Int {
    return columnTitle.fold(0) { ans, c -> c - 'A' + 1 + ans * 26 }
}