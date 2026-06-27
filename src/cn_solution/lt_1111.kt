package cn_solution

fun maxDepthAfterSplit(seq: String): IntArray {
    return IntArray(seq.length) { i ->
        (if (seq[i] == '(') 0 else 1).xor(i % 2)
    }
}