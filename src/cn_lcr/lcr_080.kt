package cn_lcr

fun combine(n: Int, k: Int): List<List<Int>> {
    val result = ArrayList<List<Int>>()
    for (i in 0 until 1.shl(n)) {
        if (i.countOneBits() != k)
            continue
        result.add((0 until n).asSequence()
            .filter { 1.shl(it).and(i) != 0 }
            .map { it + 1 }
            .toList())
    }
    return result
}