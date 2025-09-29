package cn_solution

fun displayTable(orders: List<List<String>>): List<List<String>> {
    val tables = HashMap<Int, HashMap<String, Int>>()
    val foods = HashSet<String>()
    for ((_, table, food) in orders) {
        tables.computeIfAbsent(table.toInt()) { HashMap() }.merge(food, 1, Int::plus)
        foods.add(food)
    }
    val header = arrayListOf("Table")
    header.addAll(foods.sortedBy { it })
    val ans = arrayListOf(header)
    for ((table, map) in tables.entries.sortedBy { it.key }) {
        val row = arrayListOf("" + table)
        header.subList(1, header.size).mapTo(row) { "" + (map[it] ?: 0) }
        ans.add(row)
    }
    return ans
}