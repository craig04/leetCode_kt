package cn_solution

fun maxDepthAfterSplit(seq: String): IntArray {
    return IntArray(seq.length) { i ->
        seq[i].code.xor(i % 2).and(1)
    }
}