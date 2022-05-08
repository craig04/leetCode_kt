package cn_solution

fun nextGreatestLetter(letters: CharArray, target: Char): Char {
    if (target < letters.first() || target >= letters.last()) {
        return letters.first()
    }
    var l = 0
    var r = letters.lastIndex
    while (l != r) {
        val m = (l + r) shr 1
        val c = letters[m]
        if (c > target) r = m else l = m + 1
    }
    return letters[l]
}