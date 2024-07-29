package cn_solution

fun findNumOfValidWords(words: Array<String>, puzzles: Array<String>): List<Int> {
    fun String.toBits() = fold(0) { bits, c -> 1.shl(c - 'a').or(bits) }
    val cnt = words.groupingBy { it.toBits() }.eachCountTo(HashMap())
    return puzzles.map { puzzle ->
        val require = 1.shl(puzzle[0] - 'a')
        val bits = puzzle.toBits().xor(require)
        var temp = bits
        var ans = 0
        do {
            ans += cnt[temp or require] ?: 0
            temp = bits.and(temp - 1)
        } while (temp != bits)
        ans
    }
}