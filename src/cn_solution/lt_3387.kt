package cn_solution

fun maxAmount(
    initialCurrency: String,
    pairs1: List<List<String>>,
    rates1: DoubleArray,
    pairs2: List<List<String>>,
    rates2: DoubleArray
): Double {
    fun directRates(pairs: List<List<String>>, rates: DoubleArray): Map<String, Double> {
        val g = HashMap<String, ArrayList<Pair<String, Double>>>()
        pairs.forEachIndexed { i, (s, t) ->
            val rate = rates[i]
            g.getOrPut(s) { ArrayList() }.add(Pair(t, rate))
            g.getOrPut(t) { ArrayList() }.add(Pair(s, 1.0 / rate))
        }
        val ans = HashMap<String, Double>()
        ans[initialCurrency] = 1.0
        val q = ArrayDeque<String>()
        q.addLast(initialCurrency)
        while (q.isNotEmpty()) {
            val c = q.removeFirst()
            val a = ans[c] ?: 1.0
            for ((t, r) in g[c] ?: emptyList())
                if (ans.putIfAbsent(t, a * r) == null)
                    q.addLast(t)
        }
        return ans
    }

    val map1 = directRates(pairs1, rates1)
    val map2 = directRates(pairs2, rates2)
    return map2.maxOf { (c, r) -> (map1[c] ?: 0.0) / r }
}