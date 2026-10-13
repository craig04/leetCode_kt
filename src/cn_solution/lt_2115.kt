package cn_solution

fun findAllRecipes(recipes: Array<String>, ingredients: List<List<String>>, supplies: Array<String>): List<String> {
    val map = HashMap<String, HashSet<String>>()
    val deg = HashMap<String, Int>()
    for (i in recipes.indices) {
        for (ingredient in ingredients[i])
            map.getOrPut(ingredient) { HashSet() } += recipes[i]
        deg[recipes[i]] = ingredients[i].size
    }
    val q = supplies.mapTo(ArrayDeque()) { it }
    val ans = ArrayList<String>()
    while (q.isNotEmpty()) {
        val x = q.removeFirst()
        for (y in map[x] ?: emptyList())
            if (deg.merge(y, -1, Int::plus) == 0) {
                q += y
                ans += y
            }
    }
    return ans
}