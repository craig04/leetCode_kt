package solution

fun maxDepthAfterSplit(seq: String): IntArray {

    return IntArray(seq.length) { if (seq[it] == '(') (it and 1) else (1 - it and 1) }
}