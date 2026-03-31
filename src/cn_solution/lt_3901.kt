package cn_solution

fun countGoodSubseq(nums: IntArray, p: Int, queries: Array<IntArray>): Int {
    val n = nums.size
    val a = IntArray(1.shl(33 - (n - 1).countLeadingZeroBits()))
    fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

    fun refresh(i: Int) {
        a[i] = gcd(a[i * 2 + 1], a[i * 2 + 2])
    }

    fun init(i: Int, l: Int, r: Int) {
        if (l == r) {
            if (nums[l] % p == 0)
                a[i] = nums[l]
            return
        }
        val m = (l + r) shr 1
        init(i * 2 + 1, l, m)
        init(i * 2 + 2, m + 1, r)
        refresh(i)
    }

    fun query(i: Int, l: Int, r: Int, ql: Int, qr: Int): Int {
        if (ql > qr || ql > r || qr < l)
            return 0
        if (ql <= l && r <= qr)
            return a[i]
        val m = (l + r) shr 1
        return gcd(
            query(i * 2 + 1, l, m, ql, qr),
            query(i * 2 + 2, m + 1, r, ql, qr)
        )
    }

    fun update(i: Int, l: Int, r: Int, pos: Int, x: Int) {
        if (l == r) {
            a[i] = if (x % p == 0) x else 0
            return
        }
        val m = (l + r) shr 1
        if (pos <= m)
            update(i * 2 + 1, l, m, pos, x)
        else
            update(i * 2 + 2, m + 1, r, pos, x)
        refresh(i)
    }

    fun query(ql: Int, qr: Int) = query(0, 0, n - 1, ql, qr)
    fun check(): Boolean = (0 until n).any { i ->
        gcd(query(0, i - 1), query(i + 1, n - 1)) == p
    }

    init(0, 0, n - 1)
    var cnt = nums.count { it % p == 0 }
    return queries.count { (i, x) ->
        if (nums[i] % p == 0)
            cnt--
        if (x % p == 0)
            cnt++
        nums[i] = x
        update(0, 0, n - 1, i, x)
        a[0] == p && (cnt != n || n > 6 || check())
    }
}