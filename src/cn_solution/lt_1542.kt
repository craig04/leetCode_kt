package cn_solution

fun longestAwesome(s: String): Int {
    val pos = IntArray(1024) { Int.MAX_VALUE }
    pos[0] = -1
    var mask = 0
    return s.indices.maxOf { i ->
        mask = 1.shl(s[i] - '0').xor(mask)
        pos[mask] = minOf(pos[mask], i)
        i - minOf(pos[mask], (0..9).minOf { pos[1.shl(it).xor(mask)] })
    }
}