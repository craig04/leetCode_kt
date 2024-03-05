package cn_solution

import kotlin.math.abs

fun cycleLengthQueries(n: Int, queries: Array<IntArray>): IntArray {
    return IntArray(queries.size) {
        var (a, b) = queries[it]
        val diff = abs(b.countLeadingZeroBits() - a.countLeadingZeroBits())
        if (a < b)
            b = b.shr(diff)
        else
            a = a.shr(diff)
        diff + 1 + 2 * (32 - a.xor(b).countLeadingZeroBits())
    }
}