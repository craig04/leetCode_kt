package cn_solution

fun findProductsOfElements(queries: Array<LongArray>): IntArray {
    fun disassemble(n: Long, cnt: LongArray): Long {
        var ans = 0L
        val m = (n + 1)
        var pos = 0
        cnt.fill(0)
        while (true) {
            val bit = 1L shl pos
            if (bit > n)
                break
            val x = m / (bit * 2)
            val y = m % (bit * 2)
            val z = x * bit + maxOf(0, y - bit)
            ans += z
            cnt[pos++] = z
        }
        return ans
    }

    fun calculate(n: Long): LongArray {
        val cnt = LongArray(64)
        var l = 0L
        var r = n
        var bits: Long
        while (l != r) {
            val m = (l + r + 1) shr 1
            bits = disassemble(m, cnt)
            if (bits > n + 1)
                r = m - 1
            else
                l = m
        }
        bits = disassemble(l, cnt)
        var next = l + 1
        while (bits++ < n + 1) {
            cnt[next.countTrailingZeroBits()]++
            next = next.and(next - 1)
        }
        return cnt
    }

    fun fastPow(n: Long, x: Long, modulo: Long): Long {
        var ans = 1L
        var tmp = n % modulo
        var t = x
        while (t != 0L) {
            if (t and 1 == 1L)
                ans = (ans * tmp) % modulo
            tmp = tmp * tmp % modulo
            t = t shr 1
        }
        return ans
    }
    return IntArray(queries.size) {
        val (from, to, modulo) = queries[it]
        val cnt = calculate(to)
        if (from != 0L) {
            val sub = calculate(from - 1)
            for (i in cnt.indices)
                cnt[i] -= sub[i]
        }
        cnt.indices.fold(1L) { acc, i ->
            acc * fastPow(1L.shl(i), cnt[i], modulo) % modulo
        }.toInt()
    }
}