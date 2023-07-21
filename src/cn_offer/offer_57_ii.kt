package cn_offer

fun findContinuousSequence(target: Int): Array<IntArray> {
    val result = ArrayList<IntArray>()
    for (len in 2..Int.MAX_VALUE) {
        val r = target - (len - 1) * len / 2
        if (r <= 0)
            break
        if (r % len != 0)
            continue
        val start = r / len
        result.add(IntArray(len) { start + it })
    }
    return Array(result.size) { result[result.size - 1 - it] }
}