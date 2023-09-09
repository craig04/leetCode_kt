package cn_lcr

fun maxProduct(words: Array<String>): Int {
    val mask = IntArray(words.size) {
        words[it].fold(0) { bits, c -> 1.shl(c - 'a').or(bits) }
    }
    return (0 until mask.lastIndex).maxOf { i ->
        (i + 1 until mask.size).maxOf { j ->
            if (mask[i] and mask[j] == 0) (words[i].length * words[j].length) else 0
        }
    }
}