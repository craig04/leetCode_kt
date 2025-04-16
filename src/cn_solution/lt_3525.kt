package cn_solution

fun resultArray(nums: IntArray, k: Int, queries: Array<IntArray>): IntArray {

    class Node(var mul: Int = 1, var cnt: IntArray = IntArray(k))

    val n = nums.size
    val nodes = Array(n * 4 + 5) { Node() }

    fun merge(a: Node, b: Node, c: Node) {
        c.mul = a.mul * b.mul % k
        c.cnt.fill(0)
        for (i in 0 until k) {
            c.cnt[i] += a.cnt[i]
            c.cnt[a.mul * i % k] += b.cnt[i]
        }
    }

    fun init(i: Int, l: Int, r: Int) {
        nodes[i].run {
            if (l == r) {
                mul = nums[l] % k
                cnt.fill(0)
                cnt[mul] = 1
            } else {
                val m = (l + r) shr 1
                val x = i * 2 + 1
                val y = i * 2 + 2
                init(x, l, m)
                init(y, m + 1, r)
                merge(nodes[x], nodes[y], this)
            }
        }
    }

    fun update(i: Int, l: Int, r: Int, idx: Int, num: Int) {
        nodes[i].run {
            if (l == r) {
                mul = num % k
                cnt.fill(0)
                cnt[mul] = 1
            } else {
                val m = (l + r) shr 1
                val x = i * 2 + 1
                val y = i * 2 + 2
                if (idx <= m)
                    update(x, l, m, idx, num)
                else
                    update(y, m + 1, r, idx, num)
                merge(nodes[x], nodes[y], this)
            }
        }
    }

    fun query(idx: Int, l: Int, r: Int, low: Int, high: Int): Node {
        if (l == low && r == high)
            return nodes[idx]
        val m = (l + r) shr 1
        val x = idx * 2 + 1
        val y = idx * 2 + 2
        return when {
            high <= m -> query(x, l, m, low, high)
            low > m -> query(y, m + 1, r, low, high)
            else -> {
                val a = query(x, l, m, low, m)
                val b = query(y, m + 1, r, m + 1, high)
                Node().apply { merge(a, b, this) }
            }
        }
    }

    init(0, 0, n - 1)
    return IntArray(queries.size) {
        val (pos, num, start, x) = queries[it]
        update(0, 0, n - 1, pos, num)
        query(0, 0, n - 1, start, n - 1).cnt[x]
    }
}