package cn_solution

fun invalidTransactions(transactions: Array<String>): List<String> {

    class Transaction(
        val name: String,
        val city: String,
        val time: Int,
        val money: Int,
        val index: Int
    )

    val n = transactions.size
    val t = Array(n) {
        val s = transactions[it].split(",")
        Transaction(s[0], s[3], s[1].toInt(), s[2].toInt(), it)
    }
    t.sortWith(compareBy({ it.name }, { it.time }))
    val ans = ArrayList<String>()
    var i = 0
    var j = 0
    while (i != n) {
        while (j != n && t[j].name == t[i].name)
            j++
        val cnt = HashMap<String, Int>()
        var l = i
        var r = i
        for (k in i until j) {
            while (t[k].time - t[l].time > 60)
                cnt.merge(t[l++].city, -1) { a, b -> if (a + b == 0) null else a + b }
            while (r != j && t[r].time - t[k].time <= 60)
                cnt.merge(t[r++].city, 1, Int::plus)
            if (t[k].money > 1000 || cnt.size >= 2)
                ans.add(transactions[t[k].index])
        }
        i = j
    }
    return ans
}