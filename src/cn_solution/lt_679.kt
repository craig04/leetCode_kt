package cn_solution

import kotlin.math.abs

fun judgePoint24(cards: IntArray): Boolean {
    fun Double.zero() = abs(this) < 1e-6
    fun judge(x: DoubleArray): Boolean {
        if (x.size == 1)
            return (x[0] - 24).zero()
        val y = DoubleArray(x.size - 1)
        for (i in x.indices)
            for (j in i + 1 until x.size) {
                var t = 0
                for (k in x.indices)
                    if (k != i && k != j)
                        y[t++] = x[k]
                val a = x[i]
                val b = x[j]
                val res = arrayListOf(a + b, a - b, b - a, a * b)
                if (!a.zero())
                    res.add(b / a)
                if (!b.zero())
                    res.add(a / b)
                if (res.any { judge(y.apply { this[t] = it }) })
                    return true
            }
        return false
    }
    return judge(DoubleArray(4) { cards[it] + 0.0 })
}